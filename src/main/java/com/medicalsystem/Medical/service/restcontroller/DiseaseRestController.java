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
    public ResponseEntity addDisease(@RequestBody  Disease disease){
        Response res=diseaseService.addDisease(disease);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }

    @RequestMapping(value="/getdisease/{theid}",method = RequestMethod.GET)
    public ResponseEntity getDisease(@PathVariable String theid){

        Response res=diseaseService.getDiseasById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }


    @RequestMapping(value="/getalldisease",method = RequestMethod.GET)
    public ResponseEntity getAllDisease(){
        Response res=diseaseService.getAllDisease();
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }


    @RequestMapping(value="/deletedisease/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteDiseaseById(@PathVariable String theid){

        Response res=diseaseService.deleteDiseaseById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }

    @RequestMapping(value= "/updatedisease/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updateMedicine(@PathVariable String theid, @RequestBody Disease disease){
        Response res=diseaseService.updateDisease(theid,disease);
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }




}
