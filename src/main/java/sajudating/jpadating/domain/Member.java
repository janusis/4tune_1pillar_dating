package sajudating.jpadating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {


    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;


    private String userId;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String birthTime;
    private String nickname;
    private String dayPillar;


    @Enumerated(EnumType.STRING)
    private Gender gender;


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


    private LocalDateTime regDate;
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "member")
    private List<Images> imagesList=new ArrayList<>();


    @OneToMany(mappedBy = "member")
    private List<Board> boardList= new ArrayList<>();



    @Builder
    public Member(String userId, String pw, String name, String email, String phone, LocalDate birthday, String birthTime,
                  String dayPillar, String nickname,
                  Gender gender, Address homeAddress, Address companyAddress,
                  LocalDateTime regDate, LocalDateTime modifiedDate) {
        this.userId=userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.birthTime = birthTime;
        this.nickname = nickname;
        this.gender = gender;
        this.homeAddress = homeAddress;
        this.companyAddress = companyAddress;
        this.regDate = regDate;
        this.modifiedDate = modifiedDate;
    }


}

