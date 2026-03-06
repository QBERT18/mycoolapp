package com.learn.springboot.mycoolapp.config;

import com.learn.springboot.mycoolapp.common.Coach;
import com.learn.springboot.mycoolapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // @Bean // is used to define a bean, and the method name is the default bean id
    @Bean(name = "aquatic") // specify a custom bean id
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
