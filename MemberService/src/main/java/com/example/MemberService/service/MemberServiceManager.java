package com.example.MemberService.service;

import com.example.MemberService.domain.Member;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Logger;

@Service
public class MemberServiceManager {
    private final Map<String, MemberService> memberServiceMap;
    private final Logger logger = Logger.getLogger(MemberServiceManager.class.getName());

    public MemberServiceManager(Map<String, MemberService> memberServiceMap) {
        this.memberServiceMap = memberServiceMap;
    }

    public void publish(String type,Long id, Member member){
        MemberService memberService = memberServiceMap.get(type);

        if(memberService != null){
            memberService.addMember(member);
            memberService.getMemberById(id);
            memberService.getAllMembers();
        } else {
            logger.info("MemberService is null");
        }
    }
}
