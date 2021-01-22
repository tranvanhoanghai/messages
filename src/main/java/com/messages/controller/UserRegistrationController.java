package com.messages.controller;

import com.messages.entity.User;
import com.messages.repository.UserRepository;
import com.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign-up")
public class UserRegistrationController
{
    @Autowired
    private IUserService iUserService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") User user, Model model, BindingResult errors) {
        if (errors.hasErrors()){
            return "sign-up";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        iUserService.saveReg(user);

//        try {
//            iUserService.saveReg(user);
//        }catch (Exception e){
//            model.addAttribute("isExist", "username or email is exist");
//            return "sign-up";
//        }

        return "redirect:/sign-up?success";
    }
}
