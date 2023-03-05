package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private IUserService userService;

    @Autowired
    public UserRestController(IUserService userService){
        this.userService=userService;
    }

    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user){
        Response response=userService.addUser(user);
        return ResponseEntity.status(response.getCode()).body(response.toData());

    }


    @RequestMapping(value="/deleteuser/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable String theid){
          var res=userService.deleteUserById(theid);
          return ResponseEntity.status(res.getCode()).body(res.toData());
    }

    @RequestMapping(value="/getuser/{theid}",method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable String theid){

        var res=userService.getUserById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }

    @RequestMapping(value="/getalluser",method = RequestMethod.GET)
    public ResponseEntity getAllUser(){

        var res=userService.getAllUsers();
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }

    @RequestMapping(value="/updateuser/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable String theid, @RequestBody User user){
        var res=userService.updateUser(theid,user);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }


}
