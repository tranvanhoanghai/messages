package com.messages.service;

import com.messages.dto.UserRegistrationDto;
import com.messages.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}
