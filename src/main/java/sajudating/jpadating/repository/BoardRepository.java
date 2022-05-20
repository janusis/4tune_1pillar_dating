package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Boards;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.BoardDTO;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class BoardRepository {
    private final EntityManager em;


    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    //pk로 게시글 찾기
    public Boards findById(Long boardId){
        Boards boards = em.find(Boards.class, boardId);
        return Optional.ofNullable(boards).orElseThrow(NoSuchElementException::new);
    }

    // 최대 게시글 번호 가져와서 +1 해서 리턴
    public Long findMaxRowNum(){
        Object rowNum = em.createQuery("select max(b.rowNum) from Boards b").getSingleResult();
        if(rowNum!=null){
            return (Long) rowNum+1;
        }else{
            return 0L;
        }
    }

    //게시글 저장
    public Long save(Boards boards) {
        em.persist(boards);
        return boards.getId();
    }
    //게시글 전체 조회

    public List<Boards> findAll(){
        return em.createQuery("select b from Boards b where b.member != null order by b.id ", Boards.class).
                getResultList();
    }

    //멤버 pk와 최초게시일로 게시글 조회
    public Boards findByMemberIdAndPubTime(BoardDTO boardDTO){
        Member member = em.find(Member.class, boardDTO.getMemberId());
        List<Boards> result= em.createQuery("select b from Boards b where b.member = :member and b.pubTime = :pubTime",
                        Boards.class)
                .setParameter("member", member)
                .setParameter("pubTime", boardDTO.getPubTime())
                .getResultList();
        return result.stream().findAny().orElseThrow(NoSuchElementException::new);
    }

    //게시글 수정
    public Long change(Boards boards){
        em.persist(boards);
        return boards.getId();
    }
    //게시글 삭제

    public Long delete(Long boardId){
        Boards boards = em.find(Boards.class, boardId);
        em.remove(boards);
        return boardId;
    }


}
