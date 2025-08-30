package com.example.MemberService.service;

import com.example.MemberService.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class MemberServiceImp implements MemberService{
    private List<Member> members = new ArrayList<>();

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        Optional<Member> foundObjectStream = members.stream()
                .filter(obj -> obj.getId() == id)
                .findFirst(); // 첫 번째 일치하는 객체를 Optional로 반환

        return foundObjectStream;
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }
}
