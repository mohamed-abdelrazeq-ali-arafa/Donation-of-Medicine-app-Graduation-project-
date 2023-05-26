package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.Implservices.UserService;
import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.restcontroller.UserRestController;
import com.medicalsystem.Medical.service.services.IUserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
class IUserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    @Mock
    private IUserService userService;




    @Test
    void findByEmailtestmethod() {
        String email="mohamed1011@gmail.com";
        User user =new User(email,"156");
        userRepository.save(user);
        System.out.println(user);
        assertThat(user.getEmail()).isEqualTo("mohamed1011@gmail.com");
    }

    @Test
    void deleteUsertestmethod() {

        User user =new User("mohamed2@gmail.com","15");
        userRepository.save(user);
        String id=user.getId();
        userRepository.deleteById(id);
        User user1 = userRepository.findById(id).orElse(null);
        assertThat(user1).isNull();
    }

    @AfterEach
    void deletealltest(){
        userRepository.deleteAll();
    }
}


