package sajudating.jpadating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sajudating.jpadating.domainDto.MemberDTO;

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


    @Id @GeneratedValue
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


    private void changePw(String pw){
        if(pw!=null)
            this.pw=pw;
    }
    private void changeName(String name){
        if(name!=null)
            this.name=name;
    }
    private void changeEmail(String email){
        if(email!=null)
            this.email=email;
    }
    private void changePhone(String phone){
        if(phone!=null)
            this.phone=phone;
    }
    private void changeBirthday(LocalDate birthday){
        if(birthday!=null)
            this.birthday=birthday;
    }
    private void changeBirthTime(String birthTime){
        if(birthTime!=null)
            this.birthTime=birthTime;
    }
    private void changeNickname(String nickname){
        if(nickname!=null)
            this.nickname=nickname;
    }
    private void changeGender(Gender gender){
        if(gender!=null)
            this.gender=gender;
    }
    private void changeHomeAddress(Address homeAddress){
        if(homeAddress!=null)
            this.homeAddress=homeAddress;
    }
    private void changeCompanyAddress(Address companyAddress){
        if(companyAddress!=null)
            this.companyAddress=companyAddress;
    }
    private void changeModifiedDate(LocalDateTime modifiedDate){
        if(modifiedDate!=null)
            this.modifiedDate=modifiedDate;
    }

    public Long updateMember(MemberDTO memberDTO){
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
    }




}

