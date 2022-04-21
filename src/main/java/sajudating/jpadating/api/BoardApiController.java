package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.service.BoardService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/boards")
@Transactional
public class BoardApiController {

    private final BoardService boardService;

    //게시글 저장
    @PostMapping("")
    public ResponseEntity saveBoard(@RequestBody @Valid BoardDTO boardDTO){
        Long id = boardService.writeBoard(boardDTO);

        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.CREATE_BOARD),
                HttpStatus.OK);
    }
    //게시물 조회
    @GetMapping("")
    public ResponseEntity listBoard(){
        List<BoardDTO> boards = boardService.findBoards();
        return new ResponseEntity(
                new CommonApiResponse<List>(StatusCode.OK,
                        ResponseMessage.READ_BOARD,boards),
                HttpStatus.OK);
    }

    //게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity readBoard(
            @PathVariable("id") Long id) {
        BoardDTO board = boardService.findBoard(id);
        return new ResponseEntity(
                new CommonApiResponse<BoardDTO>(StatusCode.OK,
                        ResponseMessage.READ_BOARD,board),
                HttpStatus.OK);
    }

    //게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity updateBoard(
            @PathVariable("id") Long id,
            @RequestBody @Valid BoardDTO boardDTO){

        boardService.changeBoard(id,boardDTO);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.UPDATE_BOARD),
                HttpStatus.OK);
    }


    //게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard( @PathVariable("id") Long id ){
        Long boardId = boardService.deleteBoard(id);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.DELETE_BOARD),
                HttpStatus.OK);
    }
}
