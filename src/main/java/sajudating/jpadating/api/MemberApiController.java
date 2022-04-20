package sajudating.jpadating.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sajudating.jpadating.apiDto.common.CommonApiResponse;
import sajudating.jpadating.apiDto.common.ResponseMessage;
import sajudating.jpadating.apiDto.common.StatusCode;
import sajudating.jpadating.apiDto.member.*;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.service.MemberService;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/members")
public class MemberApiController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("")
    public ResponseEntity saveMember(@RequestBody @Valid MemberDTO memberDTO){
        Long id = memberService.join(memberDTO);
//        String userId = memberDTO.getUserId();
//        String name = memberDTO.getName();
        return new ResponseEntity(
                new CommonApiResponse<CreateMemberResponse>(StatusCode.OK,
                        ResponseMessage.CREATED_USER),
                HttpStatus.OK);
    }

    //회원조회(전체)
    @GetMapping("")
    public ResponseEntity listMember(){
        List<AllMembersFindListResponse> collect = memberService.findMembers();
        return new ResponseEntity(
                new CommonApiResponse<List>(StatusCode.OK,
                        ResponseMessage.READ_USER,collect),
                HttpStatus.OK);

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
    public ResponseEntity updateMember(
            @PathVariable("id") Long id,
            @RequestBody @Valid MemberDTO memberDTO){

        memberService.changeMemberInfo(memberDTO, id);
        Member member = memberService.findMember(id);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.UPDATE_USER),
                HttpStatus.OK);
    }

    //회원삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable("id") Long id){
        Member member = memberService.findMember(id);
        memberService.deleteMember(member);
        return new ResponseEntity(
                new CommonApiResponse<>(StatusCode.OK,
                        ResponseMessage.DELETE_USER),
                HttpStatus.OK);
    }



}
