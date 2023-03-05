package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/medicine")
public class MedicineRestController {

    private IMedicineService medicineService;
    @Autowired
    public MedicineRestController(IMedicineService  medicineService){

        this.medicineService=medicineService;

    }

    @RequestMapping(value="/addmedicine",method = RequestMethod.POST)
    public ResponseEntity addMedicine(@RequestBody Medicine medicine){
        Response res=medicineService.addMedicine(medicine);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(value="/deletemedicine/{theid}",method = RequestMethod.DELETE)
    public ResponseEntity deleteMedicineById(@PathVariable String theid){
        Response res=medicineService.deleteMedicineById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(value="/getmedicine/{theid}",method = RequestMethod.GET)
    public ResponseEntity getMedicineById(@PathVariable String theid){
        Response res=medicineService.getMedicineById(theid);
        return ResponseEntity.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(value="/getallmedicine",method = RequestMethod.GET)
    public ResponseEntity getAllMedicine(){
        Response res=medicineService.getAllMedicine();
        return ResponseEntity.status(res.getCode()).body(res.toData());

    }



    @RequestMapping(value= "/updatemedicine/{theid}",method = RequestMethod.PUT)
    public ResponseEntity updateMedicine(@PathVariable String theid, @RequestBody Medicine medicine){


        Response res=medicineService.updateMedicine(theid,medicine);
        return ResponseEntity.status(res.getCode()).body(res.toData());


    }

}
