package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.DoctorRequest;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.IDoctorRequestService;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseController implements IUserService, UserDetailsService {

    private IUserRepository userRepository;




    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            System.out.println("failed to find this email");
        }
        return user;
    }

    @Autowired
    public UserService(IUserRepository userRepository){

        this.userRepository=userRepository;
    }

    @Override
    public Response<User> addUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        var res=new Response<User>();
        User temp=userRepository.findByEmail(user.getEmail());
        if(temp!=null)
            res.make("There is Email with this Name",400,temp);
        else {
            userRepository.save(user);
            res.make("Success Insertion", 201, user);
        }
        return  res;

    }

    @Override
    public Response<User> deleteUserById(String id) {
        var res = new Response<User>();
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            res.make("Failed to delete", 400, result);
        }
        else {
            userRepository.deleteById(id);
            res.make("Success Deletion", 201, result);
        }
        return res;
    }

    @Override
    public Response<User> getUserById(String id) {
        var res=new Response<User>();
        User result = userRepository.findById(id).orElse(null);
        if(result==null)
        {
            res.make("Failed to retrive", 400, result);
        }
        else {
            res.make("Success Retrive", 201, result);
        }
        return res;

    }

    @Override
    public Response<List<User>> getAllUsers() {
        var res=new Response<List<User>>();
        List<User>users=userRepository.findAll();
        res.make("Success Retrive", 201, users);
        return res;
    }

    @Override
    public Response<User> updateUser(String id, User user) {
        var res=new Response<User>();
        User tempUser=userRepository.findById(id).orElse(null);
        if(tempUser==null)
            res.make("Failed to Update", 400, tempUser);
        else {
            tempUser.setPhone(user.getPhone());
            tempUser.setEmail(user.getEmail());
            //tempUser.setUsername(user.getUsername());
            tempUser.setDiseaseId(user.getDiseaseId());
            tempUser.setPassword(user.getPassword());
            tempUser.setEnumType(user.getEnumType());
            userRepository.save(tempUser);
            res.make("Success Update", 201, tempUser);
        }


        return res;
    }




}
