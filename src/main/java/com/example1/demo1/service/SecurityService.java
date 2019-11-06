package com.example1.demo1.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
