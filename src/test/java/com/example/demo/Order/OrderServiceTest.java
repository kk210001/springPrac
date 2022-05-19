package com.example.demo.Order;

import com.example.demo.AppConfig;

import discount.FixDiscountPolicy;
import member.Grade;
import member.Member;
import member.MemberService;
import member.MemoryMemberRepository;
import order.Order;
import order.OrderService;
import order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public  void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1l;
        Member memberA = new Member(1l, "memberA", Grade.Vip);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);



    }
//    @Test
//    void filedInjectionTest(){
//        OrderServiceImpl orderService = new OrderServiceImpl();
//
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        orderService.setDiscountPoilcy(new FixDiscountPolicy());
//
//        orderService.createOrder(1l,"itemA",10000);
//    }


}
