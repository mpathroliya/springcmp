package com.example1.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import com.example1.demo1.models.Customer;
// import com.example1.demo1.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Customerdao{

    @Autowired
    JdbcTemplate jt;

    public void addCustomer(String Name, String UserName, int Phone, String Address){
        String sql = "insert into Customer (Name,UserName,Phone,Address) values(?,?,?,?)";
        jt.update(sql, Name,UserName, Phone, Address);
    }

    // public void deleteProduct(int id){
    //     String sql = "delete from Product where ProductId=?";
    //     jt.update(sql,id);
    // }
    
    // public void updateCustomer(String Name, int Phone, String Address){
    //     String sql = "update Customer set Name=?,Phone=?, Address where CustomerId=?";
    //     jt.update(sql, Name, Phone, Address);
    // }
   


    public List<Customer> getCustomer(){  
        return jt.query("select * from Customer",new RowMapper<Customer>(){  
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer e=new Customer();  
                e.setUserName(rs.getString(1));
                e.setName(rs.getString(2));  
                e.setPhone(rs.getInt(3));
                e.setAddress(rs.getString(4));
                return e;
            }  
        });  
    }

}




