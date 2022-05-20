package sajudating.jpadating.domainDto;

import lombok.Builder;
import lombok.Data;
import sajudating.jpadating.domain.Images;


@Data
public class ImagesDTO {



//    private Long id;
//
//
//    private Long boardId;

    private String originFileName;

    private String fileName;

//    private String filePath;
    private String urlPath;

//    public Images toEntity(Board borad){
//        return Images.builder().id(id).board(borad).fileName(fileName).filePath(filePath).originFileName(originFileName).urlPath(urlPath).build();
//    }


    public ImagesDTO(Images images) {
//        this.id = images.getId();
//        this.boardId = images.getBoard().getId();
        this.originFileName = images.getOriginFileName();
        this.fileName = images.getFileName();
//        this.filePath = images.getFilePath();
        this.urlPath=images.getUrlPath();
    }
    @Builder
    public ImagesDTO(String originFileName, String fileName,  String urlPath) {
//        this.id = id;
//        this.boardId = boardId;
        this.originFileName = originFileName;
        this.fileName = fileName;
//        this.filePath = filePath;
        this.urlPath = urlPath;
    }
}
