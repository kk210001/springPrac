package com.example.demo.scan.fillter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.assertj.core.api.Assertions.assertThat;

import javax.swing.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterscan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFillterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();


        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));

    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(classes = MyIncludeComponent.class),//default type= FilterType.ANNOTATION
            excludeFilters = {
                    @ComponentScan.Filter(classes = MyExcludeComponent.class)
 //                   ,@ComponentScan.Filter( type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class) 클래스 지정 제외

            }
    )
    static class ComponentFillterAppConfig {

    }
}
