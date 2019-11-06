package com.example1.demo1.service;

import com.example1.demo1.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
