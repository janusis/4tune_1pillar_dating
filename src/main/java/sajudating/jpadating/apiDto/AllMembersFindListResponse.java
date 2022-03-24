package sajudating.jpadating.apiDto;

import lombok.AllArgsConstructor;
import lombok.Data;


//멤버 전체 조회시 각 멤버 마다 리턴할 정보들을 담을 dto
//이 dto로 이루어진 리스트가 Result의 data에 담겨서 리턴됨
@Data
@AllArgsConstructor
public class AllMembersFindListResponse {
    private Long id;
    private String userId;
    private String nickName;
    private String name;
}
