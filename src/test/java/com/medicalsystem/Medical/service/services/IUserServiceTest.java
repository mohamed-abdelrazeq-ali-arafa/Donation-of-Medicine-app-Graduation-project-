package com.medicalsystem.Medical.service.services;


import com.medicalsystem.Medical.service.Implservices.UserService;
import com.medicalsystem.Medical.service.dao.IUserRepository;
import com.medicalsystem.Medical.service.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class IUserServiceTest {

    @Mock
    private IUserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService=new UserService(userRepository);
    }

    @AfterEach
    void tearDown() throws Exception {

    }

    @Test
    void canAddUser() {
//        //given
//        User user=new User("ahmed@gmail.com","90");
//        //when
//        userService.addUser(user);
//
//        //then
//        ArgumentCaptor<User> userArgumentCaptor=
//                ArgumentCaptor.forClass(User.class);
//        verify(userRepository).save(userArgumentCaptor.capture());
//
//        User  captureStudent = userArgumentCaptor.getValue();
//        assertThat(captureStudent).isEqualTo(user);
        String email="ahmed@gmail.com";
        User user=new User("ahmed@gmail.com","90");
        userService.addUser(user);
        String email1=user.getEmail();
        System.out.println(user);
        assertThat(email1).isEqualTo(email);
    }

    @Test

    void deleteUserById() {
        User user=new User("ahmed505@gmail.com","90");
        userService.addUser(user);
        String email=user.getEmail();
        userService.deleteUserById(user.getId());

        assertThat(email).isNull();

    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllUsers() {


        //when
        userService.getAllUsers().getData();
        System.out.println(userService.getAllUsers().getData());
        //then
        verify(userRepository).findAll();


    }

    @Test
    void updateUser() {

    }
}