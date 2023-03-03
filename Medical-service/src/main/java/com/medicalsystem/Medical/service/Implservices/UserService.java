package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addUser(User user) {
             userRepository.save(user);

    }

    @Override
    public void deleteUserById(String id) {
        User result = userRepository.findById(id).orElse(null);
        if(result==null)
            throw new RuntimeException("There is no Employee with id"+id);
        else
            userRepository.deleteById(result.getId());


    }

    @Override
    public User getUserById(String id) {

        User result = userRepository.findById(id).orElse(null);
        if(result==null)
            throw new RuntimeException("There is no Employee with id"+id);
        return result;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(String id, User user) {
        User tempUser=userRepository.findById(id).orElse(null);
        if(tempUser==null)
            throw new RuntimeException("There is no Transaction with this id");

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

    }


}
