package com.example.MemberREST_gpt.controller;

import com.example.MemberREST_gpt.domain.Member;
import com.example.MemberREST_gpt.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// RestController 선언으로 ResponseBody 선언 X 및 JSON으로 반환(default)
@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public String addMember(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @GetMapping("/member")
    public List<Member> AllMembers(){
        return memberService.AllMember();
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable String id) {
        return memberService.findMemberById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}