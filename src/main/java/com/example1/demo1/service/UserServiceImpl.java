package com.example1.demo1.service;

import com.example1.demo1.dao.Userdao;
import com.example1.demo1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Userdao userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        userRepository.saveUser(user.getUserName(), user.getPwd(), user.getUserType());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
