package com.example.restapi.StudentRepositories;

import com.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
    //for username searching the method name should be findByUserName for userName and findByUsername for username
    User findByUserName(String userName);
}
