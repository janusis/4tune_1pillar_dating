package sajudating.jpadating.service;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.DTO.MemberDTO;
import sajudating.jpadating.repository.MemberRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
      회원가입
         */
    public Optional<Member> join(MemberDTO memberDTO){
        validateDuplicateMember(memberDTO); //중복회원검증
        Optional<Member> member = memberRepository.save(memberDTO);
        return member.stream().findAny();

    }
    /*
    유저 아이디 중복 검증
     */
    private void validateDuplicateMember(MemberDTO memberDTO) {
        memberRepository.findByUserId(memberDTO.getUserId()).ifPresent(m-> {
                            throw new IllegalStateException("이미 존재하는 아이디 입니다");
                        }
                );
    }

    /*
     *전체회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /*
    아이디를 이용해서 멤버 조회
     */
    public Optional<Member> findOne(String memberUserid){
        return memberRepository.findByUserId(memberUserid);
    }



    /*
    이름과 생년월일을 통해 아이디 조회
     */
    public Optional<Member> findUserId(String name, LocalDate birthday){
        return memberRepository.findIdByNameAndBirthday(name, birthday);
    }

    /*
    아이디와 이름,생년월일을 통해 비밀번호 조회
     */
    public Optional<Member> findPw(String userid, String name, LocalDate birthday){
        return memberRepository.findPWByUserIdAndNameAndBirthday(userid, name, birthday);
    }


}
