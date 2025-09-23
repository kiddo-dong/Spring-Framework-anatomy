package com.example.Member_CRUD.repository;

import com.example.Member_CRUD.domain.Member;
import org.apache.catalina.User;

import java.util.Optional;

public interface MemberRepository {
    void addMember(Member member);
    Optional<Member> findByUser(String id);
    void updateUserByid(String id, Member member);
    void deleteUserByid(String id);
}
