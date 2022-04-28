package sajudating.jpadating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DataChangeException extends RuntimeException {

    private int code;
    private String message;

    public DataChangeException(String message) {
        this.message = message;
    }

    public DataChangeException(int code, String message) {
        this.code = code;
        this.message = message;


    }
}
