package com.example1.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

// import com.example1.demo1.models.Customer;
import com.example1.demo1.models.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Supplierdao{

    @Autowired
    JdbcTemplate jt;



    public void addSupplier(String Company, String Address, int Phno){
        String sql = "insert into Supplier (Company,Address,Phno) values(?,?,?)";
        jt.update(sql, Company, Address, Phno);
    }

    public void deleteSupplier(int id){
        String sql = "delete from Supplier where SupplierId=?";
        jt.update(sql,id);
    }
    
    public void updateSupplier(int id, String Company,String Address, int Phno){
        String sql = "update Supplier set Company=?,Address=?,Phno=? where SupplierId=?";
        jt.update(sql,Company,Address,Phno,id);
    }

    public List<Supplier> getSupplier(){  
        return jt.query("select SupplierId,Company,Address,Phno from Supplier",new RowMapper<Supplier>(){  
            public Supplier mapRow(ResultSet rs, int row) throws SQLException {
                Supplier e=new Supplier();  
                e.setSupplierId(rs.getInt(1));
                e.setCompany(rs.getString(2));  
                e.setAddress(rs.getString(3));
                e.setPhno(rs.getInt(4));
                return e;
            }  
        });
        
    } 

}




