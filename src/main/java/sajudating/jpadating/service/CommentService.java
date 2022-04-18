package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.CommentRepository;
import sajudating.jpadating.repository.MemberRepository;

@Service
@Transactional
public class CommentService {

    private final BoardRepository boardRepository ;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public CommentService(BoardRepository boardRepository,
                          MemberRepository memberRepository,
                          CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }


    //코멘트 저장



    //게시글 별 코멘트 조회

    //코멘트 수정

    //코멘트 삭제


}
