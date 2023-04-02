package com.example.photoPlatform.Services.Interfaces;

import com.example.photoPlatform.DAO.model.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    public User addUser(User user);

    public List<User> findAllUsers();

    public User updateUser(User user);

    public User findUserById(Long id);

    public void deleteUserById(Long id);

    public User findUserByEmail(String email);

    Boolean signinMethod(User user);
}
