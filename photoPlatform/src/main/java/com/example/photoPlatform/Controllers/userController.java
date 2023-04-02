package com.example.photoPlatform.Controllers;

import com.example.photoPlatform.DAO.model.User;
import com.example.photoPlatform.Services.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserInterface userInterface;



    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        System.out.println("user : "+user);; return userInterface.addUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userInterface.updateUser(user);
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userInterface.findAllUsers();
    }

    @GetMapping("/findId/{id}")
    public User findUserById(@PathVariable long id) {
        return userInterface.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable long id) {
        userInterface.deleteUserById(id);
    }

    @GetMapping("/findEmail/{email}")
    public  User findUserByEmail(@PathVariable String email){
        return  userInterface.findUserByEmail(email);
    }

    @PostMapping("/signin")
    public Boolean sigininMethod(@RequestBody User user) { return userInterface.signinMethod(user); }
}
