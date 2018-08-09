package edu.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
@Import(AmbiguousBeansConfig.class)
public class RootConfig {

    //Additional beans are defined here
    //Root context applies to all servlet contexts
    //Should define beans which will be shared across all servlet contexts

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    @Profile("dev") //Just for example
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getDeclaringClass());
    }
}