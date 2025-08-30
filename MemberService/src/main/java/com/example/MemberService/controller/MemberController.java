package com.example.MemberService.controller;

import com.example.MemberService.domain.Member;
import com.example.MemberService.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // View에서 Member요소 넘어옴
    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public String addMember(
            @RequestParam Long id,
            @RequestParam int age,
            @RequestParam String name
    ){
        Member member = new Member();
        member.setId(id);
        member.setAge(age);
        member.setName(name);

        memberService.addMember(member);
        return "redirect:/path";
    }
}
