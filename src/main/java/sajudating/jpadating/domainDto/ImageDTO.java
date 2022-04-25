package sajudating.jpadating.domainDto;

import lombok.Builder;
import lombok.Data;
import sajudating.jpadating.domain.Image;


@Data
public class ImageDTO {



    private Long id;


    private Long boardId;

    private String originFileName;

    private String fileName;

    private String filePath;


    @Builder
    public ImageDTO(Image image) {
        this.id = image.getId();
        this.boardId = image.getBoard().getId();
        this.originFileName = image.getOriginFileName();
        this.fileName = image.getFileName();
        this.filePath = image.getFilePath();
    }
}
