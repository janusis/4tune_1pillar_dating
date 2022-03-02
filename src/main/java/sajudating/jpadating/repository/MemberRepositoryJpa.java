package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domain.SajuCalender;
import sajudating.jpadating.DTO.MemberDTO;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositoryJpa implements MemberRepository{
    private final EntityManager em;


    public MemberRepositoryJpa(EntityManager em) {
        this.em = em;
    }





    public Optional<Member> save(MemberDTO memberDTO){
        Address homeAddress = new Address(memberDTO.getHomeLotNumAddress(),memberDTO.getHomeRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getHomeDetail_address());
        Address companyAddress = new Address(memberDTO.getCompanyLotNumAddress(),memberDTO.getCompanyRoadNameAddress(),
                memberDTO.getHomeDetail_address(),memberDTO.getCompanyZipcode());

        List<SajuCalender> resultList = em.createQuery("select s from SajuCalender s where s.year = :year and s.month = :month and s.day = :day ", SajuCalender.class)
                .setParameter("year", memberDTO.getBirthday().getYear())
                .setParameter("month",memberDTO.getBirthday().getMonth())
                .setParameter("day", memberDTO.getBirthday().getDayOfMonth())
                .getResultList();

        LocalDateTime regDate = LocalDateTime.now();
        String dayWords = resultList.get(0).getDayWords();

        Member member = new Member(memberDTO.getUserId(), memberDTO.getPw(), memberDTO.getName(), memberDTO.getEmail(),
                memberDTO.getPhone(), memberDTO.getBirthday(), memberDTO.getBirthTime(), dayWords,memberDTO.getNickname(),
                memberDTO.getGender(),
                homeAddress,companyAddress, regDate , regDate );

        em.persist(member);
        return Optional.ofNullable(member);
    }

    public Optional<Member> findById(Long id) {

        Member member = em.find(Member.class, id);

        return Optional.ofNullable(member);
    }

    public Optional<Member> findByName(String name) {

        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    public List<Member> findAll() {

        return em.createQuery("select m from Member m", Member.class).
                getResultList();

    }


}
