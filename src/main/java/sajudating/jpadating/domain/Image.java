package sajudating.jpadating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sajudating.jpadating.domainDto.ImageDTO;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "board_id")
    private Board board;

    private String originFileName;

    private String fileName;

    private String filePath;


    @Builder
    public Image(Long id, Board board, String originFileName, String fileName, String filePath) {
        this.id = id;
        this.board = board;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
    }



}
