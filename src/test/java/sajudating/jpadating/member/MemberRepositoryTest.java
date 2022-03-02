package sajudating.jpadating.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.DTO.MemberDTO;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Gender;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.repository.MemberRepository;
import sajudating.jpadating.service.MemberService;

import java.time.LocalDate;
import java.time.LocalDateTime;

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


        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
                "phone", LocalDate.now(), "유시", "닉네임",
                Gender.MALE, "add", "add","add", "add",
                "add1", "add1", "add1", "add1");
        memberRepository.save(memberDTO);
    }

//    @Test
//    public Optional<Member> 아이디로멤버찾기(){
//
//    }


}
