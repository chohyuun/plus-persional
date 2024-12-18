package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserStatus;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String nickname;
    private String email;
    private Role role;
    private UserStatus status;

    public UserResponseDto(Long id, String nickname, String email, Role role, UserStatus status) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
        this.status = status;
    }
}
