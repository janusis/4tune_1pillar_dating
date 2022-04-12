package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.apiDto.board.CreateBoardResponse;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.apiDto.member.AllMembersFindListResponse;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.service.BoardService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/boards")
@Transactional
public class BoardApiController {

    private final BoardService boardService;

    //게시글 저장
    @PostMapping("")
    public ResponseEntity saveBoard(@RequestBody @Valid BoardDTO boardDTO){
        Long id = boardService.write(boardDTO);
//        String title = boardDTO.getTitle();
//        String name = boardDTO.getMember().getName();
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

    //게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity updateBoard(
            @PathVariable("id") Long id,
            @RequestBody @Valid BoardDTO boardDTO){

        boardService.changeBoardInfo(boardDTO);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.UPDATE_BOARD),
                HttpStatus.OK);
    }
}
