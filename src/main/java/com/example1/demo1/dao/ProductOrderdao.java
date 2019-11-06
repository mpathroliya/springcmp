
package com.example1.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import com.example1.demo1.models.Customer;
import com.example1.demo1.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ProductOrderdao{

    @Autowired
    JdbcTemplate jt;

    public void addProductOrder(int ProductId, int OrderId, int Quantity){
        String sql = "insert into ProductOrder values(?,?,?)";
        jt.update(sql, Quantity, ProductId, OrderId);

        int sum;
        String asql = "select Price from Product where ProductId =? ";
        int pr = jt.queryForObject(asql, new Object[]{ProductId}, Integer.class);
        String bsql = "select Price from Orders where orderId =?";
        sum = jt.queryForObject(bsql, new Object[]{OrderId}, Integer.class);
        sum = sum + (pr*Quantity);
        String csql ="update Orders set Price = ? where OrderId =?";
        jt.update(csql, sum, OrderId);
    }

    public void deleteProductOrder(int ProductId,int OrderId){
        String sql = "delete from ProductOrder where ProductId=? and OrderId=?";
        jt.update(sql,ProductId,OrderId);
    }
    
    public void deleteProductOrderbyOrder(int OrderId){
        String sql = "delete from ProductOrder where OrderId=?";
        jt.update(sql,OrderId);
    }

}




