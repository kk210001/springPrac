package com.example.demo.member;

import com.example.demo.AppConfig;
import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class memberServiceTest {
    MemberService memberService;

    @BeforeEach
    public  void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //give
        Member member =new Member(1l, "memberA", Grade.Vip);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);

        //then
        assertThat(member).isEqualTo(findMember);

    }

}
