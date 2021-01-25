package com.messages.controller;

import com.messages.service.UserService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @GetMapping("/chat")
    public String homeChat(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, Model model, Principal principal) {
        model.addAttribute("list",userService.getListExceptUserChat(userDetailServiceImpl.getId()));
        return "chat";
    }

    @PostMapping("/chat")
    public String search(Model model, String key) {
        model.addAttribute("list", userService.searchUser(key));
        return "chat";
    }
}
