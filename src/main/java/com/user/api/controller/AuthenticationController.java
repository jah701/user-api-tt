package com.user.api.controller;

import com.user.api.mapper.UserMapper;
import com.user.api.model.dto.UserRequestDto;
import com.user.api.model.dto.UserResponseDto;
import com.user.api.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService, UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {
        return userMapper.userToUserDto(
                authenticationService.register(
                        userMapper.userDtoToUser(dto)));
    }
}
