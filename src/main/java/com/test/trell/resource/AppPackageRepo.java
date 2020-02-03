package com.test.trell.resource;

import com.test.trell.model.AppPackageTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppPackageRepo extends JpaRepository<AppPackageTest,Integer> {
    public AppPackageTest findByPackages(String name);
    public void deleteByPackages(String name);

}
