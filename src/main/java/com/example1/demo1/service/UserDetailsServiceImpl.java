package com.example1.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example1.demo1.dao.Userdao;
import com.example1.demo1.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    Userdao userdao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userdao.findByUsername(userName);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserType().toString());
        grantList.add(authority);

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPwd(), grantList);

        return userDetails;
    }

}