package com.medicalsystem.Medical.service.restcontroller;

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
    public Medicine addMedicine(@RequestBody Medicine medicine){
         medicineService.addMedicine(medicine);
         return medicine;
    }
    @RequestMapping(value="/deletemedicine/{theid}",method = RequestMethod.DELETE)
    public String deleteMedicineById(@PathVariable String theid){
       medicineService.deleteMedicineById(theid);
       return "Deleted Employee id is  "+ theid;
    }
    @RequestMapping(value="/getmedicine/{theid}",method = RequestMethod.GET)
    public Medicine getMedicineById(@PathVariable String theid){
       return medicineService.getMedicineById(theid);
    }
    @RequestMapping(value="/getallmedicine",method = RequestMethod.GET)
    public List<Medicine> getMedicine(){
        return medicineService.getAllMedicine();
    }



    @RequestMapping(value= "/updatemedicine/{theid}",method = RequestMethod.PUT)
    public Medicine updateMedicine(@PathVariable String theid, @RequestBody Medicine medicine){

            medicineService.updateMedicine(theid,medicine);
            return medicine;


    }

}
