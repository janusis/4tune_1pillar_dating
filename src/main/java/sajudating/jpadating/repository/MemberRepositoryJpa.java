package sajudating.jpadating.repository;


import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domain.SajuCalender;
import sajudating.jpadating.DTO.MemberDTO;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositoryJpa implements MemberRepository{
    private final EntityManager em;


    public MemberRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    //회원가입
    public Optional<Member> save(MemberDTO memberDTO){

        Address homeAddress = new Address(memberDTO.getHomeLotNumAddress(),memberDTO.getHomeRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getHomeDetail_address());
        Address companyAddress = new Address(memberDTO.getCompanyLotNumAddress(),memberDTO.getCompanyRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getCompanyZipcode());

        List<SajuCalender> resultList = em.createQuery(
                "select s from SajuCalender s where s.year = :year and s.month = :month and s.day = :day ", SajuCalender.class)
                .setParameter("year", memberDTO.getBirthday().getYear())
                .setParameter("month",memberDTO.getBirthday().getMonthValue())
                .setParameter("day", memberDTO.getBirthday().getDayOfMonth())
                .getResultList();

        LocalDateTime regDate = LocalDateTime.now();
        String dayWords = resultList.get(0).getDayWords();

        Member member = new Member(memberDTO.getUserId(), memberDTO.getPw(), memberDTO.getName(), memberDTO.getEmail(),
                memberDTO.getPhone(), memberDTO.getBirthday(), memberDTO.getBirthTime(), dayWords,memberDTO.getNickname(),
                memberDTO.getGender(), homeAddress,companyAddress, regDate , regDate );

        em.persist(member);
        return Optional.ofNullable(member);
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
    public Optional<Member> updateMember(MemberDTO memberDTO){
        Address homeAddress = new Address(memberDTO.getHomeLotNumAddress(),memberDTO.getHomeRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getHomeDetail_address());
        Address companyAddress = new Address(memberDTO.getCompanyLotNumAddress(),memberDTO.getCompanyRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getCompanyZipcode());

        List<SajuCalender> resultList = em.createQuery(
                        "select s from SajuCalender s where s.year = :year and s.month = :month and s.day = :day ", SajuCalender.class)
                .setParameter("year", memberDTO.getBirthday().getYear())
                .setParameter("month",memberDTO.getBirthday().getMonthValue())
                .setParameter("day", memberDTO.getBirthday().getDayOfMonth())
                .getResultList();

        LocalDateTime modDate = LocalDateTime.now();
        String dayWords = resultList.stream().findAny().orElseThrow(NullPointerException::new).getDayWords();


        Member oldMember = em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", memberDTO.getUserId())
                .getResultList().stream().findAny().orElseThrow(NullPointerException::new);


        Member member = new Member(memberDTO.getUserId(), memberDTO.getPw(), memberDTO.getName(), memberDTO.getEmail(),
                memberDTO.getPhone(), memberDTO.getBirthday(), memberDTO.getBirthTime(), dayWords,memberDTO.getNickname(),
                memberDTO.getGender(), homeAddress,companyAddress, oldMember.getRegDate() , modDate );

        em.persist(member);
        em.createQuery("select m from Member m", Member.class).
                getResultList();
        return Optional.ofNullable(member);
    }

    //멤버 삭제


}
