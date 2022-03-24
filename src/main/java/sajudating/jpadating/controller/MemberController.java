package sajudating.jpadating.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.MemberDTO;
import sajudating.jpadating.service.MemberService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    //회원 가입(get)
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    //회원 가입(post)
    @PostMapping("members/new")
    public String create(MemberDTO memberDTO){


        memberService.join(memberDTO);

        return "redirect:/";
    }

    //모든 멤버 조회
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
