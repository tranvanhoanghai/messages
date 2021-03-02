package com.messages.controller;

import com.messages.entity.Group;
import com.messages.entity.GroupUser;
import com.messages.entity.User;
import com.messages.repository.GroupChatRepository;
import com.messages.repository.GroupUserRepository;
import com.messages.service.GroupChatService;
import com.messages.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
//@RequestMapping("/group/")
public class GroupChatController {

    @Autowired
    private GroupChatService groupChatService;

    @Autowired
    private GroupChatRepository groupChatRepository;

    @Autowired
    private GroupUserRepository groupUserRepository;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/group")
    public String homeGroupChat(@AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl, Model model) {
        model.addAttribute("listGroup",groupChatService.getListGroupChat(userDetailServiceImpl.getId()));
        return "groupChats/groupChat";
    }

    @GetMapping("/group/{id}/mess")
    public String getMessByIdGroupChat(@PathVariable(value = "id") Integer id, Model model, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl) {
        model.addAttribute("listGroup",groupChatService.getListGroupChat(userDetailServiceImpl.getId()));
        model.addAttribute("contentMess",groupChatService.getMessGroupChat(id));
        model.addAttribute("group",groupChatRepository.findById(id).get());
        model.addAttribute("updateGroup", groupChatRepository.findById(id)); // update Group

        return "groupChats/groupChatConversation";
    }

    @PostMapping("/group/add")
    public String addGroup(@ModelAttribute("group") Group group, GroupUser groupUser, @AuthenticationPrincipal UserDetailServiceImpl userDetailServiceImpl)  throws IOException
    {
        groupChatRepository.save(group); // add group

        // add user_id và group_id vào group user
        groupUser.setGroup_id(group);
        User user = new User();
        user.setId(userDetailServiceImpl.getId());
        groupUser.setUser_id(user);
        groupUser.setIsAdmin(1);
        groupUserRepository.save(groupUser);

        return "redirect:/group";
    }

    @PostMapping("/group/update/{id}")
    public String updateGroup(@PathVariable(value = "id") Integer id, @ModelAttribute("updateGroup") Group group, GroupUser groupUser)
    {
        group.setId(id);
        groupChatRepository.save(group);
        return "redirect:/group/{id}/mess";
    }

    @PostMapping("/group/upload/{id}")
    public String uploadGroup(@PathVariable(value = "id") Integer id,  @RequestParam("image") MultipartFile multipartFile, @ModelAttribute("updateGroup") Group group )  throws IOException
    {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("er");
        }
        group.setId(id);
        group.setGroupImg(fileName);
        groupChatRepository.save(group);
        return "redirect:/group/{id}/mess";
    }
}
