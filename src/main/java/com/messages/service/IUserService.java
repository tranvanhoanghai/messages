package com.messages.service;

import com.messages.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void saveReg(User user); // đăng kí
    List<User> getlistExceptUserChat(String exceptUsername); // get user chat trừ user login
}
