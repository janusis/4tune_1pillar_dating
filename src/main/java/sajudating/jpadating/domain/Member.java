package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

}
