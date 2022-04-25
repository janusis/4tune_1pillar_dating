package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Image;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.ImageDTO;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final BoardRepository boardRepository;

    public ImageService(ImageRepository imageRepository, BoardRepository boardRepository) {
        this.imageRepository = imageRepository;
        this.boardRepository = boardRepository;
    }


    //이미지 저장
    public void saveImage(List<MultipartFile> images,Long boardId){
        //경롱 설정을 위한 코드....

        //1.물리적인 저장을 한다
        images.get(0).transferTo(path);

        //2.논리적인(=엔티티) 저장
       imageRepository.save(new Image("파라미터 ....."));

        //3. 만약 Board랑 생명주기가 같다면
        //BoardImage의 mappedBy된 리스트에
       add(this);

        ...




    }

    //이미지 조회

    //이미지 수정

    //이미지 삭제
}
