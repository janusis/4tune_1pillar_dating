package sajudating.jpadating.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Gender;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.repository.MemberRepository;
import sajudating.jpadating.service.MemberService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

//    @Test
//    void 회원가입(){
//        //given
//        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//
//        Address homeAddress = memberRepository.makeFirstAddress(memberDTO);
//        Address companyAddress = memberRepository.makeSecondAddress(memberDTO);
//        String dayWords = memberRepository.findDayWord(memberDTO);
//
//        LocalDateTime regDate = LocalDateTime.now();
//
//        Member member = new Member(memberDTO.getUserId(), memberDTO.getPw(), memberDTO.getName(), memberDTO.getEmail(),
//                memberDTO.getPhone(), memberDTO.getBirthday(), memberDTO.getBirthTime(), dayWords, memberDTO.getNickname(),
//                memberDTO.getGender(), homeAddress,companyAddress, regDate , regDate );
//
//        //when
//
//        Long id = memberRepository.save(member);
//        Optional<Member> optionalMember = memberRepository.findById(id);
//
//        //then
//        Assertions.assertThat(optionalMember.orElseThrow(NoSuchElementException::new).getId())
//                .isEqualTo(member.getId());
//    }
//
//    @Test
//    public void 유저아이디로_멤버조회() {
//        //given
//        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//
//        Address homeAddress = memberRepository.makeFirstAddress(memberDTO);
//        Address companyAddress = memberRepository.makeSecondAddress(memberDTO);
//        String dayWords = memberRepository.findDayWord(memberDTO);
//
//        LocalDateTime regDate = LocalDateTime.now();
//
//        Member member = new Member(memberDTO.getUserId(), memberDTO.getPw(), memberDTO.getName(), memberDTO.getEmail(),
//                memberDTO.getPhone(), memberDTO.getBirthday(), memberDTO.getBirthTime(), dayWords,memberDTO.getNickname(),
//                memberDTO.getGender(), homeAddress,companyAddress, regDate , regDate );
//
//        Long id = memberRepository.save(member);
//
//        //when
//        Optional<Member> optionalMember = memberRepository.findById(id);
//        Optional<Member> byUserId = memberRepository.findByUserId(optionalMember.orElseThrow(NoSuchElementException::new).getUserId());
//
//        //then
//        Assertions.assertThat(byUserId.orElseThrow(NoSuchElementException::new).getUserId())
//                .isEqualTo(member.getUserId());
//
//
//    }


//    @Test
//    public void 이름으로_멤버조회 (){
//        //given
//        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//        Optional<Member> member =memberRepository.save(memberDTO);
//
//        //when
//        Optional<Member> member1 = memberRepository.findByName("name");
//
//        //then
//        String name = member1.orElseThrow(NullPointerException::new).getName();
//
//        Assertions.assertThat(name).isEqualTo("name");
//    }
//
//
//    @Test
//    public void 모든멤버_조회하기(){
//        //given
//        MemberDTO memberDTO1 = new MemberDTO("userid123", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//        Optional<Member> member1 =memberRepository.save(memberDTO1);
//
//        MemberDTO memberDTO2 = new MemberDTO("userid12", "pw", "name", "email",
//                "phone", LocalDate.now(), "신시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//        Optional<Member> member2 =memberRepository.save(memberDTO2);
//
//        //when
//        List<Member> users = memberRepository.findAll();
//
//        //then
//        Iterator<Member> iterator = users.stream().iterator();
//        Member next = iterator.next();
//        Assertions.assertThat(next.getUserId()).isEqualTo("userid123");
//        next = iterator.next();
//        Assertions.assertThat(next.getUserId()).isEqualTo("userid12");
//
//    }
//
//    @Test
//    public void 이름과_생년월일로_멤버아이디_조회(){
//        //given
//        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//        Optional<Member> member =memberRepository.save(memberDTO);
//
//        //when
//
//        Optional<Member> userid = memberRepository.findIdByNameAndBirthday(memberDTO.getName(), memberDTO.getBirthday());
//
//        //then
//        Assertions.assertThat(userid.orElseThrow(NullPointerException::new).getUserId()).isEqualTo(memberDTO.getUserId());
//    }
//
//    @Test
//    public void 아이디와_이름_생년월일을_통해_비밀번호조회(){
//        //given
//        MemberDTO memberDTO = new MemberDTO("userid", "pw", "name", "email",
//                "phone", LocalDate.now(), "유시", "닉네임",
//                Gender.MALE, "add", "add","add", "add",
//                "add1", "add1", "add1", "add1");
//        Optional<Member> member =memberRepository.save(memberDTO);
//
//        //when
//
//        Optional<Member> Pw = memberRepository.
//                findPWByUserIdAndNameAndBirthday(memberDTO.getUserId(), memberDTO.getName(), memberDTO.getBirthday());
//
//        //then
//        Assertions.assertThat(Pw.orElseThrow(NullPointerException::new).getPw()).isEqualTo(memberDTO.getPw());
//    }
//
    
}
