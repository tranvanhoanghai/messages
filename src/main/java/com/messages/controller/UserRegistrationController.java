package com.messages.controller;

import com.messages.dto.UserRegistrationDto;
import com.messages.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private IUserService iUserService;

    public UserRegistrationController(IUserService iUserService){
        super();
        this.iUserService=iUserService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        iUserService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
