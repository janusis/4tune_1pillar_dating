package sajudating.jpadating.repository;


import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.*;
import sajudating.jpadating.domainDto.MemberDTO;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final EntityManager em;


    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    //첫번째 주소 만들기
    public Address makeFirstAddress(MemberDTO memberDTO) {
        return new Address(memberDTO.getHomeLotNumAddress(),memberDTO.getHomeRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getHomeDetail_address());
    }

    //두번째 주소 만들기
    public Address makeSecondAddress(MemberDTO memberDTO) {
        return new Address(memberDTO.getCompanyLotNumAddress(),memberDTO.getCompanyRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getCompanyZipcode());
    }

    //일주 찾기
    public String findDayWord(MemberDTO memberDTO) {
        List<SajuCalender> resultList = em.createQuery(
                        "select s from SajuCalender s where s.year = :year and s.month = :month and s.day = :day ", SajuCalender.class)
                .setParameter("year", memberDTO.getBirthday().getYear())
                .setParameter("month",memberDTO.getBirthday().getMonthValue())
                .setParameter("day", memberDTO.getBirthday().getDayOfMonth())
                .getResultList();
        return resultList.stream().findAny().orElseThrow(NoSuchElementException::new).getDayWords();
    }

    //회원가입
    public Long save(Member member){

        em.persist(member);
        return member.getId();
    }

    //pk로 멤버 조회
    public Member findById(Long id ){
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member).orElseThrow(NoSuchElementException::new) ;
    }

    //유저아이디로 멤버 조회
    public Optional<Member> findByUserId(String userid) {

        List<Member> member = em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userid)
                .getResultList();

        return member.stream().findAny();
    }

    //이름으로 멤버 조회
    public Optional<Member> findByName(String name) {

        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }
    //이름과 생년월일로 멤버 아이디 조회
    public Optional<Member> findIdByNameAndBirthday(String name, LocalDate birthday) {

        List<Member> result = em.createQuery("select m from Member m where m.name = :name and m.birthday = :birthday", Member.class)
                .setParameter("name", name)
                .setParameter("birthday", birthday)
                .getResultList();

        return result.stream().findAny();
    }


    //아이디와 이름, 생년월일을 통해 비밀번호 조회
    public Optional<Member> findPWByUserIdAndNameAndBirthday(String userId, String name, LocalDate birthday) {

        List<Member> result = em.createQuery("select m from Member m where m.userId = :userId and m.name = :name and m.birthday = :birthday", Member.class)
                .setParameter("userId", userId)
                .setParameter("name", name)
                .setParameter("birthday", birthday)
                .getResultList();

        return result.stream().findAny();
    }

    //모든 멤버 조회하기
    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class).
                getResultList();

    }

    //멤버 수정
    public Long change(Member member){
        em.persist(member);

        return member.getId();

    }

    //멤버 삭제
    public Long delete(Member member){
        Member member1 = em.find(Member.class, member.getId());
        //코멘트의 해당 memberId를 null로 변경
        List<Comment> comment = em.createQuery("select c from Comment c where c.member = :member ", Comment.class)
                .setParameter("member", member1)
                .getResultList();
        for (Comment c : comment){
            c.deleteCommentMember();
        }

        // 게시글의 해당 memberId를 null로 변경
        List<Board> board = em.createQuery("select b from Board b where b.member = :member ", Board.class)
                .setParameter("member", member1)
                .getResultList();
        for (Board b : board) {
            b.deleteBoard();
        }

        em.remove(member1);
        return member.getId();
    }

}
