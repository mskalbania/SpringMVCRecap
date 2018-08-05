package edu.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public Logger logger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getDeclaredType());
    }
}