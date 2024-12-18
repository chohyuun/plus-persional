package com.example.demo.controller;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.dto.Authentication;
import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.SignupResponseDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public SignupResponseDto signupWithEmail(@RequestBody UserRequestDto userRequestDto) {
        return userService.signupWithEmail(userRequestDto);
    }

    @PostMapping("/login")
    public UserResponseDto loginWithEmail(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        UserResponseDto userResponseDto = userService.loginUser(loginRequestDto);
        Authentication authentication = new Authentication(userResponseDto.getId(), userResponseDto.getRole());

        HttpSession session = request.getSession();
        String authRole = authentication.getRole() == Role.USER ? GlobalConstants.USER_AUTH : GlobalConstants.ADMIN_AUTH;
        session.setAttribute(authRole, authentication);

        return userResponseDto;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
