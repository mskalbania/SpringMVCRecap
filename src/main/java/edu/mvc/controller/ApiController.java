package edu.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class ApiController {

    @GetMapping("test")
    public String test() {
        return "{TEST : 'aa'}";
    }

}
