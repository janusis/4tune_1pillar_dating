package sajudating.jpadating.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.apiResponse.exception.ErrorCode;

@SpringBootTest
@Transactional
public class ExceptionTest {
    /*
            return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(ErrorResponseEntity.builder()
                        .status(errorCode.getHttpStatus().value())
                        .error(errorCode.getHttpStatus().name())
                        .code(errorCode.name())
                        .message(errorCode.getDetail())
                        .build()
                );
     */
//    @Test
//    public void 테스트1(){
//        //given
//        System.out.println(ErrorCode.DUPLICATE_RESOURCE.getHttpStatus().value());
//        System.out.println(ErrorCode.DUPLICATE_RESOURCE.getHttpStatus().name());
//        System.out.println(ErrorCode.DUPLICATE_RESOURCE.name());
//        System.out.println(ErrorCode.DUPLICATE_RESOURCE.getDetail());
//
//        //when
//
//        //then
//
//    }
}
