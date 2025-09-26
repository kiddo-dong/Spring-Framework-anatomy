package com.example.MemberCRUD_JdbcTemplate.Member.repository;

import com.example.MemberCRUD_JdbcTemplate.Member.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void addMember(Member member);
    Optional<Member> findMemberById(int id);
    void updateMemberById(int id, Member member);
    void deleteMemberById(int id);
}
