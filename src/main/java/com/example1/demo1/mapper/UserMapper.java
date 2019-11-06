package com.example1.demo1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example1.demo1.models.User;

import org.springframework.jdbc.core.RowMapper;
 
public class UserMapper implements RowMapper<User> {
 
    public static final String BASE_SQL //
            = "Select u.UserName, u.Pwd, u.UseType From User u ";
 
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        String UserName = rs.getString("UserName");
        String Pwd = rs.getString("Pwd");
        String UserType = rs.getString("UserType");
 
        return new User(UserName, Pwd, UserType);
    }
 
}