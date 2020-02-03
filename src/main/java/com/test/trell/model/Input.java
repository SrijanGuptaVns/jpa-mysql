package com.test.trell.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Input {
    @Id
    private int userId;
    private String packages;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPackeges() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Input() {
    }

}
