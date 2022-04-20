package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import sajudating.jpadating.apiDto.member.AllMembersFindListResponse;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.repository.MemberRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Long join(MemberDTO memberDTO){
        validateDuplicateMember(memberDTO); //중복회원검증
        Address homeAddress = memberRepository.makeFirstAddress(memberDTO);
        Address companyAddress = memberRepository.makeSecondAddress(memberDTO);
        String dayWords = memberRepository.findDayWord(memberDTO);

        LocalDateTime regDate = LocalDateTime.now();

        Member member = new Member(memberDTO);

        return memberRepository.save(member);
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
    public List<AllMembersFindListResponse> findMembers(){


        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(m -> new AllMembersFindListResponse(m.getId(), m.getUserId(), m.getNickname(), m.getName()))
                .collect(Collectors.toList());
    }

    /*
    pk를 이용해서 멤버 조회
     */
    public Member findMember(Long id){
        Member member = memberRepository.findById(id);
        return Optional.ofNullable(member).orElseThrow(NoSuchElementException::new);
    }

    /*
    아이디를 이용해서 멤버 조회
     */
    public Optional<Member> findOneByUserId(String memberUserid){
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

    /*
    회원정보 수정
     */
    public Long changeMemberInfo(MemberDTO memberDTO, Long id) {
        Member member = findMember(id);
        member.updateMember(memberDTO);
        return memberRepository.change(member);
    }

    /*
    회원 삭제
     */
    public Long deleteMember(Member member){
        memberRepository.delete(member);
       return member.getId();
    }

}
