package sajudating.jpadating.domainDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sajudating.jpadating.domain.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {

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



}
