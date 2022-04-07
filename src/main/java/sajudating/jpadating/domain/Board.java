package sajudating.jpadating.domain;

import com.mysql.cj.jdbc.Clob;
import com.mysql.cj.jdbc.NClob;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    public Board(String title, Member member, LocalDateTime pubTime, LocalDateTime modTime,
                 Clob context, Long views, Long good, Long bad, BoardType boardType,
                 List<Images> imagesBoardList, List<ReportBoard> reportBoardList, Long reportConut) {
        this.title = title;
        this.member = member;
        this.pubTime = pubTime;
        this.modTime = modTime;
        this.context = context;
        this.views = views;
        this.good = good;
        this.bad = bad;
        this.boardType = boardType;
        this.imagesBoardList = imagesBoardList;
        this.reportBoardList = reportBoardList;
        this.reportConut = reportConut;
    }
}
