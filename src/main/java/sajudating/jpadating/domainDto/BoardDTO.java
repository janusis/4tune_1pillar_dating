package sajudating.jpadating.domainDto;


import com.mysql.cj.jdbc.Clob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sajudating.jpadating.domain.BoardType;
import sajudating.jpadating.domain.Images;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domain.ReportBoard;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardDTO {


    private String title;

    private Member member;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    @Lob
    private Clob context;

    private Long views;
    private Long good;
    private Long bad;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;


    private List<Images> imagesBoardList= new ArrayList<>();


    private List<ReportBoard> reportBoardList= new ArrayList<>();

    private Long reportConut;
}
