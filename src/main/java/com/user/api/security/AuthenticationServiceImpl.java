package com.user.api.security;

import com.user.api.model.User;
import com.user.api.service.RoleService;
import com.user.api.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setRoles(Set.of(roleService.getByRoleName("USER")));
        userService.add(user);
        return user;
    }
}
