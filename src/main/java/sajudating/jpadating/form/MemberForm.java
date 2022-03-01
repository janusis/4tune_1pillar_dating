package sajudating.jpadating.form;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class MemberForm {

    private String userId;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String birthTime;
    private String nickname;
    public String gender;


    private String HomeLotNumAddress;
    private String HomeRoadNameAddress;
    private String HomeDetail_address;
    private String HomeZipcode;

    private String CompanyLotNumAddress;
    private String CompanyRoadNameAddress;
    private String CompanyDetail_address;
    private String CompanyZipcode;



}
