package edu.mvc.controller;

import edu.mvc.model.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("webapp")
public class MainController {

    private final Logger logger;

    @Autowired
    public MainController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("formex")
    public String formex() {
        return "form";
    }

    @PostMapping("processForm")
    public String processForm(HttpServletRequest request, Model model) {
        //Might also use @RequestParameter(<value of name attribute>)
        final String text = request.getParameter("someText");
        model.addAttribute("text", text);
        return "onFormProcessed";
    }

    @GetMapping("userForm")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }

    @PostMapping("processUser")
    public String processUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userform";
        }
        return "onUserFormProcessed";
    }

    @InitBinder //run before each binding
    public void initTrimBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
