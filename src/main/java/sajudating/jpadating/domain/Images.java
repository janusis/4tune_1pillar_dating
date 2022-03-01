package sajudating.jpadating.domain;

import com.mysql.cj.jdbc.Blob;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
public class Images {
    @Id @GeneratedValue
    @Column(name = "images_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "board_id")
    private Board board;

    @Lob
    @Column(name = "image")
    private Blob image;



}
