package com.example1.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import com.example1.demo1.models.Orders;
// import com.example1.demo1.models.Customer;
// import com.example1.demo1.models.Store;
// import com.example1.demo1.models.Exhibit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class Ordersdao{

    @Autowired
    JdbcTemplate jt;


    public int addOrder(String Date, String Deliveryaddr ,String Status, String UserName){
        String sql = "insert into Orders (Date, Deliveryaddr,Status,UserName) values(?,?,?,?)";
        jt.update(sql, Date, Deliveryaddr, Status,UserName);

        String asql = "select OrderId from Orders where Date=? and Deliveryaddr=? and Status=? and UserName=?";
        return jt.queryForObject(asql, new Object[]{Date, Deliveryaddr, Status, UserName}, Integer.class);
    }

    public void addPrice(int Price,int OrderId){
        String sql = "update Orders set Price =? where OrderId = ?";
        jt.update(sql,Price,OrderId);
    }



    public void updateStatus(String Status, int OrderId){
        String sql = "update Orders set Status =? where OrderId = ?";
        jt.update(sql,Status,OrderId);
    }

 

    public void deleteOrder(int id){
        String sql = "delete from Orders where OrderId=?";
        jt.update(sql,id);
    }
    

    public List<Orders> getAllOrders(){  
        return jt.query("select OrderId,Date,Price,Deliveryaddr,Status from Orders",new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    } public List<Orders> getCustomerOrders(){  
        return jt.query("select * from Orders where UserName in (select UserName from User where UserType = 'customer')",new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    } 

    public List<Orders> getExhibitOrders(){  
        return jt.query("select * from Orders where UserName in (select UserName from User where UserType = 'exhibit')",new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    }
    public List<Orders> getOrdersByStatus(String Status){ 
        return jt.query("select * from Orders where Status ='" + Status + "'" ,new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    }


    public List<Orders> getOrdersByUser(String UserName){ 
        return jt.query("select * from Orders where UserName ='" + UserName + "'" ,new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    }

    public List<Orders> getOrdersByStatusUser(String Status,String UserName){ 
        return jt.query("select * from Orders where Status = '"+Status+"' and UserName ='"+UserName+"'" ,new RowMapper<Orders>(){  
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders e=new Orders();  
                e.setOrderId(rs.getInt(1));
                e.setDate(rs.getDate(2));  
                e.setPrice(rs.getInt(3));
                e.setDeliveryaddr(rs.getString(4));
                e.setStatus(rs.getString(5));
                return e;
            }  
        });
    } 



    // public List<Orders> getExhibitOrders(){  
    //     return jt.query("select a.OrderId,a.Price,a.Date,a.Deliveryaddr,a.Status, b.ExhibitId from Orders as a,ExhibitOrders as b  where a.OrderId=b.OrderId ",new RowMapper<Orders>(){  
    //         public Orders mapRow(ResultSet rs, int row) throws SQLException {
    //             Orders e=new Orders();
                
    //             e.setOrderId(rs.getInt(1));
    //             e.setPrice(rs.getInt(2));  
    //             e.setDate(rs.getDate(3));
    //             e.setDeliveryaddr(rs.getString(4));
    //             e.setStatus(rs.getString(5));
    //             e.setSid(rs.getInt(6));
    //             return e;
    //         }  
    //     });  
    // }
    
    

}




