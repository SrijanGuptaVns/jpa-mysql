package com.test.trell.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "appPackageTest")
public class AppPackageTest {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id")*/
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String packages;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private List<UserAppPackage>  userAppPackages;

    public AppPackageTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public List<UserAppPackage> getUserAppPackages() {
        return userAppPackages;
    }

    public void setUserAppPackages(List<UserAppPackage> userAppPackages) {
        this.userAppPackages = userAppPackages;
    }
}
