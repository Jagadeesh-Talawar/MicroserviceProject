package com.auth.service;

import com.auth.model.User;
import com.auth.model.UserDto;
import com.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,
    PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRoles());

    }
}
