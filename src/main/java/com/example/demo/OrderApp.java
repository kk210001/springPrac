package com.example.demo;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;
import order.Order;
import order.OrderService;
import order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService =  appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberid = 1l;
        Member memberA = new Member(1l, "memberA", Grade.Vip);
        memberService.join(memberA);

        Order order = orderService.calculateOrder(memberid, "itemA", 20000);
        
        System.out.println("order = " + order);
        System.out.println("order.calculaterPrice() = " + order.calculaterPrice());

    }
}
