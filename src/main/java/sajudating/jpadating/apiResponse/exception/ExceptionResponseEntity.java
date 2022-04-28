package sajudating.jpadating.apiResponse.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ExceptionResponseEntity {
    private String timeStamp;
    private int status;
    private String errorMessage;
    private String trace;

    public ExceptionResponseEntity() {
    }

    public ExceptionResponseEntity(String timeStamp, int status, String errorMessage) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.errorMessage = errorMessage;
    }



}
