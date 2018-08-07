package edu.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
        final String text = request.getParameter("someText");
        model.addAttribute("text", text);
        return "onFormProcessed";
    }
}
