package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;

import java.util.List;

public interface IUserService {

    public Response<User> add(User user);
    public Response<User> delete(String id);
    public Response<User> getById(String id);
    public Response<List<User>> getAllUsers();
    public Response<User> updateUser(User user);







}
