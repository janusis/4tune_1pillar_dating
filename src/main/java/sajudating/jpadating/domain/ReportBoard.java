package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class ReportBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_board_id")
    private Long id;

    @ManyToOne(targetEntity = Boards.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Boards boards;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_member_member_id")
    private Member reportMember;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name ="reported_member_member_id")
    private Member reportedMember;

    private String reportContext;
}
