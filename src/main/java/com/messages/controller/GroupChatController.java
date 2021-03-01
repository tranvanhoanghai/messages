package com.messages.controller;

import com.messages.repository.GroupChatRepository;
import com.messages.service.GroupChatService;
import com.messages.service.UserService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GroupChatController {

    @Autowired
    private GroupChatService groupChatService;

    @Autowired
    private GroupChatRepository groupChatRepository;


    @GetMapping("/group")
    public String homeGroupChat(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, Model model) {
        model.addAttribute("listGroup",groupChatService.getListGroupChat(userDetailServiceImpl.getId()));
        return "groupChat/groupChat";
    }

    @GetMapping("/group/{id}/mess")
    public String getMessByIdGroupChat(@PathVariable(value = "id") Integer id, Model model, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl) {
        model.addAttribute("listGroup",groupChatService.getListGroupChat(userDetailServiceImpl.getId()));
        model.addAttribute("contentMess",groupChatService.getMessGroupChat(id));
        model.addAttribute("group",groupChatRepository.findById(id).get());

        return "groupChat/groupChatConversation";
    }
}
