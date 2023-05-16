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
    IDiagnosesResultService diagnosesResultService;

    public DiagnosesResultRestController(IDiagnosesResultService diagnosesResultService) {

        this.diagnosesResultService=diagnosesResultService;
    }
    @RequestMapping(value="/adddiagnosesresult",method = RequestMethod.POST)
    public Response<DiagnosesResult> addDiagnosesResult(@RequestBody DiagnosesResult diagnosesresult){
        Response<DiagnosesResult> res=diagnosesResultService.addDiagnosesResult(diagnosesresult);
        return res;
    }

    @RequestMapping(value="/getddiagnosesresult/{theid}",method = RequestMethod.GET)
    public Response<DiagnosesResult> getDiagnosesResult(@PathVariable String theid){
        Response<DiagnosesResult> res=diagnosesResultService.getDiagnosesResultById(theid);
        return res;

    }


    @RequestMapping(value="/getalldiagnosesresult",method = RequestMethod.GET)
    public Response<List<DiagnosesResult>> getAllDiagnosesResult(){
        Response<List<DiagnosesResult>> res=diagnosesResultService.getAllDiagnosesResult();
        return res;
    }


    @RequestMapping(value="/deletediagnosesresult/{theid}",method = RequestMethod.DELETE)
    public Response<DiagnosesResult> deleteDiagnosesRsultById(@PathVariable String theid){
        Response<DiagnosesResult> res=diagnosesResultService.deleteDiagnosesResultRequestById(theid);
        return res;
    }

    @RequestMapping(value="/getdiagnosesresultforuserid",method = RequestMethod.GET)
    public Response<List<DiagnosesResult>> getDiagnosesResultForUserId(){
        Response<List<DiagnosesResult>> res=diagnosesResultService.getDiagnosesResultForUserId();
        return res;
    }

    @RequestMapping(value= "/updatediagnosesresult/{theid}",method = RequestMethod.PUT)
    public Response<DiagnosesResult> updateDiagnosesRequest(@PathVariable String theid, @RequestBody DiagnosesResult diagnosesResult){
        Response<DiagnosesResult> res=diagnosesResultService.updateDiagnosesResult(theid,diagnosesResult);
        return res;

    }

}
