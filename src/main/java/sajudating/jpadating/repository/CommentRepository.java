package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class CommentRepository {
    private final EntityManager em;

    public CommentRepository(EntityManager em) {
        this.em = em;
    }

    //그룹 max값 가져오기
    public Long getGroupNumMax(){
        Object result = em.createQuery("select max(c.groupNum) from Comment c").
                getSingleResult();

        if(result == null){
            return 0L;
        }else{
            return (Long) result;
        }
    }

    //뎁스 설정

    


    //코멘트 저장

    public Long save(Comment comment){
        em.persist(comment);
        return comment.getId();
    }

    //게시글과 관련된 코멘트 조회

    //코멘트 수정

    //코멘트 삭제
}
