package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import com.medicalsystem.Medical.service.entity.DiagnosesResult;
import com.medicalsystem.Medical.service.services.IDiagnosesResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/diagnosesresult")
public class DiagnosesResultRestController {
    @Autowired
    IDiagnosesResultService diagnosesRequestService;

    public DiagnosesResultRestController(IDiagnosesResultService diagnosesRequestService) {

        this.diagnosesRequestService=diagnosesRequestService;
    }
    @RequestMapping(value="/adddiagnosesresult",method = RequestMethod.POST)
    public Response<DiagnosesResult> addDiagnosesRequest(@RequestBody DiagnosesResult diagnosesresult){
        Response<DiagnosesResult> res=diagnosesRequestService.addDiagnosesResult(diagnosesresult);
        return res;
    }

    @RequestMapping(value="/getddiagnosesresult/{theid}",method = RequestMethod.GET)
    public Response<DiagnosesResult> getDiagnosesRequest(@PathVariable String theid){
        Response<DiagnosesResult> res=diagnosesRequestService.getDiagnosesResultById(theid);
        return res;

    }


    @RequestMapping(value="/getalldiagnosesresult",method = RequestMethod.GET)
    public Response<List<DiagnosesResult>> getAllDiagnosesRequest(){
        Response<List<DiagnosesResult>> res=diagnosesRequestService.getAllDiagnosesResult();
        return res;
    }


    @RequestMapping(value="/deletediagnosesresult/{theid}",method = RequestMethod.DELETE)
    public Response<DiagnosesResult> deleteDiagnosesRequestById(@PathVariable String theid){
        Response<DiagnosesResult> res=diagnosesRequestService.deleteDiagnosesResultRequestById(theid);
        return res;
    }

    @RequestMapping(value= "/updatediagnosesresult/{theid}",method = RequestMethod.PUT)
    public Response<DiagnosesResult> updateDiagnosesRequest(@PathVariable String theid, @RequestBody DiagnosesResult diagnosesResult){
        Response<DiagnosesResult> res=diagnosesRequestService.updateDiagnosesResult(theid,diagnosesResult);
        return res;

    }

}
