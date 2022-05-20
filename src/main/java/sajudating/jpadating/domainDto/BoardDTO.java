package sajudating.jpadating.domainDto;


import lombok.*;
import sajudating.jpadating.domain.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardDTO {


    private Long id;
    private Long rowNum;
    @NotEmpty
    private String title;

    //member 필드 내용
    private Long memberId;
    private String memberNickName;

//    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Lob
    @NotEmpty
    private String context;

    private Long views;
    private Long good;
    private Long bad;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;


    private List<CommentDTO> comments = new ArrayList<>();


    private List<ImagesDTO> imageList = new ArrayList<>();
//
//
//    private List<ReportBoard> reportBoardList= new ArrayList<>();


    private Long reportCount;


    public BoardDTO(Boards boards) {

        this.id = boards.getId();
        this.rowNum = boards.getRowNum();
        this.title = boards.getTitle();
        this.memberId = boards.getMember().getId();
        this.memberNickName = boards.getMember().getNickname();
        this.pubTime = boards.getPubTime();
        this.modTime = boards.getModTime();
        this.context = boards.getContext();
        this.views = boards.getViews();
        this.good = boards.getGood();
        this.bad = boards.getBad();
        this.boardType = boards.getBoardType();
        if (boards.getComments() != null) {
            boards.getComments().stream().forEach(c -> {
                CommentDTO commentDTO = new CommentDTO(c);
                this.comments.add(commentDTO);
            });
        }
        if (boards.getImageList() != null) {
            boards.getImageList().stream().forEach(image -> {
                ImagesDTO imageDTO = new ImagesDTO(image);
                this.imageList.add(imageDTO);
            });
        }
        this.reportCount = boards.getReportCount();
    }
}
