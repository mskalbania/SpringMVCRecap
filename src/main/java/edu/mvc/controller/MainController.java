package edu.mvc.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private Logger logger;

    @Autowired
    public MainController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("hello")
    public String test() {
        logger.info("Test method invoked.");
        return "test";
    }
}
