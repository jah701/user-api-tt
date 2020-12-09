package com.user.api.model;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String id;
    private String email;
    private String name;
    private String password;
    private Set<Role> roles;
}
