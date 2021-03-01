package com.messages.controller;

import com.messages.entity.Messengers;
import com.messages.entity.User;
import com.messages.repository.MessengersRepository;
import com.messages.service.MessengersService;
import com.messages.service.UserService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessengersService messengersService;


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

    @GetMapping("/conversation/{id}/mess/{idUser}")
    public String getMessByIdConversation(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, @PathVariable(value = "id") Integer id,  @PathVariable(value = "idUser") Integer idUser, Model model){
        model.addAttribute("list",userService.getListExceptUserChat(userDetailServiceImpl.getId()));
        model.addAttribute("mess", messengersService.getAllMessByIdCvt(id));

        User user =  userService.getUserById(idUser);
        model.addAttribute("user", user);
        return "chatConversation";
    }

//    @GetMapping("/conversation/add")
//    @ResponseBody
//    public String setMessByIdConversation(String content, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl){
//        messengersService.saveMess(1,userDetailServiceImpl.getId(),null,"content");
//        return "chat";
//    }

//    @GetMapping("/conversation/{id}/mess")
//    @ResponseBody
//    public List<Messengers> getMessByIdConversations(@PathVariable(value = "id") Integer id){
//        return  messengersService.getAllMessByIdCvt(id);
//    }


}
