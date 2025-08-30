package com.example.MemberService.service;

import com.example.MemberService.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void addMember(Member member);
    Optional<Member> getMemberById(Long id);
    List<Member> getAllMembers();
}
