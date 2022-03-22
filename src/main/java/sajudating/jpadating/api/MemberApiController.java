package sajudating.jpadating.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.DTO.MemberDTO;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.service.MemberService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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
    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;
        private String userId;
        private String name;
    }


    //회원조회

    @GetMapping("")
    public Result listMember(){
        List<Member> members = memberService.findMembers();
        List<MemberListDTO> collect = members.stream()
                .map(m -> new MemberListDTO(m.getId(), m.getUserId(), m.getNickname(), m.getName()))
                .collect(Collectors.toList());

        return new Result(collect);

    }
    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }
    @Data
    @AllArgsConstructor
    static class MemberListDTO{
        private Long id;
        private String userId;
        private String nickName;
        private String name;
    }

    //회원수정

    @PutMapping("/{id}")
    public UpdateMemberResponse updateMember(
            @PathVariable("id") Long id,
            @RequestBody @Valid MemberDTO memberDTO){

        memberService.changeMemberInfo(memberDTO, id);
        Member member = memberService.findMember(id).orElseThrow(NoSuchElementException::new);
        return new UpdateMemberResponse(member.getId(), member.getUserId(), member.getName());
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String userId;
        private String name;
    }

    //회원삭제
    @DeleteMapping("/{id}")
    public DeleteMemberResponse deleteMember(@PathVariable("id") Long id){
        Member member = memberService.findMember(id).orElseThrow(NoSuchElementException::new);
        memberService.deleteMember(member);
        return new DeleteMemberResponse(member.getId(), member.getUserId(), member.getName());
    }

    @Data
    @AllArgsConstructor
    static class DeleteMemberResponse {
        private Long id;
        private String userId;
        private String name;
    }

}
