package com.messages.service;

import com.messages.dto.UserRegistrationDto;
import com.messages.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto); // Lưu thông tin đăng kí

    List<User> getlistExceptUserChat (String exceptUsername);


}
