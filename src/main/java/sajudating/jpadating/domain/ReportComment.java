package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class ReportComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_comment_id")
    private Long id;

    @ManyToOne(targetEntity = Comment.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Long commentId;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_member_member_id")
    private Member reportMember;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_member_member_id")
    private Member reportedMember;

    private String reportContext;


}
