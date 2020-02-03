package com.test.trell.model;

import javax.persistence.*;

@Entity
public class UserAppPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) int p_key;
    @Column(name = "UserId")
    private Integer user_id;
    private String packages;
    private Integer id;

    public UserAppPackage() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
