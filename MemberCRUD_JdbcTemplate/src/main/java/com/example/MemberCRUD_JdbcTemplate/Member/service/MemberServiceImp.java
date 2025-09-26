package com.example.MemberCRUD_JdbcTemplate.Member.service;

import com.example.MemberCRUD_JdbcTemplate.Member.domain.Member;
import com.example.MemberCRUD_JdbcTemplate.Member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    @Override
    public Optional<Member> findMemberById(int id) {
        return memberRepository.findMemberById(id);
    }

    @Override
    public void updateMemberById(int id, Member member) {
        memberRepository.updateMemberById(id, member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.deleteMemberById(id);
    }
}
