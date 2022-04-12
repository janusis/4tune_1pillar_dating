package sajudating.jpadating.domain;

import com.mysql.cj.jdbc.Clob;
import lombok.Builder;
import lombok.Getter;
import sajudating.jpadating.domainDto.BoardDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private Long rowNum;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Lob
    @Column(columnDefinition = "longtext")
    private Clob context;

    private Long views;
    private Long good;
    private Long bad;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @OneToMany(mappedBy = "board")
    private List<Images> imagesBoardList= new ArrayList<>();

    @OneToMany(mappedBy = "boardId")
    private List<ReportBoard> reportBoardList= new ArrayList<>();

    private Long reportConut;

    protected Board(){

    }

    @Builder
    public Board(String title, Member member, LocalDateTime pubTime, LocalDateTime modTime,
                 Clob context, Long views, Long good, Long bad, BoardType boardType,
                  Long reportConut) {
        this.title = title;
        this.member = member;
        this.pubTime = pubTime;
        this.modTime = modTime;
        this.context = context;
        this.views = views;
        this.good = good;
        this.bad = bad;
        this.boardType = boardType;
        this.reportConut = reportConut;
    }
    private void changeTitle(String title){
        if(title!=null)
            this.title=title;
    }
    private void changeMember(Member member){
        if(member!=null)
            this.member=member;
    }
    private void changeModTime(LocalDateTime modTime){
        if(modTime!=null)
            this.modTime=modTime;
    }
    private void changeContext(Clob context){
        if(context!=null)
            this.context=context;
    }
    private void changeView(Long views){
        if(views!=null)
            this.views=views;
    }
    private void changeGood(Long good){
        if(good!=null)
            this.good=good;
    }
    private void changeContext(Long bad){
        if(bad!=null)
            this.bad=bad;
    }
    private void changeBoardType(BoardType boardType){
        if(boardType!=null)
            this.boardType=boardType;
    }
    private void changeImagesBoardList(List<Images> imagesBoardList){
        if(imagesBoardList!=null)
            this.imagesBoardList=imagesBoardList;
    }
    private void changeReportBoardList(Long reportConut){
        if(reportConut!=null)
            this.reportConut=reportConut;
    }

    public void updateBoard(BoardDTO boardDTO){
        changeTitle(boardDTO.getTitle());
        changeMember(boardDTO.getMember());
        changeModTime(java.time.LocalDateTime.now());
        changeContext(boardDTO.getContext());
        changeBoardType(boardDTO.getBoardType());
    }



}
