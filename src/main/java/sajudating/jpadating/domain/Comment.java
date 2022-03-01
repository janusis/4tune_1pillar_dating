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
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "longtext")
    private String context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;


    private Long hierarchy;
    private Long orders;
    private Long groupNum;
    private LocalDateTime pubTime;
    private LocalDateTime modTime;
    private Long good;
    private Long bad;

    @OneToMany(mappedBy = "commentId")
    private List<ReportComment> reportCommentList=new ArrayList<>();

    private Long reportCount;


}
