package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseRestController {

    @Autowired
    IDiseaseService diseaseService;

    public DiseaseRestController(IDiseaseService diseaseService) {

        this.diseaseService=diseaseService;
    }
    @RequestMapping(value="/adddisease",method = RequestMethod.POST)
    public Response<Disease> addDisease(@RequestBody  Disease disease){
        Response<Disease> res=diseaseService.addDisease(disease);
        System.out.println(res.getData().getName());
        return res;
    }

    @RequestMapping(value="/getdisease/{theid}",method = RequestMethod.GET)
    public Response<Disease> getDisease(@PathVariable String theid){
        Response<Disease> res=diseaseService.getDiseaseById(theid);
        return res;
    }

    @RequestMapping(value="/getdiseasebyname",method = RequestMethod.GET)
    public Response<Disease> getDiseaseByName(@PathVariable String name){
        Response<Disease> res=diseaseService.findDiseaseByName(name);
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
