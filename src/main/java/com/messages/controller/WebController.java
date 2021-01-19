package com.messages.controller;

import com.messages.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/chat")
    public String home() {
        return "index";
    }



    @GetMapping("/sign-in")
    public String sign() {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up";
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
