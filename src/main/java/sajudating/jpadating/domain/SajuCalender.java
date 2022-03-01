package sajudating.jpadating.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SajuCalender {

    @Id @GeneratedValue
    private Long id;//

    private Short year;//
    private Short lunarYear;//
    private String yearWords;
    private Byte month;//
    private Byte lunarMonth;//
    private String monthWords;//
    private Byte day;//
    private Byte lunarDay;//
    private String dayWords;//
    @Enumerated(EnumType.STRING)
    private MonthCompare monthCompare;//



}
