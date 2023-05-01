package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Implservices.DoctorRequestService;
import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.DoctorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctorrequest/")
public class DoctorRequestController extends BaseController{

    @Autowired
    DoctorRequestService doctorRequestService;
    public  DoctorRequestController(DoctorRequestService doctorRequestService){
        this.doctorRequestService=doctorRequestService;
    }
    @RequestMapping(value="/adddoctorrequest",method = RequestMethod.POST)
    public Response<DoctorRequest> addDoctoreRequest(@RequestBody DoctorRequest doctorRequest){
        Response<DoctorRequest> res=doctorRequestService.addDoctorRequest(doctorRequest);
        return res;
    }

//    @RequestMapping(value="/getdoctorerequest/{theid}",method = RequestMethod.GET)
//    public Response<DoctorRequest> getDoctoreRequest(@PathVariable String theid){
//        Response<DoctorRequest> res=doctorRequestService.getDoctorRequest(theid);
//        return res;
//    }

    @RequestMapping(value="/getalldoctorrequest",method = RequestMethod.GET)
    public Response<List<DoctorRequest>> getAllDoctoreRequests(){
        Response<List<DoctorRequest>> res=doctorRequestService.getAllDoctorRequests();
        return res;
    }


    @RequestMapping(value="/deletedoctorrequest/{theid}",method = RequestMethod.DELETE)
    public Response<DoctorRequest> deleteDoctoreRequestById(@PathVariable String theid){
        Response<DoctorRequest> res=doctorRequestService.deleteDoctorRequest(theid);
        return res;
    }

    @RequestMapping(value= "/updatedoctorrequest/{theid}",method = RequestMethod.PUT)
    public Response<DoctorRequest> updateMedicine(@PathVariable String theid, @RequestBody DoctorRequest doctorRequest){
        Response<DoctorRequest> res=doctorRequestService.updateDoctorRequest(theid,doctorRequest);
        return res;

    }


    @RequestMapping(value="/getdoctorerequest",method = RequestMethod.GET)
    public Response<DoctorRequest> getDoctoreRequest(){
        Response<DoctorRequest> res=doctorRequestService.getDoctorRequest();
        return res;
    }








}
