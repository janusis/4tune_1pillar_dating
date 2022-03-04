package sajudating.jpadating.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.DTO.MemberDTO;
import sajudating.jpadating.domain.Gender;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.repository.MemberRepository;
import sajudating.jpadating.service.MemberService;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    void 회원가입(){
        //given
        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
                "phone", LocalDate.now(), "유시", "닉네임",
                Gender.MALE, "add", "add","add", "add",
                "add1", "add1", "add1", "add1");
        //when
        Optional<Member> member =memberRepository.save(memberDTO);

        //then
        Assertions.assertThat(member.get().getUserId()).isEqualTo("userid");
    }

    @Test
    public void 아이디로멤버찾기(){
        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
                "phone", LocalDate.now(), "유시", "닉네임",
                Gender.MALE, "add", "add","add", "add",
                "add1", "add1", "add1", "add1");
        Optional<Member> member =memberRepository.save(memberDTO);

        Optional<Member> member1 = memberRepository.findByUserId("userid");

//        member1.ifPresent(mem -> {
//            Assertions.assertThat(mem.getId()).isEqualTo(member.get().getId());
//        });


//        Assertions.assertThat(member1.getUserId()).isEqualTo("userid");

    }


}
