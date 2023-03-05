package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository){

        this.userRepository=userRepository;
    }


    @Override
    public Response addUser(User user) {
        var res=new Response();
        userRepository.save(user);
        res.make("Success insert",201,user);
        return  res;

    }

    @Override
    public Response deleteUserById(String id) {
        var res = new Response();
        Optional<User> result = userRepository.findById(id);
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
    public Response getUserById(String id) {
        var res=new Response();
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
    public Response getAllUsers() {
        var res=new Response();
        List<User>users=userRepository.findAll();
        res.make("Success Retrive", 201, users);
        return res;
    }

    @Override
    public Response updateUser(String id, User user) {
        var res=new Response();
        User tempUser=userRepository.findById(id).orElse(null);
        if(tempUser==null)
            res.make("Failed to Update", 400, tempUser);
        else {
            tempUser.setPhone(user.getPhone());
            tempUser.setGovernorate(user.getGovernorate());
            tempUser.setEmail(user.getEmail());
            tempUser.setUserName(user.getUserName());
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
