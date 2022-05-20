package com.example.demo.autowired.AllBeanTest;

import com.example.demo.AutoAppConfig;
import discount.DiscountPoilcy;
import member.Grade;
import member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void FindAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member member = new Member(1l, "userA", Grade.Vip);
         int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member,20000,"rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }



    static  class DiscountService{
        private  final Map<String, DiscountPoilcy> poilcyMap;
        private final List<DiscountPoilcy> poilcyList;

        @Autowired
        public DiscountService(Map<String, DiscountPoilcy> poilcyMap, List<DiscountPoilcy> poilcyList) {
            this.poilcyMap = poilcyMap;
            this.poilcyList = poilcyList;
            System.out.println("poilcyMap = " + poilcyMap);
            System.out.println("poilcyList = " + poilcyList);
        }


        public int discount(Member member, int price, String policyName) {
            DiscountPoilcy discountPoilcy = poilcyMap.get(policyName);
            return discountPoilcy.discount(member, price);
        }
    }


}
