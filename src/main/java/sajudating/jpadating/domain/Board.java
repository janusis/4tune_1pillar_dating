package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
public class Board {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER")
    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Column(columnDefinition = "LONGTEXT")
    private String context;

    private Long views;
    private Long good;
    private Long bad;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;





}
