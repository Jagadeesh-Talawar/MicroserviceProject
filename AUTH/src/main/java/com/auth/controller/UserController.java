package com.auth.controller;

import com.auth.model.User;
import com.auth.model.UserDto;
import com.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user){

       UserDto userDto = userService.saveUser(user);
       return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
