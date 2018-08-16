package edu.mvc.controller;

import edu.mvc.service.DataPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {

    private DataPersistenceService dataPersistenceService;

    @Autowired
    public ApiController(DataPersistenceService dataPersistenceService) {
        this.dataPersistenceService = dataPersistenceService;
    }

    @GetMapping("test")
    public String test() {
        dataPersistenceService.testPersist();
        return "";
    }

}
