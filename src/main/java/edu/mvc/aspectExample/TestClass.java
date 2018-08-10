package edu.mvc.aspectExample;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestClass implements TestInterface {

    private Logger logger;

    @Autowired
    public TestClass(Logger logger) {
        this.logger = logger;
    }

    public void callAll() {
        method1();
    }

    public void method1() {
        logger.info("Called 1.");
    }

}
