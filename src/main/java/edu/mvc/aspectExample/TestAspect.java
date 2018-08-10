package edu.mvc.aspectExample;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    private Logger logger;

    @Autowired
    public TestAspect(Logger logger) {
        this.logger = logger;
    }

    @Before("execution(void edu.mvc.aspectExample.TestInterface.method1(..))")
    public void beforeMethod1() {
        logger.info("Before method 1");
    }

    @After("execution(void edu.mvc.aspectExample.TestInterface.method1(..)))")
    public void afterMethod1() {
        logger.info("After method 1");
    }

}
