package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract  class BaseController {

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    public boolean checkIfDoctorOrNot(User user ){
        String typeOfUser =user.getEnumType().toString();
        if(typeOfUser.equals("Doctor"))
            return true;
        return false;
    }
}
