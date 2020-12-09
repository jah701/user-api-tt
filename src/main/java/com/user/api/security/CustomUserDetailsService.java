package com.user.api.security;

import com.user.api.model.User;
import com.user.api.repository.RoleRepository;
import com.user.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can't get user wth name: "
                        + username));
        UserBuilder builder
                = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        String[] roles = user.getRoles().stream()
                .map(r -> r.getRoleName().toString())
                .toArray(String[]::new);
        builder.roles(roles);
        return builder.build();
    }
}
