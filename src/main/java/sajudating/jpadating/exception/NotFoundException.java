package sajudating.jpadating.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Getter
public class NotFoundException extends RuntimeException{

    private int code;
    private String message;


    public NotFoundException(String message) {
        this.message=message;

    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);

    }


    public NotFoundException(int code, String message) {
        this.code=code;
        this.message=message;

    }
}
