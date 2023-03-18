package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
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
    public UserService(IUserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public Response<User> add(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return Response.success(user);
    }

    @Override
    public Response<User> delete(String id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null)
            return Response.failed("User not found");
        userRepository.deleteById(id);
        return Response.success(result);
    }

    @Override
    public Response<User> getById(String id) {
        User result = userRepository.findById(id).orElse(null);
        if (result == null)
            return Response.failed("User not found");
        return Response.success(result);
    }

    @Override
    public Response<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return Response.success(users);
    }

    @Override
    public Response<User> updateUser(User user) {
        User savedUser = userRepository.findById(user.getId()).orElse(null);
        if (savedUser == null)
            return Response.failed("User not found");
        userRepository.save(user);
        return Response.success(user);
    }


}
