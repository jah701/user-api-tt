package com.user.api.event;

import com.user.api.model.Role;
import com.user.api.service.RoleService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Log4j
@Component
public class OnApplicationEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoleService roleService;

    @Autowired
    public OnApplicationEvent(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try {
            roleService.getByRoleName("USER");
            roleService.getByRoleName("ADMIN");
        } catch (NoSuchElementException e) {
            log.info("Injecting roles. . .");
            Role user = Role.of("USER");
            Role admin = Role.of("ADMIN");
            roleService.add(user);
            roleService.add(admin);
            log.info("Roles have been added successfully");
        }
    }
}
