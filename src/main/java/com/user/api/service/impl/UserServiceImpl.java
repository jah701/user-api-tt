package com.user.api.service.impl;

import com.user.api.model.User;
import com.user.api.repository.UserRepository;
import com.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }


    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name)
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find user with name " + name));
    }
}