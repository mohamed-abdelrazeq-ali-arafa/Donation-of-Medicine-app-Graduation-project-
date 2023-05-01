package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DoctorRequest;
import com.medicalsystem.Medical.service.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public Response<User> addUser(User user);
    public Response<User> deleteUserById(String id);
    public Response<User> getUserById(String id);
    public Response<List<User>> getAllUsers();
    public Response<User> updateUser(String id,User user);



}
