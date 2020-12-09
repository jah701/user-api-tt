package com.user.api.controller;

import com.user.api.mapper.UserMapper;
import com.user.api.model.dto.UserRequestDto;
import com.user.api.model.dto.UserResponseDto;
import com.user.api.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto dto) {
        return userMapper.userToUserDto(
                userService.add(
                        userMapper.userDtoToUser(dto)));
    }

    @PostMapping("/edit")
    public UserResponseDto edit(@RequestBody UserRequestDto dto) {
        return userMapper.userToUserDto(userMapper.userDtoToUser(dto));
    }

    @GetMapping("/{name}")
    public UserResponseDto read(@PathVariable String name) {
        return userMapper.userToUserDto(userService.findUserByName(name));
    }
}
