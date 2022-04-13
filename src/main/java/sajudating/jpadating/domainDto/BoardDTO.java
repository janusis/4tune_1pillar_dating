package sajudating.jpadating.domainDto;


import com.mysql.cj.jdbc.Clob;
import lombok.*;
import sajudating.jpadating.domain.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


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


//    private List<Images> imagesBoardList= new ArrayList<>();
//
//
//    private List<ReportBoard> reportBoardList= new ArrayList<>();

    private Long reportCount;


    public BoardDTO(Board board){

        this.id=board.getId();
        this.title = board.getTitle();
        this.memberId = board.getMember().getId();
        this.memberNickName=board.getMember().getNickname();
        this.pubTime = board.getPubTime();
        this.modTime = board.getModTime();
        this.context = board.getContext();
        this.views = board.getViews();
        this.good = board.getGood();
        this.bad = board.getBad();
        this.boardType = board.getBoardType();
        this.reportCount = board.getReportCount();
    }
}
