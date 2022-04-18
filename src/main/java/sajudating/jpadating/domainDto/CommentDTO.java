package sajudating.jpadating.domainDto;

import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

public class CommentDTO {

    private Long id;


    private String context;


    private Long memberId;
    private String memberNickname;

    private Long boardId;

    //그룹
    private Long groupNum;
    //뎁스
    private Long hierarchy;

    //정렬
    private Long orders;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;
    private Long good;
    private Long bad;
}
