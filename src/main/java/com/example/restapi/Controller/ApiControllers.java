package com.example.restapi.Controller;

import com.example.restapi.Service.UserService;
import com.example.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class ApiControllers {
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder encoder;


    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    @PostMapping("/saveAll")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

//    @GetMapping("/getUser")
//    public User getUserById(int id){
//        return userRepositories.findById(id).orElse(null);
//    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return "User removed !! " + id;
    }

    @PutMapping("/UpdateUsers")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/searchUser/{userName}")
    public User customRepository(@PathVariable String userName) {
        return userService.findByUserName(userName);
    }
}
