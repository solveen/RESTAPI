package com.example.restapi.Service;


import com.example.restapi.StudentRepositories.UserRepositories;
import com.example.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    UserRepositories userRepositories;

    //save single user
    public User saveUser(User user){
        return userRepositories.save(user);
    }
    //saves multiple users it needs to be send in array
    public List<User> saveUsers(List<User> users){
        return userRepositories.saveAll(users);
    }

    //Return the users in the list
    public List<User> getUsers(){
        return userRepositories.findAll();
    }

    //Get user by id
    public User getUserById(int id){
        return userRepositories.findById(id).orElse(null);
    }

    //Delete user
    public String deleteById(int id){
        userRepositories.deleteById(id);
        return "User removed !! " + id;
    }

    //Update user
    public User updateUser(User user){
        User user1 = userRepositories.findById(user.getId()).orElse(null);
        user1.setUserName(user.getUserName());
        user1.setFullName(user.getFullName());
        user1.setPassword(user.getPassword());

    return userRepositories.save(user1);
    }

}
