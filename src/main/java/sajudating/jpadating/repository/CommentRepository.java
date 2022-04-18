package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Comment;

import javax.persistence.EntityManager;

@Repository
public class CommentRepository {
    private final EntityManager em;

    public CommentRepository(EntityManager em) {
        this.em = em;
    }

    //코멘드 저장

    public Long save(Comment comment){

        return comment.getId();
    }

    //게시글과 관련된 코멘트 조회

    //코멘트 수정

    //코멘트 삭제
}
