package com.example1.demo1.dao;

import javax.transaction.Transactional;

import com.example1.demo1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
// import com.dbms.fresh.model.RowMapperUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class Userdao {

    @Autowired
    JdbcTemplate jt;
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public void saveUser(String UserName, String Pwd,String UserType) {
        String sql = "insert into User (UserName, Pwd, UserType) values (?,?,?)";
        // String encrytedPassword = this.passwordEncoder.encode(password);
        jt.update(sql, UserName,Pwd, UserType);
    }
    


    public User findByUsername(String username) {
        String sql = "select * from User where UserName='" + username + "'";
        return jt.queryForObject(sql, new RowMapper<User>() {

            public User mapRow(ResultSet row, int rowNum) throws SQLException {
                User u = new User();
                u.setUserName(row.getString("UserName"));
                u.setPwd(row.getString("Pwd"));
                u.setUserType(row.getString("UserType"));
                return u;
            }
        });
    }  

    

    

    public boolean userExist(String username) {
        String sql = "select count(*) from user where username=?";
        int p = jt.queryForObject(sql, Integer.class, username);
        if (p == 0)
            return false;
        else
            return true;
    }
}