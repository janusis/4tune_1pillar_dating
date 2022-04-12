package sajudating.jpadating.domainDto;


import com.mysql.cj.jdbc.Clob;
import lombok.*;
import sajudating.jpadating.domain.BoardType;
import sajudating.jpadating.domain.Images;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domain.ReportBoard;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class BoardDTO {


    private Long rowNum;
    private String title;

    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Lob
    private Clob context;

    private Long views;
    private Long good;
    private Long bad;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;


    private List<Images> imagesBoardList= new ArrayList<>();


    private List<ReportBoard> reportBoardList= new ArrayList<>();

    private Long reportConut;


    public BoardDTO(Long id,String title, Member member, LocalDateTime pubTime,
                    LocalDateTime modTime, Clob context, Long views, Long good,
                    Long bad, BoardType boardType, Long reportConut) {
        this.title= title;
        this.member=member;
        this.pubTime=pubTime;
        this.modTime=modTime;
        this.context=context;
        this.views=views;
        this.good=good;
        this.bad = bad;
        this.boardType=boardType;
        this.reportConut=reportConut;

    }
}
