package sajudating.jpadating.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sajudating.jpadating.apiResponse.exception.ErrorCode;
import sajudating.jpadating.apiResponse.exception.ErrorResponse;
import sajudating.jpadating.apiResponse.exception.ErrorResponseEntity;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController extends ResponseEntityExceptionHandler {



    @ExceptionHandler(value = DataChangeException.class)
    public ResponseEntity<ErrorResponseEntity> dataChangeException(ErrorCode errorCode) {
        log.error("dataChangeException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ResponseEntity<ErrorResponseEntity> duplicateException(ErrorCode errorCode) {
        log.error("dataException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }


    @ExceptionHandler(value = FileIOException.class)
    public ResponseEntity<ErrorResponseEntity> fileIOException(ErrorCode errorCode) {
        log.error("dataChangeException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }

    @ExceptionHandler(value = FileSaveException.class)
    public ResponseEntity<ErrorResponseEntity> fileSaveException(ErrorCode errorCode) {
        log.error("dataChangeException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }

    @ExceptionHandler(value = IllegalStatusException.class)
    public ResponseEntity<ErrorResponseEntity> illegalStatusException(ErrorCode errorCode) {
        log.error("dataChangeException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorResponseEntity> notFoundException(ErrorCode errorCode) {
        log.error("notFoundException throw Exception : {}", errorCode);
        return ErrorResponseEntity.toResponseEntity(errorCode);
    }
//
//
//    private ResponseEntity<Object> buildErrorResponse(Exception exception,
//                                                      HttpStatus httpStatus,
//                                                      WebRequest request) {
//        return buildErrorResponse(exception, exception.getMessage(), httpStatus, request);
//    }
//
//    private ResponseEntity<Object> buildErrorResponse(Exception exception,
//                                                      String message,
//                                                      HttpStatus httpStatus,
//                                                      WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
//        if (printStackTrace && isTraceOn(request)) {
//            errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
//        }
//        return ResponseEntity.status(httpStatus).body(errorResponse);
//    }
//
//    private boolean isTraceOn(WebRequest request) {
//        String[] value = request.getParameterValues(TRACE);
//        return Objects.nonNull(value)
//                && value.length > 0
//                && value[0].contentEquals("true");
//    }
}
