package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Comment;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class CommentRepository {
    private final EntityManager em;

    public CommentRepository(EntityManager em) {
        this.em = em;
    }




    // pk를 이용한 코멘트 조회

    public Comment findById(Long commentId){
        Comment comment = em.find(Comment.class, commentId);
        return Optional.ofNullable(comment).orElseThrow(NoSuchElementException::new);
    }


    //코멘트 저장

    public Long save(Comment comment){
        em.persist(comment);
        return comment.getId();
    }

    //boardId를 이용한 게시글 별 코멘트 조회

    public List<Comment> findCommentsByBoardId(Long boardId){
        Board board = em.find(Board.class, boardId);
        List<Comment> commentList = em.createQuery("select c from Comment c where c.board = :boardId order by c.parent, c.pubTime" , Comment.class).
                setParameter("boardId", board).
                getResultList();

        return commentList;
    }


    //코멘트 수정
    public Long change(Comment comment){
        em.persist(comment);
        return comment.getId();
    }


    //코멘트 삭제

    public Long delete(Long commentId){
        Comment comment = em.find(Comment.class, commentId);
        comment.changeContext("삭제된 댓글 입니다.");
        em.persist(comment);
        return commentId;
    }
}
