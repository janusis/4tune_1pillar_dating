package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sajudating.jpadating.apiDto.board.CreateBoardResponse;
import sajudating.jpadating.apiDto.member.CreateMemberResponse;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/boards")
public class BoardApiController {

    private final BoardService boardService;

    //게시글 저장
    @PostMapping("")
    public CreateBoardResponse saveMember1(@RequestBody @Valid BoardDTO boardDTO){
        Long id = boardService.write(boardDTO);
        String title = boardDTO.getTitle();
        String name = boardDTO.getMember().getName();
        boardService.write(boardDTO);
        return new CreateBoardResponse(id,title,name);
    }
}
