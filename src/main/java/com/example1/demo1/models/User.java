package com.example1.demo1.models;


public class User {

    private String UserName;
    private String Pwd;
    private String UserType;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public User() {
    }

    public User(String UserName, String Pwd, String UserType) {
        this.UserName =UserName;
        this.Pwd = UserName;
        this.UserType = UserType;
    }


}