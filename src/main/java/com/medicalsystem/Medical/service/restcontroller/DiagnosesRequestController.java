package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import com.medicalsystem.Medical.service.services.IDiagnosesRequestService;
import com.medicalsystem.Medical.service.services.IDiagnosesResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosesrequest")
public class DiagnosesRequestController {

    @Autowired
    IDiagnosesRequestService diagnosesRequestService;

    public DiagnosesRequestController(IDiagnosesRequestService diagnosesRequestService) {

        this.diagnosesRequestService=diagnosesRequestService;
    }
    @RequestMapping(value="/adddiagnosesrequest",method = RequestMethod.POST)
    public Response<DiagnosesRequest> addDiagnosesRequest(@RequestBody DiagnosesRequest diagnosesRequest){
        Response<DiagnosesRequest> res=diagnosesRequestService.addDiagnosesRequest(diagnosesRequest);
        return res;
    }

    @RequestMapping(value="/getdiagnosesrequest/{theid}",method = RequestMethod.GET)
    public Response<DiagnosesRequest> getDiagnosesRequest(@PathVariable String theid){
        Response<DiagnosesRequest> res=diagnosesRequestService.getDiagnosesRequestById(theid);
        return res;
    }


    @RequestMapping(value="/getalldiagnosesrequest",method = RequestMethod.GET)
    public Response<List<DiagnosesRequest>> getAllDiagnosesRequest(){
        Response<List<DiagnosesRequest>> res=diagnosesRequestService.getAllDiagnosesRequest();
        return res;
    }


    @RequestMapping(value="/deletediagnosesrequest/{theid}",method = RequestMethod.DELETE)
    public Response<DiagnosesRequest> deleteDiagnosesRequestById(@PathVariable String theid){
        Response<DiagnosesRequest> res=diagnosesRequestService.deleteDiagnosesRequestById(theid);
        return res;
    }

    @RequestMapping(value= "/updatediagnosesrequest/{theid}",method = RequestMethod.PUT)
    public Response<DiagnosesRequest> updateDiagnosesRequest(@PathVariable String theid, @RequestBody DiagnosesRequest diagnosesRequest){
        Response<DiagnosesRequest> res=diagnosesRequestService.updateDiagnosesRequest(theid,diagnosesRequest);
        return res;

    }



}
