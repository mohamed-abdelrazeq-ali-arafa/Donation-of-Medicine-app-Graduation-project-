package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public void addUser(User user);
    public void deleteUserById(String id);
    public User getUserById(String id);
    public List<User> getAllUsers();
    public void updateUser(String id,User user);



}
