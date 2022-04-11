package sajudating.jpadating.apiDto.board;

import lombok.AllArgsConstructor;
import lombok.Data;

//게시글 생성시 리턴하는 클래스
@Data
@AllArgsConstructor
public class CreateBoardResponse {
    private Long id;
    private String title;
    private String name;

}
