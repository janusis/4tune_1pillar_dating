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


    public BoardDTO(Board board) {

        this.id = board.getId();
        this.rowNum = board.getRowNum();
        this.title = board.getTitle();
        this.memberId = board.getMember().getId();
        this.memberNickName = board.getMember().getNickname();
        this.pubTime = board.getPubTime();
        this.modTime = board.getModTime();
        this.context = board.getContext();
        this.views = board.getViews();
        this.good = board.getGood();
        this.bad = board.getBad();
        this.boardType = board.getBoardType();
        if (board.getComments() != null) {
            board.getComments().stream().forEach(c -> {
                CommentDTO commentDTO = new CommentDTO(c);
                this.comments.add(commentDTO);
            });
        }
        if (board.getImageList() != null) {
            board.getImageList().stream().forEach(image -> {
                ImagesDTO imageDTO = new ImagesDTO(image);
                this.imageList.add(imageDTO);
            });
        }
        this.reportCount = board.getReportCount();
    }
}
