package com.example.demo.singleton;

import com.example.demo.AppConfig;
import member.MemberRepository;
import member.MemberServiceImpl;
import order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class ConfigSingleTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRespository = ac.getBean("memberRespository", MemberRepository.class);

        MemberRepository memberRepository2 = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();

        System.out.println("order -> memberRepository1 = " + memberRepository1);
        System.out.println("member -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRespository = " + memberRespository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRespository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRespository);

    }

    @Test
    void  configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
