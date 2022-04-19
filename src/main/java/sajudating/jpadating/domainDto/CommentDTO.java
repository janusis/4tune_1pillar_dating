package sajudating.jpadating.domainDto;

import lombok.Data;
import lombok.Getter;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private Long id;
    private String context;

    //member 에서 가져오는 것들
    private Long memberId;
    private String memberNickname;

    //board 에서 가져오는 것들
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

    private Long reportCount;
}
