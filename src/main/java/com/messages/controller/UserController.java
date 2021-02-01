package com.messages.controller;

import com.messages.entity.User;
import com.messages.repository.UserRepository;
import com.messages.service.FriendService;
import com.messages.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FriendService friendService;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/{id}") // profile user
    public String view(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("count", friendService.countFriend(id));
        return "profile/profile";
    }

    @GetMapping("/{id}/edit") // get id profile user edit
    public String edit(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("edit", userRepository.findById(id));
        return "profile/edit";
    }

    @PostMapping("/{id}/edit") // update profile user
    public String save(Model model, @Valid @ModelAttribute("edit") User user, BindingResult errors){
        if (errors.hasErrors()){
            return "profile/edit";
        }
        try {
            userRepository.save(user);
            model.addAttribute("success", "Successful update");
        }catch (Exception e){
            model.addAttribute("isExist", "Email is exist");
            return "profile/edit";
        }
        return "profile/edit";
    }
    @PostMapping("/upload/{id}")
    public RedirectView saveUser(@PathVariable(value = "id") Integer id, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("er");
        }
        userService.uploadUserImg(fileName, id);
        return new RedirectView("/profile/{id}", true);

    }
}
