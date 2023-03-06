package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseRestController {

    IDiseaseService diseaseService;

    @Autowired

    public DiseaseRestController(IDiseaseService diseaseService) {

        this.diseaseService=diseaseService;
    }
    @RequestMapping(value="/adddisease",method = RequestMethod.POST)
    public Response<Disease> addDisease(@RequestBody  Disease disease){
        Response<Disease> res=diseaseService.addDisease(disease);
        return res;
    }

    @RequestMapping(value="/getdisease/{theid}",method = RequestMethod.GET)
    public Response<Disease> getDisease(@PathVariable String theid){
        Response<Disease> res=diseaseService.getDiseasById(theid);
        return res;
    }


    @RequestMapping(value="/getalldisease",method = RequestMethod.GET)
    public Response<List<Disease>> getAllDisease(){
        Response<List<Disease>> res=diseaseService.getAllDisease();
        return res;
    }


    @RequestMapping(value="/deletedisease/{theid}",method = RequestMethod.DELETE)
    public Response<Disease> deleteDiseaseById(@PathVariable String theid){
        Response<Disease> res=diseaseService.deleteDiseaseById(theid);
        return res;
    }

    @RequestMapping(value= "/updatedisease/{theid}",method = RequestMethod.PUT)
    public Response<Disease> updateMedicine(@PathVariable String theid, @RequestBody Disease disease){
        Response<Disease> res=diseaseService.updateDisease(theid,disease);
        return res;

    }




}
