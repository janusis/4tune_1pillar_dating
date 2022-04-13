package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.apiDto.member.AllMembersFindListResponse;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.domainDto.MemberDTO;

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
    //회원 찾기
    public Member findMember(Long memberId){
        return em.find(Member.class, memberId);
    }

    //게시글 저장
    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }
    //게시글 전체 조회

    public List<Board> findAll(){
        return em.createQuery("select b from Board b where b.member != null", Board.class).
                getResultList();
    }

    //멤버 pk와 최초게시일로 게시글 조회
    public Board findByMemberIdAndPubTime(BoardDTO boardDTO){
        Member member = em.find(Member.class, boardDTO.getMemberId());
        List<Board> result= em.createQuery("select b from Board b where b.member = :member and b.pubTime = :pubTime",
                        Board.class)
                .setParameter("member", member)
                .setParameter("pubTime", boardDTO.getPubTime())
                .getResultList();
        return result.stream().findAny().orElseThrow(NoSuchElementException::new);
    }

    //게시글 수정
    public Long change(Board board){
        em.persist(board);
        return board.getId();
    }
    //게시글 삭제


}
