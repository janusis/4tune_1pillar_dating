package sajudating.jpadating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalStatueException extends RuntimeException{

    private int code;
    private String message;

    public IllegalStatueException(String message) {
        this.message = message;
    }

    public IllegalStatueException(int code, String message) {
        this.code=code;
        this.message=message;

    }


}

