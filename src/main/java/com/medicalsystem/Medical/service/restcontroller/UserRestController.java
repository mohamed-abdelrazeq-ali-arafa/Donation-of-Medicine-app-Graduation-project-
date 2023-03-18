package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

//@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private IUserService userService;

    @Autowired
    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response<User> addUser(@RequestBody User user) {
        return userService.add(user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response<User> deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response<User> getUser(@PathVariable String id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Response<List<User>> getAllUser() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Response<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
