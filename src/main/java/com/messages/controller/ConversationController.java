package com.messages.controller;

import com.messages.entity.Conversations;
import com.messages.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conversation")
public class ConversationController
{
    @Autowired
    private ConversationService conversationService;

    @GetMapping("/check/{id}")
    public String checkCvt(@PathVariable(value = "id") Integer id, Model model){
        Conversations conversations = conversationService.checkCvt(id, 1);
        model.addAttribute("check", conversations);
        return "update";
    }

}
