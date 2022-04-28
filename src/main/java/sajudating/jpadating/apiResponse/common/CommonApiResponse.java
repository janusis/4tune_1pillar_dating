package sajudating.jpadating.apiResponse.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommonApiResponse<T> {
    private int statusCode;
    private String responseMessage;
    private T data;


    public CommonApiResponse(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public CommonApiResponse(T message) {
    }

    public static<T> CommonApiResponse<T> res(final int statusCode,
                                              final String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    public static<T> CommonApiResponse<T> res(final int statusCode,
                                              final String responseMessage,
                                              final T t) {
        return CommonApiResponse.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }

}
