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
public class Productdao{

    @Autowired
    JdbcTemplate jt;

    public void addProduct(String Name, int Price, String Description, int SupplierId){
        String sql = "insert into Product (Name,Price,Description,SupplierId) values(?,?,?,?)";
        jt.update(sql, Name, Price, Description, SupplierId);
    }

    public void deleteProduct(int id){
        String sql = "delete from Product where ProductId=?";
        jt.update(sql,id);
    }
    
    public void updateProduct(int id, String Name, int Price, String Description){
        String sql = "update Product set Name=?,Price=?,Description=? where ProductId=?";
        jt.update(sql,Name,Price,Description,id);
    }

    public void addReview(String Review,int ProductId){
        String sql = "insert into Reviews values(?,?)";
        jt.update(sql,ProductId,Review);

    }

    public List<Product> getProduct(){  
        return jt.query("select * from Product",new RowMapper<Product>(){  
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e=new Product();  
                e.setProductId(rs.getInt(1));
                e.setPrice(rs.getInt(2));  
                e.setName(rs.getString(3));
                e.setDescription(rs.getString(4));
                e.setSupplierId(rs.getInt(5));
                return e;
            }  
        });  
    } 

    public List<Product> getProductNoOrderId(int OrderId){
        return jt.query("select * from Product where ProductId not in(select ProductId from ProductOrder where OrderId ="+ OrderId +")",new RowMapper<Product>(){  
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e=new Product();  
                e.setProductId(rs.getInt(1));
                e.setPrice(rs.getInt(2));  
                e.setName(rs.getString(3));
                e.setDescription(rs.getString(4));
                e.setSupplierId(rs.getInt(5));
                return e;
            }  
        }); 
    }

    public List<Product> getProductWithOrderId(int OrderId){
        return jt.query("select * from Product where ProductId in (select ProductId from ProductOrder where OrderId ="+ OrderId +")",new RowMapper<Product>(){  
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e=new Product();  
                e.setProductId(rs.getInt(1));
                e.setPrice(rs.getInt(2));  
                e.setName(rs.getString(3));
                e.setDescription(rs.getString(4));
                e.setSupplierId(rs.getInt(5));
                return e;
            }  
        }); 
    }


}




