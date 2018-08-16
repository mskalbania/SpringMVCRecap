package edu.mvc.controller;

import edu.mvc.model.Post;
import edu.mvc.service.PostsPersistenceService;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api")
public class ApiController {

    private PostsPersistenceService postsPersistenceService;
    private Logger logger;

    public ApiController(PostsPersistenceService postsPersistenceService, Logger logger) {
        this.postsPersistenceService = postsPersistenceService;
        this.logger = logger;
    }

    @PostMapping(value = "/create", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Constraint validation at binding : {}", post);
            return new ResponseEntity<>(bindingResult.getModel().toString(), HttpStatus.BAD_REQUEST);
        } else {
            final Post saved = postsPersistenceService.save(post);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@RequestParam("min") String min, @RequestParam("max") String max) {
        try {
            final Integer minInt = Integer.parseInt(min);
            final Integer maxInt = Integer.parseInt(max);
            final List<Post> posts = postsPersistenceService.get(minInt, maxInt);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
