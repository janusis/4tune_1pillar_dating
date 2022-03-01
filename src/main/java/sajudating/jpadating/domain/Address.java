package sajudating.jpadating.domain;

import lombok.Data;
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

    public Address(String lotNumAddress, String roadNameAddress, String detail_address, String zipcode) {
        this.lotNumAddress = lotNumAddress;
        this.roadNameAddress = roadNameAddress;
        this.detail_address = detail_address;
        this.zipcode = zipcode;
    }
}
