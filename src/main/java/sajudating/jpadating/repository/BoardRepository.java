package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Board;

import javax.persistence.EntityManager;

@Repository
public class BoardRepository {
    private final EntityManager em;


    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    //게시글 저장
    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }
    //게시글 전체 조회

    //게시글 수정

    //게시글 삭제


}
