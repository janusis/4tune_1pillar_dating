package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Image;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.ImageDTO;
import sajudating.jpadating.generator.MD5Generator;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class ImageService {

    private final ImageRepository imageRepository;
    private final BoardRepository boardRepository;

    public ImageService(ImageRepository imageRepository, BoardRepository boardRepository) {
        this.imageRepository = imageRepository;
        this.boardRepository = boardRepository;
    }

    public Long countUp(Long number){
        return number+1;
    }


    //이미지 저장
    public void saveImage(List<MultipartFile> images,Long boardId){
        //경로 설정을 위한 코드....
        Board board = boardRepository.findById(boardId);
        images.forEach(i-> {
            try {
                LocalDateTime now = LocalDateTime.now();
                String nowString = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String originalFilename = i.getOriginalFilename();
                int idx = originalFilename.lastIndexOf(".");
                String fileExtension = originalFilename.substring(idx);
                String temp = "board" + boardId + "_" + nowString;
                String fileName = new MD5Generator(temp).toString();

                String savePath = System.getProperty("user.dir") + "\\img\\";
                if (!new File(savePath).exists()) {
                    try {
                        new File(savePath).mkdir();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
                //1.물리적인 저장을 한다
                String filePath = savePath + fileName + fileExtension;
                String dbFilePath = "http://localhost:8080/v1/api/image/"+ fileName + fileExtension;
                i.transferTo(new File(filePath));

                Image image = Image.builder().
                        board(board).
                        fileName(fileName).
                        originFileName(originalFilename).
                        filePath(dbFilePath).
                        build();

                //2.논리적인(=엔티티) 저장
                Long imageId = imageRepository.save(image);

                //3.양방향 매핑
                board.addImageList(image);
            }catch (Exception e){
                e.getStackTrace();
            }



        });






    }

    //이미지 조회

    //이미지 이름을 통한 조회

    //이미지 수정

    //이미지 삭제
}
