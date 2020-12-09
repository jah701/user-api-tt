package com.user.api.service;

import com.user.api.model.User;

public interface UserService {
    void add(User user);

    User findUserByName(String name);
}
