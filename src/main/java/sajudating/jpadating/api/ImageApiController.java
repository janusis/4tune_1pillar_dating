package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.domainDto.BoardDTO;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/image")
@Transactional
public class ImageApiController {
    @GetMapping("/{file}")
    public ResponseEntity readBoard(
            @PathVariable("file") String file) {



        return new ResponseEntity(
                new CommonApiResponse<BoardDTO>(StatusCode.OK,
                        ResponseMessage.READ_BOARD,board),
                HttpStatus.OK);
    }
}
