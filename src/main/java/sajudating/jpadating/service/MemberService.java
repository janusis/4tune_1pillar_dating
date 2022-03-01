package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.form.MemberForm;
import sajudating.jpadating.repository.MemberRepository;

import javax.transaction.Transactional;
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
    public Long join(MemberForm form){
        validateDuplicateMember(form); //중복회원검증
        Optional<Member> save = memberRepository.save(form);
        return null;

    }

    private void validateDuplicateMember(MemberForm form) {
        memberRepository.findByName(form.getUserId()).ifPresent(m-> {
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

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    /*
     *일주 조회
     */


}
