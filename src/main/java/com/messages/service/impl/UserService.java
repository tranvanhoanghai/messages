package com.messages.service.impl;

import com.messages.entity.User;
import com.messages.repository.UserRepository;
import com.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {

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

//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//
//        List<Role> roles = user.getRoles();
//        for (Role role : roles) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }

//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        return new UserDetailService(user);
    }

    @Override // get user chat trừ user login
    public List<User> getlistExceptUserChat(String exceptUsername) {
        return userRepository.listExceptUserChat(exceptUsername);
    }


//    @Override
//    public void saveReg(User user) {
//        new User(user.getUsername(),user.getFullName(), user.getEmail(),
//                passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
}
