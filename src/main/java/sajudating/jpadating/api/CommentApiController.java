package sajudating.jpadating.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.CommentDTO;
import sajudating.jpadating.service.CommentService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/comments")
@Transactional
public class CommentApiController {
    private final CommentService commentService;



    //코멘트 저장
    @PostMapping("")
    public ResponseEntity saveComment(@RequestBody @Valid CommentDTO commentDTO){

        commentService.writeComment(commentDTO);

        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.CREATE_COMMENT),
                HttpStatus.OK);
    }

    //게시글 별 코멘트 조회

    @GetMapping("/{id}")
    public ResponseEntity listComment(
            @PathVariable("id") Long id){

        List<CommentDTO> comments = commentService.findComments(id);
        return new ResponseEntity(
                new CommonApiResponse<List>(StatusCode.OK,
                        ResponseMessage.READ_COMMENT,comments),
                HttpStatus.OK);
    }


    //코멘트 수정


    @PutMapping("/{id}")
    public ResponseEntity updateComment(
            @PathVariable("id") Long id,
            @RequestBody @Valid CommentDTO commentDTO){

        commentService.changeComment(id,commentDTO);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.UPDATE_COMMENT),
                HttpStatus.OK);
    }
    //코멘트 삭제

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteComment(
            @PathVariable("id") Long id){

        commentService.deleteComment(id);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.DELETE_COMMENT),
                HttpStatus.OK);
    }


}
