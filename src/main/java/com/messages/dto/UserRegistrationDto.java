package com.messages.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String username;
    private String fullName;
    private String password;
    private String email;
}
