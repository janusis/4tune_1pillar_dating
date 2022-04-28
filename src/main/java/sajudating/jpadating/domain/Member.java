package sajudating.jpadating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.exception.DataChangeException;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;


    @NotEmpty
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
    @AttributeOverride(name = "lotNumAddress", column = @Column(name = "home_lotNumAddress"))
    @AttributeOverride(name = "roadNameAddress", column = @Column(name = "home_roadNameAddress"))
    @AttributeOverride(name = "detail_address", column = @Column(name = "home_detail_address"))
    @AttributeOverride(name = "zipcode", column = @Column(name = "home_zipcode"))
    private Address homeAddress;

    @Embedded
    @AttributeOverride(name = "lotNumAddress", column = @Column(name = "company_lotNumAddress"))
    @AttributeOverride(name = "roadNameAddress", column = @Column(name = "company_roadNameAddress"))
    @AttributeOverride(name = "detail_address", column = @Column(name = "company_detail_address"))
    @AttributeOverride(name = "zipcode", column = @Column(name = "company_zipcode"))
    private Address companyAddress;


    private LocalDateTime regDate;
    private LocalDateTime modifiedDate;

//    @OneToMany(mappedBy = "member")
//    private List<Images> imagesList=new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "member")
//    private List<Board> boardList= new ArrayList<>();


    public Member(Long id) {
        this.id = id;
    }

    @Builder
    public Member(MemberDTO memberDto) {
        this.userId = memberDto.getUserId();
        this.pw = memberDto.getPw();
        this.name = memberDto.getName();
        this.email = memberDto.getEmail();
        this.phone = memberDto.getPhone();
        this.birthday = memberDto.getBirthday();
        this.birthTime = memberDto.getBirthTime();
        this.nickname = memberDto.getNickname();
        this.gender = memberDto.getGender();
        this.homeAddress = new Address(memberDto.getHomeLotNumAddress(), memberDto.getHomeRoadNameAddress(),
                memberDto.getHomeDetail_address(), memberDto.getHomeZipcode());
        this.companyAddress = new Address(memberDto.getCompanyLotNumAddress(), memberDto.getHomeRoadNameAddress(),
                memberDto.getHomeDetail_address(), memberDto.getHomeZipcode());
        this.regDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }


    private void changePw(String pw) {
        if (pw != null)
            this.pw = pw;
    }

    private void changeName(String name) {
        if (name != null)
            this.name = name;
    }

    private void changeEmail(String email) {
        if (email != null)
            this.email = email;
    }

    private void changePhone(String phone) {
        if (phone != null)
            this.phone = phone;
    }

    private void changeBirthday(LocalDate birthday) {
        if (birthday != null)
            this.birthday = birthday;
    }

    private void changeBirthTime(String birthTime) {
        if (birthTime != null)
            this.birthTime = birthTime;
    }

    private void changeNickname(String nickname) {
        if (nickname != null)
            this.nickname = nickname;
    }

    private void changeGender(Gender gender) {
        if (gender != null)
            this.gender = gender;
    }

    private void changeHomeAddress(Address homeAddress) {
        if (homeAddress != null)
            this.homeAddress = homeAddress;
    }

    private void changeCompanyAddress(Address companyAddress) {
        if (companyAddress != null)
            this.companyAddress = companyAddress;
    }

    private void changeModifiedDate(LocalDateTime modifiedDate) {
        if (modifiedDate != null)
            this.modifiedDate = modifiedDate;
    }

    public Long updateMember(MemberDTO memberDTO)  {
        try {
            changePw(memberDTO.getPw());
            changeName(memberDTO.getName());
            changeEmail(memberDTO.getEmail());
            changePhone(memberDTO.getPhone());
            changeBirthday(memberDTO.getBirthday());
            changeBirthTime(memberDTO.getBirthTime());
            changeNickname(memberDTO.getNickname());
            changeGender(memberDTO.getGender());
            Address address1 = new Address(memberDTO.getHomeLotNumAddress(), memberDTO.getHomeRoadNameAddress(),
                    memberDTO.getHomeDetail_address(), memberDTO.getHomeDetail_address());
            changeHomeAddress(address1);
            Address address2 = new Address(memberDTO.getCompanyLotNumAddress(), memberDTO.getCompanyRoadNameAddress(),
                    memberDTO.getHomeDetail_address(), memberDTO.getCompanyZipcode());
            changeCompanyAddress(address2);
            changeModifiedDate(LocalDateTime.now());
            return this.getId();
        }catch (Exception e){
            throw new DataChangeException("데이터 변경 중 오류가 발생하였습니다.");
        }
    }


}

