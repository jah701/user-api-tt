package com.user.api.security;

import com.user.api.model.User;

public interface AuthenticationService {
    User register(User user);
}
