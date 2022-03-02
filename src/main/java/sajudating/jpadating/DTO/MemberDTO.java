package sajudating.jpadating.DTO;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sajudating.jpadating.domain.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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


    public MemberDTO(String userId, String pw, String name, String email, String phone, LocalDate birthday,
                     String birthTime, String nickname, Gender gender, String homeLotNumAddress, String homeRoadNameAddress,
                     String homeDetail_address, String homeZipcode, String companyLotNumAddress, String companyRoadNameAddress,
                     String companyDetail_address, String companyZipcode) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.birthTime = birthTime;
        this.nickname = nickname;
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
