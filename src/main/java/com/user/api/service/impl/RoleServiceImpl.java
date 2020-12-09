package com.user.api.service.impl;

import com.user.api.model.Role;
import com.user.api.repository.RoleRepository;
import com.user.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(Role.of(roleName).getRoleName())
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find role with name '" + roleName + "'"));
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }
}
