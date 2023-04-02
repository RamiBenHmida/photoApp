package com.example.photoPlatform.Services.Classes;

import com.example.photoPlatform.DAO.Repositories.UserRepository;
import com.example.photoPlatform.DAO.model.User;
import com.example.photoPlatform.Services.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService implements UserInterface {

    @Autowired
    UserRepository userRep;

    @Override
    public User addUser(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRep.save(user);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRep.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email){
        Optional<User> user = userRep.findByEmail(email);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public Boolean signinMethod(User user){
        Optional<User> userObject = userRep.findByEmail(user.getEmail());
        if(userObject.isPresent()){
            return true;
        }
        return false;
    }

}

