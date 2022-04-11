package com.example.restapi.StudentRepositories;

import com.example.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Integer> {

}
