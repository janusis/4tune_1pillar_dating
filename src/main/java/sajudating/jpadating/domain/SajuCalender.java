package sajudating.jpadating.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SajuCalender {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Integer lunarYear;
    private String yearWords;
    private Integer month;
    private Integer lunarMonth;
    private String monthWords;
    private Integer day;
    private Integer lunarDay;
    private String dayWords;
    @Enumerated(EnumType.STRING)
    private MonthCompare monthCompare;



}
