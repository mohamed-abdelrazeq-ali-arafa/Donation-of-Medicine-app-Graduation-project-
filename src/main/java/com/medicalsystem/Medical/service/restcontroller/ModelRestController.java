package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/model")
public class ModelRestController {

    @RequestMapping(value="/sendsymptoms",method = RequestMethod.POST)
    public String sendSymtoms(String symptoms){

        return symptoms;
    }

    @RequestMapping(value="/getdisease",method = RequestMethod.GET)
    public Disease getDisease(){
        Disease disease=new Disease();
        return  disease;
    }

}
