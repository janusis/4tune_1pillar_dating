package sajudating.jpadating.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domain.SajuCalender;
import sajudating.jpadating.form.MemberForm;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MemberRepositoryJpa implements MemberRepository{
    private final EntityManager em;


    public MemberRepositoryJpa(EntityManager em) {
        this.em = em;
    }





    public Optional<Member> save(MemberForm form){
        Address homeAddress = new Address(form.getHomeLotNumAddress(),form.getHomeRoadNameAddress(),
                form.getHomeDetail_address(),form.getHomeDetail_address());
        Address companyAddress = new Address(form.getCompanyLotNumAddress(),form.getCompanyRoadNameAddress(),
                form.getHomeDetail_address(),form.getCompanyZipcode());

        List<SajuCalender> resultList = em.createQuery("select s from SajuCalender s where s.year = :year and s.month = :month and s.day = :day ", SajuCalender.class)
                .setParameter("year", member.build().getBirthday().getYear())
                .setParameter("month", member.build().getBirthday().getMonth())
                .setParameter("day", member.build().getBirthday().getDayOfMonth())
                .getResultList();

        String dayWords = resultList.get(0).getDayWords();



//        return resultList.stream().findAny();
        return null;
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
