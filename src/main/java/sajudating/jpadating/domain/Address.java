package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Embeddable
@Getter
@RequiredArgsConstructor
public class Address {


    private String lotNumAddress;
    private String roadNameAddress;
    private String detail_address;
    private String zipcode;





}
