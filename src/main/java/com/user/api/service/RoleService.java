package com.user.api.service;

import com.user.api.model.Role;

public interface RoleService {
    Role getByRoleName(String roleName);

    void add(Role role);
}
