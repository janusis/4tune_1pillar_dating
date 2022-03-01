package sajudating.jpadating.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.repository.MemberRepository;
import sajudating.jpadating.service.MemberService;

import static sajudating.jpadating.domain.Member.*;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    void 회원가입(){

        MemberBuilder member = Member.builder();
        System.out.println(member);

//        memberRepository.save(member);
    }

//    @Test
//    public Optional<Member> 아이디로멤버찾기(){
//
//    }


}
