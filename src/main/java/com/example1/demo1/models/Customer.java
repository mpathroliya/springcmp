package com.example1.demo1.models;


public class Customer {

    private int CustomerId;
    private String Name;
    private int phone;
    private String address;
    private String UserName;



    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String username) {
        UserName = username;
    }

}