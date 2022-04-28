package sajudating.jpadating.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sajudating.jpadating.apiResponse.common.StatusCode;
import sajudating.jpadating.apiResponse.exception.ExceptionResponseEntity;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {

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



    @ExceptionHandler(AlreadyExistException.class)
    public ExceptionResponseEntity alreadyExistException(AlreadyExistException e){
        return ExceptionResponseEntity.builder().
                timeStamp(e.getTimeStamp()).
                status(e.getStatus()).
                errorMessage(e.getErrorMessage()).
                trace(e.getTrace()).
                build();
    }
//    //Image 관련 Exception
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity fileDownloadException(NotFoundException e){
//
//        return ResponseEntity.status(e.getCode()).body(e.getMessage());
//    }
}
