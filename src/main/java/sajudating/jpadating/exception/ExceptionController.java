package sajudating.jpadating.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sajudating.jpadating.apiDto.common.CommonApiResponse;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity fileDownloadException(FileDownloadException e){
        return new ResponseEntity(new CommonApiResponse<>(e.getMessage()));
    }
}
