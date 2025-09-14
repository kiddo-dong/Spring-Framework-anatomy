package com.example.MemberREST_gpt.service;

import com.example.MemberREST_gpt.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    String addMember(Member member);
    List<Member> AllMember();
    Optional<Member> findMemberById(String id);
}
