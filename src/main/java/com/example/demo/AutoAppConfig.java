package com.example.demo;

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

}
