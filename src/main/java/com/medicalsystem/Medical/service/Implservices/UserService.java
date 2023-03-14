package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {
    private IUserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
         //User user = userRepository.findById("6410735b8691ea7afb964165").orElse(null);
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
        String diseaseId="6401323b248e01620a3fb779";
        user.setDiseaseId(diseaseId);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        var res=new Response<User>();
        userRepository.save(user);
        res.sucess(user);
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
            tempUser.setGovernorate(user.getGovernorate());
            tempUser.setEmail(user.getEmail());
            //tempUser.setUsername(user.getUsername());
            tempUser.setCity(user.getCity());
            tempUser.setDiseaseId(user.getDiseaseId());
            tempUser.setPassword(user.getPassword());
            tempUser.setGender(user.getGender());
            tempUser.setEnumType(user.getEnumType());
            tempUser.setAddress(user.getAddress());
            userRepository.save(tempUser);
            res.make("Success Update", 201, tempUser);
        }


        return res;
    }


}
