package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private String nickname;
    private String email;
    private Role role;
    private UserStatus status;

    public SignupResponseDto(User user) {
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.status = user.getStatus();
    }
}
