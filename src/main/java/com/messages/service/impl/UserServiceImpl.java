package com.messages.service.impl;

import com.messages.entity.User;
import com.messages.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements com.messages.service.UserService {

    @Autowired //inject bean
    private UserRepository userRepository;

    @Override // Đăng kí user
    public void saveReg(User user) {
         userRepository.save(user);
    }


    @Override // Cấu hình đăng nhập
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UserDetailServiceImpl(user);
    }

    @Override // get user chat trừ user login
    public List<User> getlistExceptUserChat(Integer exceptUsername) {
        return userRepository.listExceptUserChat(exceptUsername);
    }
}
