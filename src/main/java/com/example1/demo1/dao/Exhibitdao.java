package com.example1.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import com.example1.demo1.models.Customer;
// import com.example1.demo1.models.Product;
import com.example1.demo1.models.Exhibit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Exhibitdao{

    @Autowired
    JdbcTemplate jt;

    public void addExhibit(String UserName,String Curator, int Phone, String City){
        String sql = "insert into Exhibit (UserName,Curator,Phone,City) values(?,?,?,?)";
        jt.update(sql,UserName,Curator, Phone, City);
    }


    public void updateCity(String UserName,String Curator, int Phone, String City){
        String sql = "update Exhibit set Curator=?,Phone=?, City=? where UserName=?";
        jt.update(sql, Curator, Phone, City);
    }
   


    public List<Exhibit> getexhibit(){  
        return jt.query("select * from Exhibit",new RowMapper<Exhibit>(){  
            public Exhibit mapRow(ResultSet rs, int row) throws SQLException {
                Exhibit e=new Exhibit();  
                e.setUserName(rs.getString(1));
                e.setCurator(rs.getString(2));  
                e.setPhone(rs.getInt(3));
                e.setCity(rs.getString(4));
                return e;
            }  
        });  
    }

}




