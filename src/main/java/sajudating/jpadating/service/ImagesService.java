package sajudating.jpadating.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sajudating.jpadating.apiResponse.exception.ErrorCode;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Images;
import sajudating.jpadating.exception.FileIOException;
import sajudating.jpadating.exception.FileSaveException;
import sajudating.jpadating.exception.NotFoundException;
import sajudating.jpadating.generator.MD5Generator;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.ImagesRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class ImagesService {

    private final ImagesRepository imagesRepository;
    private final BoardRepository boardRepository;

    public ImagesService(ImagesRepository imagesRepository, BoardRepository boardRepository) {
        this.imagesRepository = imagesRepository;
        this.boardRepository = boardRepository;
    }

    //카운트 업
    public Long countUp(Long number){
        return number+1;
    }



    //이미지 저장
    public void saveImage(List<MultipartFile> file,Long boardId){
        //경로 설정을 위한 코드....
        Board board = boardRepository.findById(boardId);
        if(!board.getImageList().isEmpty()){
            board.getImageList().forEach(i->{

                try {
                    imagesRepository.delete(i.getId());
                } catch (IOException e) {
                    throw new FileIOException(ErrorCode.FILE_NOT_FOUND);
                }

            });
        }
        file.forEach(i-> {
            try {
                LocalDateTime now = LocalDateTime.now();
                String nowString = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
                String originalFilename = i.getOriginalFilename();
                int idx = originalFilename.lastIndexOf(".");
                String fileExtension = originalFilename.substring(idx);
                String temp = "board" + boardId + "_" + nowString;
                String fileName = new MD5Generator(temp).toString() + fileExtension;

                String savePath = System.getProperty("user.dir") + "\\img\\";
                if (!new File(savePath).exists()) {
                    try {
                        new File(savePath).mkdir();
                    } catch (Exception e) {
                        throw new NotFoundException(ErrorCode.DIRECTORY_NOT_FOUND);
                    }
                }
                //1.물리적인 저장을 한다
                String filePath = savePath + fileName;
                String urlPath = "http://localhost:8080/v1/api/images/"+ fileName;
                i.transferTo(new File(filePath));

                Images images = Images.builder().
                        board(board).
                        fileName(fileName).
                        originFileName(originalFilename).
                        filePath(filePath).
                        urlPath(urlPath).
                        build();

                //2.논리적인(=엔티티) 저장
                Long imageId = imagesRepository.save(images);

                //3.양방향 매핑
                board.addImageList(images);
            }catch (Exception e){
                throw new FileSaveException(ErrorCode.FILE_SAVE_EXCEPTION);
            }
        });
    }

    //이미지 urlPath를 통한 조회
    public Resource fileToResource(String fileName) {
        try {
            Images images = imagesRepository.findByFileName(fileName);
            Path path = Paths.get(images.getFilePath());
            Resource resource = new UrlResource(path.toUri());

            if(resource.exists()) {
                return resource;
            }else {
                throw new NotFoundException(ErrorCode.FILE_NOT_FOUND);
            }
        }catch(Exception e) {
            throw new NotFoundException(ErrorCode.FILE_NOT_FOUND);
        }
    }

}
