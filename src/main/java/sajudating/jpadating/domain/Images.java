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
    private Boards boards;

    private String originFileName;

    private String fileName;

    private String filePath;

    private String urlPath;


    @Builder
    public Images(Long id, Boards boards, String originFileName, String fileName, String filePath, String urlPath) {
        this.id = id;
        this.boards = boards;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.urlPath = urlPath;
    }



}
