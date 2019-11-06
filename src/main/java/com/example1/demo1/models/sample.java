package com.example1.demo1.models;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class sample {

    @Id
    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public sample() {
    }

}