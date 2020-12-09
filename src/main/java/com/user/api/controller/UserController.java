package com.user.api.controller;

import com.user.api.model.Role;
import com.user.api.model.User;
import com.user.api.repository.UserRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> read(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping("/inject")
    public void inject() {
        User bob = User.builder().name("bob").roles(Set.of(Role.of("USER"))).build();
        User alice = User.builder().name("alice").roles(Set.of(Role.of("USER"))).build();
        userRepository.save(bob);
        userRepository.save(alice);
    }
}
