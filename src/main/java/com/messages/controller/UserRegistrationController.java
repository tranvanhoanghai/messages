package com.messages.controller;

import com.messages.dto.UserRegistrationDto;
import com.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sign-up")
public class UserRegistrationController {
    @Autowired
    private IUserService iUserService;

//    public UserRegistrationController(IUserService iUserService){
//        super();
//        this.iUserService=iUserService;
//    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "sign-up";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto, Model model, Errors errors) {
        if (errors.hasErrors()){
            return "sign-up";
        }
        try {
            iUserService.save(userRegistrationDto);
        }catch (Exception e){
            //e.printStackTrace();
            model.addAttribute("vc", "username or email is exist");
            return "sign-up";
        }
        return "redirect:/sign-up?success";
    }
}
