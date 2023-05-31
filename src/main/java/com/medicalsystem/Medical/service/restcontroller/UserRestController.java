package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/users")

public class UserRestController {

    private IUserService userService;

    @Autowired
    public UserRestController(IUserService userService){
        this.userService=userService;
    }



    @Operation(summary = "Creates a new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created book"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})

    // to access doc http://localhost:3000/swagger-ui/index.html
    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    public Response<User> addUser(@RequestBody User user){
        Response<User> response=userService.addUser(user);
        return response;

    }


    @RequestMapping(value="/deleteuser/{theid}",method = RequestMethod.DELETE)
    public Response<User> deleteUser(@PathVariable String theid){
        Response<User> response=userService.deleteUserById(theid);
        return response;
    }

    @RequestMapping(value="/getuser/{theid}",method = RequestMethod.GET)
    public Response<User> getUser(@PathVariable String theid){

        Response<User> res=userService.getUserById(theid);
        return res;

    }



    @RequestMapping(value="/getalluser",method = RequestMethod.GET)
    public Response<List<User>> getAllUser(){

        Response<List<User>> res=userService.getAllUsers();
        return res;

    }

    @RequestMapping(value="/updateuser/{theid}",method = RequestMethod.PUT)
    public Response<User> updateUser(@PathVariable String theid, @RequestBody User user){
        Response<User> res=userService.updateUser(theid,user);
        return res;
    }


}
