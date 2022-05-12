package sajudating.jpadating.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sajudating.jpadating.apiResponse.common.StatusCode;
import sajudating.jpadating.apiResponse.exception.ErrorCode;
import sajudating.jpadating.apiResponse.member.AllMembersFindListResponse;
import sajudating.jpadating.domain.Address;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.LoginDTO;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.exception.DuplicateException;
import sajudating.jpadating.exception.NotFoundException;
import sajudating.jpadating.repository.MemberRepository;
import sajudating.jpadating.security.TokenProvider;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        //1. 중복회원 검증
        validateDuplicateMember(memberDTO);
        //2. 집 주소 생성
        Address homeAddress = memberRepository.makeFirstAddress(memberDTO);
        //3. 회사 주소 생성
        Address companyAddress = memberRepository.makeSecondAddress(memberDTO);
        //4. 일주 생성
        String dayWords = memberRepository.findDayWord(memberDTO);
        //5. 가입일 설정
        LocalDateTime regDate = LocalDateTime.now();
        //6. 완성된 멤버 엔티티 생성
        Member member = new Member(memberDTO);
        //7.멤버 DB에 저장
        return memberRepository.save(member);
    }
    /*
    유저 아이디 중복 검증
     */
    private void validateDuplicateMember(MemberDTO memberDTO) {
        //USERID를 이용하여 아이디가 존재하는지 확인.
        memberRepository.findByUserId(memberDTO.getUserId()).
                ifPresent(m-> {
                            throw new DuplicateException(ErrorCode.DUPLICATE_RESOURCE);
                }
        );
    }


    // 로그인 인증 확인
        public LoginDTO loginMember(LoginDTO loginDTO){
            Member member = memberRepository
                    .findByUserIdAndPw(loginDTO.getUserId(), loginDTO.getPw())
                    .orElseThrow(() -> new NotFoundException(ErrorCode.UNAUTHORIZED_MEMBER));
            String token = new TokenProvider().create(member);


            return new LoginDTO().builder()
                    .id(member.getId())
                    .token(token)
                    .build();
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
        return Optional.ofNullable(member).
                orElseThrow(()-> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));
    }

    /*
    아이디를 이용해서 멤버 조회
     */
    public Member findOneByUserId(String memberUserid){
        return memberRepository.findByUserId(memberUserid).
                orElseThrow(()->new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));
    }



    /*
    이름과 생년월일을 통해 아이디 조회
     */
    public Member findUserId(String name, LocalDate birthday){
        return memberRepository.findIdByNameAndBirthday(name, birthday).
                orElseThrow(()->new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

    }

    /*
    아이디와 이름,생년월일을 통해 비밀번호 조회
     */
    public Member findPw(String userid, String name, LocalDate birthday){
        return memberRepository.findPWByUserIdAndNameAndBirthday(userid, name, birthday).
                orElseThrow(()->new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));
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
