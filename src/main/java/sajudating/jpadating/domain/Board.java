package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Column(columnDefinition = "longtext")
    private String context;

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



}
