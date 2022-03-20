package sajudating.jpadating.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sajudating.jpadating.domain.Gender;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {

    private String userId;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String birthTime;
    private String nickname;
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
