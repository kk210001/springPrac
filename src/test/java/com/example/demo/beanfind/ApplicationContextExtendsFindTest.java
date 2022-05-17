package com.example.demo.beanfind;

import discount.DiscountPoilcy;
import discount.FixDiscountPolicy;
import discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입 조회시, 자식 둘 이상 있으면, 중복오류 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPoilcy.class));

    }

    @Test
    @DisplayName("부모 타입 조회시, 자식 둘 이상 있으면, 빈 이름 지정하면 된다")
    void findBeanByParentTypeBeanName() {
        DiscountPoilcy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPoilcy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 조회")
    void findAllBeanByParentType(){
        Map<String, DiscountPoilcy> beansOfType = ac.getBeansOfType(DiscountPoilcy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s + " value = " + beansOfType.get(s));
        }
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회 object")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s + " value = " + beansOfType.get(s));
        }
    }
   @Configuration
    static class TestConfig{
        @Bean
        public DiscountPoilcy rateDiscountPolicy(){
            return  new RateDiscountPolicy();
        }
        @Bean
        public DiscountPoilcy fixDiscountPolicy(){
            return  new FixDiscountPolicy();
        }
    }
}
