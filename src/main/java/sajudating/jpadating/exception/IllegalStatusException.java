package sajudating.jpadating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalStatusException extends RuntimeException{

    private int code;
    private String message;

    public IllegalStatusException(String message) {
        this.message = message;
    }

    public IllegalStatusException(int code, String message) {
        this.code=code;
        this.message=message;

    }


}

