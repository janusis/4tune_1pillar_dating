package sajudating.jpadating.domainDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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


    private String HomeLotNumAddress;
    private String HomeRoadNameAddress;
    private String HomeDetail_address;
    private String HomeZipcode;

    private String CompanyLotNumAddress;
    private String CompanyRoadNameAddress;
    private String CompanyDetail_address;
    private String CompanyZipcode;

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
        HomeLotNumAddress = homeLotNumAddress;
        HomeRoadNameAddress = homeRoadNameAddress;
        HomeDetail_address = homeDetail_address;
        HomeZipcode = homeZipcode;
        CompanyLotNumAddress = companyLotNumAddress;
        CompanyRoadNameAddress = companyRoadNameAddress;
        CompanyDetail_address = companyDetail_address;
        CompanyZipcode = companyZipcode;
    }
}
