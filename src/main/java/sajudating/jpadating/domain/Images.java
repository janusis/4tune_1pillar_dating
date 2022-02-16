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
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "member_id")
    private Member member;

    @Lob
    @Column(name = "image")
    private Blob image;



}
