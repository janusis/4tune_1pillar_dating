package sajudating.jpadating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Images {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "board_id")
    private Board board;

    private String originFileName;

    private String fileName;

    private String filePath;

    private String urlPath;


    @Builder
    public Images(Long id, Board board, String originFileName, String fileName, String filePath, String urlPath) {
        this.id = id;
        this.board = board;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.urlPath = urlPath;
    }



}
