package com.example.MemberREST_gpt.repository;

import com.example.MemberREST_gpt.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Boolean addMember(Member member);
    List<Member> findAllMember();
    Optional<Member> findMemberById(String id);
}
