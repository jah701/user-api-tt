package com.user.api.mapper;

import com.user.api.model.User;
import com.user.api.model.dto.UserRequestDto;
import com.user.api.model.dto.UserResponseDto;
import com.user.api.service.RoleService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserMapper(RoleService roleService, BCryptPasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.encoder = passwordEncoder;
    }

    public User userDtoToUser(UserRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .build();
    }

    public UserResponseDto userToUserDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }
}
