package com.messages.controller;


import com.messages.service.UserService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class WebController {

    @Autowired
    private UserService iUserService;

    @GetMapping("/login")
    public String getLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Nếu chưa login thì chuyển về trang login
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "sign-in";
        }
        return "redirect:/";
    }

    @GetMapping("/chat")
    public String homeChat(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, Model model, Principal principal) {
        model.addAttribute("list",iUserService.getlistExceptUserChat(userDetailServiceImpl.getId()));
        return "chat";
    }

    @GetMapping("/index")
    public String getHome() {
        return "index";
    }
}