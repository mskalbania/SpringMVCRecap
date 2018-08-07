package edu.mvc.controller;

import edu.mvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("webapp")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

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
        if(bindingResult.hasErrors()) {
            return "userform";
        }
        return "onUserFormProcessed";
    }
}
