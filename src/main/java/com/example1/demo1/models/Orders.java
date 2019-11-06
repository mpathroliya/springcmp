package com.example1.demo1.models;

import java.util.Date;

public class Orders {

    private int OrderId;
    private Date Date;
    private int Price;
    private String Deliveryaddr;
    private String Status;

    private String UserName;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDeliveryaddr() {
        return Deliveryaddr;
    }

    public void setDeliveryaddr(String deliveryaddr) {
        Deliveryaddr = deliveryaddr;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    
}