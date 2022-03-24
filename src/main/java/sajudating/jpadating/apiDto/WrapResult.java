package sajudating.jpadating.apiDto;

import lombok.AllArgsConstructor;
import lombok.Data;


//멤버 전체 조회 시 return 형식의 유연성(확장성)을 위하여 Result라는 객체를 이용해 List는 data에 담아서 리턴
@Data
@AllArgsConstructor
public class WrapResult<T>{
    private T data;
}
