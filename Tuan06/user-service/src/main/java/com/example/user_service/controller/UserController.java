package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.getAll();
    }
}