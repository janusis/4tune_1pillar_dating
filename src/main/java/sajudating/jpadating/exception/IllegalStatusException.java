package sajudating.jpadating.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sajudating.jpadating.apiResponse.exception.ErrorCode;

@AllArgsConstructor
@Getter
public class IllegalStatusException extends RuntimeException{

    private final ErrorCode errorCode;


}

