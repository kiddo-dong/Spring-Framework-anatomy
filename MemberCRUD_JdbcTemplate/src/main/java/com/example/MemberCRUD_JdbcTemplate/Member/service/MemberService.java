package com.example.MemberCRUD_JdbcTemplate.Member.service;

import com.example.MemberCRUD_JdbcTemplate.Member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void addMember(Member member);
    Optional<Member> findMemberById(int id);
    void updateMemberById(int id, Member member);
    void deleteMemberById(int id);
    List<Member> findUsers();
}
