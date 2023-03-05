package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Response addUser(User user);
    public Response deleteUserById(String id);
    public Response getUserById(String id);
    public Response getAllUsers();
    public Response updateUser(String id,User user);





}
