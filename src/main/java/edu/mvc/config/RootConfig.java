package edu.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class RootConfig {
    //Additional beans are defined here
    //Root context applies to all servlet contexts
    //Should define beans which will be shared across all servlet contexts

    @Bean
    @Scope("prototype")
    @Profile("dev") //Just for example
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getDeclaringClass());
    }
}