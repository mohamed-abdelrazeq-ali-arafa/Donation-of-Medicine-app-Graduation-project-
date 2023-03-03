package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Disease addDisease(@RequestBody  Disease disease){

        diseaseService.addDisease(disease);
        return disease;
    }

    @RequestMapping(value="/getdisease/{theid}",method = RequestMethod.GET)
    public Disease getDisease(@PathVariable String theid){

        return diseaseService.getDiseasById(theid);


    }


    @RequestMapping(value="/getalldisease",method = RequestMethod.GET)
    public List<Disease> getAllDisease(){
        return diseaseService.getAllDisease();
    }


    @RequestMapping(value="/deletedisease/{theid}",method = RequestMethod.DELETE)
    public String deleteDiseaseById(@PathVariable String theid){

      diseaseService.deleteDiseaseById(theid);
      return "Deleted employee is"+theid;

    }

    @RequestMapping(value= "/updatedisease/{theid}",method = RequestMethod.PUT)
    public Disease updateMedicine(@PathVariable String theid, @RequestBody Disease disease){
            diseaseService.updateDisease(theid,disease);
            return disease;

    }











}
