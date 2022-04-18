package sajudating.jpadating.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sajudating.jpadating.service.CommentService;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/comments")
@Transactional
public class CommentApiController {
    private final CommentService commentService;


    //코멘트 저장

    //게시글 별 코멘트 조회

    //코멘트 수정

    //코멘트 삭제


}
