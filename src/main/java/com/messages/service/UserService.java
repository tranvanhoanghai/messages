package com.messages.service;

import com.messages.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService
{
    void saveReg(User user); // Tạo phương thức đăng kí.

    User getUserById(Integer id);

    List<User> getListExceptUserChat(Integer exceptUsername); // lấy user nằm trong list bạn bè ngoại trừ user login

    List<User> searchUser(String key); // Tìm kiếm tất cả user.

    void uploadUserImg(String img, Integer id); // upload img user


}
