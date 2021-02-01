package com.messages.controller;

import com.messages.entity.Conversation;
import com.messages.repository.MessengersRepository;
import com.messages.service.ConversationService;
import com.messages.service.FriendService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/conversation")
public class ConversationController
{
    @Autowired
    private ConversationService conversationService;

    @Autowired
    private FriendService friendService;

    @GetMapping("/{id}")
    @ResponseBody
    public Conversation checkCvt(@PathVariable(value = "id") Integer id, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl){

        return conversationService.checkCvt(id, userDetailServiceImpl.getId());
    };

//    @GetMapping("/{id}")
//     @ResponseBody
//    public Friend checkFriend(@PathVariable(value = "id") Integer id, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl){
//        return friendService.checkFriends(id, userDetailServiceImpl.getId());
//    };

}