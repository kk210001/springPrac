package com.example.demo;


import discount.DiscountPoilcy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import member.MemberRepository;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

   // @Autowired MemberRepository memberRepository;

    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRespository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
        //return new OrderServiceImpl(memberRespository(), discountPoilcy());
        return null;

    }


    @Bean()
    public MemberRepository memberRespository(){
        System.out.println("Call AppConfig.memberRespository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPoilcy discountPoilcy(){
        return new RateDiscountPolicy();
    }


}
