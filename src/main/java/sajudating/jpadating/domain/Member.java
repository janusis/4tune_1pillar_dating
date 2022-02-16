package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String userId;

    private String pw;

    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String joinday;
    private String nickname;
    private LocalDateTime modifiedDate;



    @Embedded
    @AttributeOverride(name = "lotNumAddress", column = @Column(name="home_lotNumAddress"))
    @AttributeOverride(name = "roadNameAddress", column = @Column(name="home_roadNameAddress"))
    @AttributeOverride(name = "detail_address", column = @Column(name="home_detail_address"))
    @AttributeOverride(name = "zipcode", column = @Column(name="home_zipcode"))
    private Address homeAddress;

    @Embedded
    @AttributeOverride(name = "lotNumAddress", column = @Column(name="company_lotNumAddress"))
    @AttributeOverride(name = "roadNameAddress", column = @Column(name="company_roadNameAddress"))
    @AttributeOverride(name = "detail_address", column = @Column(name="company_detail_address"))
    @AttributeOverride(name = "zipcode", column = @Column(name="company_zipcode"))
    private Address companyAddress;

    @OneToMany(mappedBy = "member")
    private List<Images> imagesList;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList;





}
