package com.example.demo;

import discount.DiscountPoilcy;
import member.MemberRepository;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan("member")
@ComponentScan("discount")
@ComponentScan("order")
@ComponentScan(
        basePackages = "com.example.demo",//defualt
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))


public class AutoAppConfig {



    //수동 빈 자동 빈 동시 등록 시 수동 빈 우선 등록이였다가 현재는 오류로 바뀜
//    @Bean(name="memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
