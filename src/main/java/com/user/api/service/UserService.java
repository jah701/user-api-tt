package com.user.api.service;

import com.user.api.model.User;
import java.util.List;

public interface UserService {
    User add(User user);

    User findUserByName(String name);

    List<User> findAll();
}
