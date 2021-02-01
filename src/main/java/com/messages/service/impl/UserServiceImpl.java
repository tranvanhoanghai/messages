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

    @Override // lấy user nằm trong list bạn bè ngoại trừ user login
    public List<User> getListExceptUserChat(Integer exceptUsername) {
        return userRepository.listExceptUserChat(exceptUsername);
    }

    @Override
    public List<User> searchUser(String key) {
        return userRepository.findByFirstName(key);
    }

    @Override
    public void uploadUserImg(String img, Integer id) {
        userRepository.updateUserImg(img, id);
    }
}
