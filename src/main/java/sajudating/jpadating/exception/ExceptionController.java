package sajudating.jpadating.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sajudating.jpadating.apiResponse.common.StatusCode;
import sajudating.jpadating.apiResponse.exception.ErrorResponseEntity;

import static sajudating.jpadating.apiResponse.exception.ErrorCode.*;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController extends ResponseEntityExceptionHandler {

    //valid 오류시 오류메시지를 파싱해서 필요한 정보만 메세지에 출력
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity processValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");
        }

        return ResponseEntity.status(StatusCode.BAD_REQUEST).body(builder.toString());
    }



    @ExceptionHandler(value = DuplicateException.class)
    protected ResponseEntity<ErrorResponseEntity> handleDuplicateException() {
        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponseEntity.toResponseEntity(DUPLICATE_RESOURCE);
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<ErrorResponseEntity> handleNotFoundException() {
        log.error("handleNotFoundException throw Exception : {}", DUPLICATE_RESOURCE);
        return ErrorResponseEntity.toResponseEntity(DUPLICATE_RESOURCE);
    }

}
