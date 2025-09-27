package com.example.MemberCRUD_JdbcTemplate.Member.controller;

import com.example.MemberCRUD_JdbcTemplate.Member.domain.Member;
import com.example.MemberCRUD_JdbcTemplate.Member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member){
        memberService.addMember(member);
        return ResponseEntity
                .ok("Add Member Successfully");
    }

    @GetMapping("/{id}")
    public Optional<Member> findUserById(@PathVariable int id){
        return memberService.findMemberById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemberById(@PathVariable int id,
                                           @RequestBody Member member){
        memberService.updateMemberById(id, member);
        return ResponseEntity
                .ok("Update Member Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable int id){
        memberService.deleteMemberById(id);
        return ResponseEntity
                .ok("Delete Member Successfully");
    }

    @PostMapping("/MemberList")
    public ResponseEntity<List<Member>> findMembers(){
        return ResponseEntity
                .ok(memberService.findUsers());
    }
}