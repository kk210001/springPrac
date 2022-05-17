package com.example.demo;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member memberA = new Member(1l, "memberA", Grade.Vip);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1l);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("find member = " + findmember.getName());
    }
}
