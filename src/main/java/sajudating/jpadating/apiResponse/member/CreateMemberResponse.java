package sajudating.jpadating.apiResponse.member;

import lombok.AllArgsConstructor;
import lombok.Data;

//회원가입시에 reponse로 리턴하는 클래스
@Data
@AllArgsConstructor
public class CreateMemberResponse {
    private Long id;
    private String userId;
    private String name;
}
