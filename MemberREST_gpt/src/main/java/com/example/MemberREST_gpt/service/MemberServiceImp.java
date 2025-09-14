package com.example.MemberREST_gpt.service;

import com.example.MemberREST_gpt.domain.Member;
import com.example.MemberREST_gpt.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String addMember(Member member) {
        boolean result = memberRepository.addMember(member);
        if(result){
            return "add member successed";
        }
        return "add member failed";
    }

    @Override
    public List<Member> AllMember() {
        return memberRepository.findAllMember();
    }

    @Override
    public Optional<Member> findMemberById(String id) {
        return memberRepository.findMemberById(id);
    }
}
