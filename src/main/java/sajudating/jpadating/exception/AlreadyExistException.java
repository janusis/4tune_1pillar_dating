package sajudating.jpadating.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
@Getter
public class AlreadyExistException extends RuntimeException{

    private String timeStamp;
    private int status;
    private String errorMessage;
    private String trace;

    public AlreadyExistException(String timeStamp, int status, String errorMessage) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.errorMessage = errorMessage;
    }


}
