package sajudating.jpadating.domainDto;

import lombok.Builder;
import lombok.Data;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Image;


@Data
public class ImageDTO {



    private Long id;


    private Long boardId;

    private String originFileName;

    private String fileName;

    private String filePath;

    public Image toEntity(Board borad){
        return Image.builder().id(id).board(borad).fileName(fileName).filePath(filePath).originFileName(originFileName).build();
    }


    public ImageDTO(Image image) {
        this.id = image.getId();
        this.boardId = image.getBoard().getId();
        this.originFileName = image.getOriginFileName();
        this.fileName = image.getFileName();
        this.filePath = image.getFilePath();
    }
    @Builder
    public ImageDTO(Long id, Long boardId, String originFileName, String fileName, String filePath) {
        this.id = id;
        this.boardId = boardId;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }
}
