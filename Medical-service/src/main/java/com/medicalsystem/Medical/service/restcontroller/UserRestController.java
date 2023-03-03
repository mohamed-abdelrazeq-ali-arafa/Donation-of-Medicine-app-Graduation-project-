package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;

    }

    @RequestMapping(value="/deleteuser/{theid}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String theid){
        User tempUser=userService.getUserById(theid);
        if(tempUser==null) {
            throw new RuntimeException("Employee id is not defind");
        }
        else {
            userService.deleteUserById(tempUser.getId());

        }
        return "Deleted Employee id is  "+ theid;
    }

    @RequestMapping(value="/getuser/{theid}",method = RequestMethod.GET)
    public User getUser(@PathVariable String theid){

        User tempUser=userService.getUserById(theid);
        if(tempUser==null) {
            throw new RuntimeException("Employee id is not defind");
        }
        else
            //return userService.getUserById(tempUser.getId());
        return tempUser;

    }

    @RequestMapping(value="/getalluser",method = RequestMethod.GET)
    public List<User> getAllUser(){

         return userService.getAllUsers();

    }

    @RequestMapping(value="/updateuser/{theid}",method = RequestMethod.PUT)
    public void updateUser(@PathVariable String theid,@RequestBody User user){
        userService.updateUser(theid,user);

    }


}
