package sajudating.jpadating.domainDto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LoginDTO {

    private String token;

    private String userId;

    private String pw;

    private Long id;

}
