package com.example.MemberREST_gpt.repository;

import com.example.MemberREST_gpt.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImp implements MemberRepository{

    private List<Member> members = new ArrayList<>();

    @Override
    public Boolean addMember(Member member){
        members.add(member);
        return true;
    }

    @Override
    public List<Member> findAllMember(){
        return members;
    }

    @Override
    public Optional<Member> findMemberById(String id){
        return members.stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }
}
