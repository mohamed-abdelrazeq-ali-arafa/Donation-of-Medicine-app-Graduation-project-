package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Medicine;
import com.medicalsystem.Medical.service.services.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public Response<Medicine> addMedicine(@RequestBody Medicine medicine) throws IOException, InterruptedException {
        Response<Medicine> res=medicineService.addMedicine(medicine);
        return res;
    }
    @RequestMapping(value="/deletemedicine/{theid}",method = RequestMethod.DELETE)
    public Response<Medicine> deleteMedicineById(@PathVariable String theid){
        Response<Medicine> res=medicineService.deleteMedicineById(theid);
        return res;
    }
    @RequestMapping(value="/getmedicine/{theid}",method = RequestMethod.GET)
    public Response<Medicine> getMedicineById(@PathVariable String theid){
        Response<Medicine> res=medicineService.getMedicineById(theid);
        return res;
    }

    @RequestMapping(value="/getallmedicine",method = RequestMethod.GET)
    public Response<List<Medicine>> getAllMedicine(){
        Response<List<Medicine>> res=medicineService.getAllMedicine();
        return res;
    }

    @RequestMapping(value= "/updatemedicine/{theid}",method = RequestMethod.PUT)
    public Response<Medicine> updateMedicine(@PathVariable String theid, @RequestBody Medicine medicine){
        Response<Medicine> res=medicineService.updateMedicine(theid,medicine);
        return res;

    }

}
