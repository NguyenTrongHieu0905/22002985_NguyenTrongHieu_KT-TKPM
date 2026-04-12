package com.example.user_service.service;

import com.example.user_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    public User register(User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    public User login(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAll() {
        return users;
    }
}