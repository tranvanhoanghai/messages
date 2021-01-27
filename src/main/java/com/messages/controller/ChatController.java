package com.messages.controller;

import com.messages.entity.Messengers;
import com.messages.repository.MessengersRepository;
import com.messages.service.UserService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessengersRepository messengersRepository;

    @GetMapping("/chat")
    public String homeChat(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, Model model) {
        model.addAttribute("list",userService.getListExceptUserChat(userDetailServiceImpl.getId()));
        return "chat";
    }

    @PostMapping("/chat")
    public String search(Model model, String key) {
        model.addAttribute("list", userService.searchUser(key));
        return "chat";
    }

    @GetMapping("/conversation/{id}/mess")
    @ResponseBody
    public List<Messengers> getMessByIdConversation(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, @PathVariable(value = "id") Integer id, Model model){
//        model.addAttribute("list",userService.getListExceptUserChat(userDetailServiceImpl.getId()));
//        model.addAttribute("mess", messengersRepository.getMessByIdConversation(id));
        return  messengersRepository.getMessByIdConversation(id);
    }
}
