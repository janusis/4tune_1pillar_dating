package sajudating.jpadating.apiResponse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    MISMATCH_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    CANNOT_FOLLOW_MYSELF(BAD_REQUEST, "자기 자신은 팔로우 할 수 없습니다"),
    FILE_SAVE_EXCEPTION(BAD_REQUEST,"파일을 저장하는 도중 오류가 발생했습니다."),
    DATA_CHANGE_EXCEPTION(BAD_REQUEST,"데이터를 갱신하는 도중 오류가 발생했습니다."),
    LOGIN_FAILED_EXCEPTION(BAD_REQUEST,"로그인에 실패했습니다. 아이디와 패스워드를 다시 확인 해주세요."),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED, "현재 내 계정 정보가 존재하지 않습니다"),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 유저를 찾을 수 없습니다"),
    FILE_NOT_FOUND(NOT_FOUND, "해당 파일을 찾을 수 없습니다."),
    DIRECTORY_NOT_FOUND(NOT_FOUND, "해당 경로를 찾을 수 없습니다."),
    BIRTHDAY_NOT_FOUND(NOT_FOUND, "해당 생년월일에 대한 일주를 찾을 수 없습니다. 생년월일을 다시 입력 해 주세요."),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    /*
        ErrorCode.DUPLICATE_RESOURCE.getHttpStatus().value() == 409
        ErrorCode.DUPLICATE_RESOURCE.getHttpStatus().name() == CONFLICT
        ErrorCode.DUPLICATE_RESOURCE.name() == DUPLICATE_RESOURCE
        ErrorCode.DUPLICATE_RESOURCE.getDetail() == 정보가 이미 존재합니다
     */

    DUPLICATE_RESOURCE(CONFLICT, "정보가 이미 존재합니다"),

    ;

    private final HttpStatus httpStatus;
    private final String detail;


}
