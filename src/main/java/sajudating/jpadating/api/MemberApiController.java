package sajudating.jpadating.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.apiDto.*;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.service.MemberService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/members")
public class MemberApiController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("")
    public CreateMemberResponse saveMember1(@RequestBody @Valid MemberDTO memberDTO){
        Long id = memberService.join(memberDTO);
        String userId = memberDTO.getUserId();
        String name = memberDTO.getName();
        return new CreateMemberResponse(id,userId,name);
    }

    //회원조회(전체)
    @GetMapping("")
    public WrapResult listMember(){
        List<Member> members = memberService.findMembers();
        List<AllMembersFindListResponse> collect = members.stream()
                .map(m -> new AllMembersFindListResponse(m.getId(), m.getUserId(), m.getNickname(), m.getName()))
                .collect(Collectors.toList());

        return new WrapResult(collect);

    }



    //회원조회(이름으로 조회)
//    @GetMapping("/{name}")
//    public MemberDTO

    //회원조회(이메일로 조회)
//    @GetMapping("/{email}")
//    public MemberDTO

    //회원조회(일주로 조회)


    //회원수정
    @PutMapping("/{id}")
    public UpdateMemberResponse updateMember(
            @PathVariable("id") Long id,
            @RequestBody @Valid MemberDTO memberDTO){

        memberService.changeMemberInfo(memberDTO, id);
        Member member = memberService.findMember(id).orElseThrow(NoSuchElementException::new);
        return new UpdateMemberResponse(member.getId(), member.getUserId(), member.getName());
    }

    //회원삭제
    @DeleteMapping("/{id}")
    public DeleteMemberResponse deleteMember(@PathVariable("id") Long id){
        Member member = memberService.findMember(id).orElseThrow(NoSuchElementException::new);
        memberService.deleteMember(member);
        return new DeleteMemberResponse(member.getId(), member.getUserId(), member.getName());
    }



}
