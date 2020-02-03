package com.test.trell.resource;

import com.test.trell.model.UserAppPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAppRepo extends JpaRepository<UserAppPackage,Integer> {
    //public List<UserAppPackage> findByUser_id(int userId);

}
