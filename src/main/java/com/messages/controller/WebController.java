package com.messages.controller;


import com.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Map;


@Controller
public class WebController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/login")
    public String getLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "sign-in";
        }
        return "redirect:/";
    }

    @GetMapping("/chat")
    public String homeChat(Model model, Principal principal) {
        model.addAttribute("list",iUserService.getlistExceptUserChat(principal.getName()));
        return "chat";
    }

    @GetMapping("/index")
    public String getHome() {
        return "index";
    }



}