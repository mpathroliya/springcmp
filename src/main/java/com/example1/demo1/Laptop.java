package com.example1.demo1;

import org.springframework.stereotype.Component;

@Component
public class Laptop{

    public int lid;

    private int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Laptop() {
        System.out.println("\nLaptop Created\n");
    }

    public void compile(){
        System.out.println("\nlaptop frereated\n");
    }
    


}