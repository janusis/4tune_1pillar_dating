package sajudating.jpadating.domainDto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import sajudating.jpadating.domain.Gender;
import sajudating.jpadating.domain.Member;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class MemberDTO {


    private Long id;
    @NotBlank(message = "아이디에 공백이 포함 되어 있습니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    private String pw;
    @NotBlank(message = "이름에 공백이 포함 되어 있습니다.")
    private String name;
    @NotEmpty
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
    @NotBlank(message = "올바른 휴대전화 번호가 아닙니다")
    @Pattern(regexp = "^01(0|1|[6-9])-(\\d{3}|\\d{4})-\\d{4}$",message = "올바른 휴대전화 형식이 아닙니다.")
    private String phone;
    //@NOT EMPTY나 @NOT NULL 등은 각 타입별로 validator가 존재하는데 date타입은 validator가 없기 때문에 @NOT NULL 등을 적용시 오류발생
    //ENUM 타입도 마찬가지
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String birthTime;
    private String nickname;
    private String dayPillar;
    @Enumerated(EnumType.STRING)
    public Gender gender;


    private String homeLotNumAddress;
    private String homeRoadNameAddress;
    private String homeDetail_address;
    private String homeZipcode;

    private String companyLotNumAddress;
    private String companyRoadNameAddress;
    private String companyDetail_address;
    private String companyZipcode;

    @Builder
    public MemberDTO(String userId, String pw, String name,
                     String email, String phone, LocalDate birthday,
                     String birthTime, String nickname, String dayPillar,
                     Gender gender, String homeLotNumAddress, String homeRoadNameAddress,
                     String homeDetail_address, String homeZipcode, String companyLotNumAddress,
                     String companyRoadNameAddress, String companyDetail_address, String companyZipcode) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.birthTime = birthTime;
        this.nickname = nickname;
        this.dayPillar = dayPillar;
        this.gender = gender;
        this.homeLotNumAddress = homeLotNumAddress;
        this.homeRoadNameAddress = homeRoadNameAddress;
        this.homeDetail_address = homeDetail_address;
        this.homeZipcode = homeZipcode;
        this.companyLotNumAddress = companyLotNumAddress;
        this.companyRoadNameAddress = companyRoadNameAddress;
        this.companyDetail_address = companyDetail_address;
        this.companyZipcode = companyZipcode;
    }

    public MemberDTO toEntity(Member member) {
        this.userId = member.getUserId();
        this.pw = member.getPw();
        this.name = member.getName();
        this.email = member.getEmail();
        this.phone = member.getPhone();
        this.birthday = member.getBirthday();
        this.birthTime = member.getBirthTime();
        this.nickname = member.getNickname();
        this.dayPillar = member.getDayPillar();
        this.gender = member.getGender();
        this.homeLotNumAddress = member.getHomeAddress().getLotNumAddress();
        this.homeRoadNameAddress = member.getHomeAddress().getRoadNameAddress();
        this.homeDetail_address = member.getHomeAddress().getDetail_address();
        this.homeZipcode = member.getHomeAddress().getZipcode();
        this.companyLotNumAddress = member.getCompanyAddress().getLotNumAddress();
        this.companyRoadNameAddress = member.getCompanyAddress().getRoadNameAddress();
        this.companyDetail_address = member.getCompanyAddress().getDetail_address();
        this.companyZipcode = member.getCompanyAddress().getZipcode();
        return this;
    }

}
