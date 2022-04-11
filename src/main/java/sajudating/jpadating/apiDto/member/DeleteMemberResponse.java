package sajudating.jpadating.apiDto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteMemberResponse {
    private Long id;
    private String userId;
    private String name;
}
