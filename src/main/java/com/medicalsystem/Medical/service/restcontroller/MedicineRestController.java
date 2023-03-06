package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Response<Medicine> addMedicine(@RequestBody Medicine medicine){
        Response res=medicineService.addMedicine(medicine);
        return Respons<Medicine>.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(vealue="/deletemedicine/{theid}",method = RequestMethod.DELETE)
    public Response<Medicine> deleteMedicineById(@PathVariable String theid){
        Response res=medicineService.deleteMedicineById(theid);
        return Respons<Medicine>.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(vealue="/getmedicine/{theid}",method = RequestMethod.GET)
    public Response<Medicine> getMedicineById(@PathVariable String theid){
        Response res=medicineService.getMedicineById(theid);
        return Respons<Medicine>.status(res.getCode()).body(res.toData());
    }
    @RequestMapping(vealue="/getallmedicine",method = RequestMethod.GET)
    public Response<Medicine> getAllMedicine(){
        Response res=medicineService.getAllMedicine();
        return Respons<Medicine>.status(res.getCode()).body(res.toData());

    }



    @RequestMapping(vealue= "/updatemedicine/{theid}",method = RequestMethod.PUT)
    public Respons<Medicine> updateMedicine(@PathVariable String theid, @RequestBody Medicine medicine){


 e       Response res=medicineService.updateMedicine(theid,medicine);
        return Respons<Medicine>.status(res.getCode()).body(res.toData());


    }

}
