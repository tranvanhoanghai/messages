package com.messages.controller;

import com.messages.entity.Friend;
import com.messages.repository.FriendRepository;
import com.messages.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendsController {
    @Autowired
    private FriendRepository friendRepository;


    @PostMapping("/addFriend/{id}") // gửi lời mời kết bạn khi user chưa có trong table friend
    public String addFriend(@PathVariable(value = "id") Integer id, @ModelAttribute("friend") Friend friend){
        friend.setStatus(1);
        friendRepository.save(friend);
        return "redirect:/profile/{id}";
    }

    @PostMapping("/addFriends/{id}") // gửi lời mời kết bạn khi user có trong table friend (status = 0)
    public String addFriends(@PathVariable(value = "id") Integer id, @ModelAttribute("update") Friend friend){
        friend.setStatus(1);
        friendRepository.save(friend);
        return "redirect:/profile/{id}";
    }

    @PostMapping("/confirmFriend/{id}") // xác nhận lời mời
    public String confirmFriend(@PathVariable(value = "id") Integer id, @ModelAttribute("update") Friend friend){
        friend.setStatus(2);
        friendRepository.save(friend);
        return "redirect:/profile/{id}";
    }

    @PostMapping("/cancelFriend/{id}") // Huỷ kết bạn
    public String cancelFriend(@PathVariable(value = "id") Integer id, @ModelAttribute("update") Friend friend){
        friend.setStatus(0);
        friendRepository.save(friend);
        return "redirect:/profile/{id}";
    }

    @PostMapping("/blockFriend") // Chặn
    public String blockFriend(@ModelAttribute("update") Friend friend){
        friend.setStatus(3);
        friendRepository.save(friend);
        return "profile/block";
    }
}
