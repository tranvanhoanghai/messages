package com.messages.controller;

import com.messages.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String getLogin() {
        return "sign-in";
    }

    @GetMapping("/chat")
    public String home() {
        return "chat";
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }


    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
