package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDiagnosesResultRepository;
import com.medicalsystem.Medical.service.entity.DiagnosesResult;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.IDiagnosesResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DiagnosesResultService extends BaseController implements IDiagnosesResultService {


    private IDiagnosesResultRepository diagnosesResultRepository;
    @Autowired
    public DiagnosesResultService(IDiagnosesResultRepository diagnosesResultRepository){

        this.diagnosesResultRepository=diagnosesResultRepository;

    }




    @Override
    public Response<DiagnosesResult> addDiagnosesResult(DiagnosesResult diagnosesResult) {
        diagnosesResult.setUserId(getCurrentUser().getId());
        var res=new Response<DiagnosesResult>();
        List<String> symptomslist=new ArrayList<String>();
        for(String i :symptomslist) {
            diagnosesResult.setSymptoms(Collections.singletonList(i));
        }
        diagnosesResultRepository.save(diagnosesResult);
        res.make("Success Insert of DiagnosesResult",201,diagnosesResult);
        return res;
    }

    @Override
    public Response<DiagnosesResult> getDiagnosesResultById(String id) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResult = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResult == null)
            res.make("Failed Retrive of DiagnosesResult with this id ", 400, null);
        else {
            res.make("Success Retrive of DiagnosesResult", 201, tempDiagnosesResult);

        }
        return res;
    }

    @Override
    public Response<List<DiagnosesResult>> getAllDiagnosesResult() {
        var res = new Response();
        List<DiagnosesResult> diagnosesResults = diagnosesResultRepository.findAll();
        res.make("Sucess retrive of DiagnosesResult", 200, diagnosesResults);
        return res;
    }

    @Override
    public Response<DiagnosesResult> deleteDiagnosesResultRequestById(String id) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResults = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResults == null)
            res.make("Failed Deletion of DiagnosesResult with this id ", 400, null);
        else {
            res.make("Success Deleteion of DiagnosesResult", 201, tempDiagnosesResults);
            diagnosesResultRepository.deleteById(id);
        }
        return res;
    }

    @Override
    public Response<DiagnosesResult> updateDiagnosesResult(String id, DiagnosesResult diagnosesResult) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResults = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResults == null)
            res.make("Failed There is No DiagnosesResult with this id", 400, null);
        else {

            tempDiagnosesResults.setDescription(diagnosesResult.getDescription());
            tempDiagnosesResults.setSymptoms(diagnosesResult.getSymptoms());
            tempDiagnosesResults.setUserId(diagnosesResult.getUserId());
            tempDiagnosesResults.setMedications(diagnosesResult.getMedications());


            diagnosesResultRepository.save(tempDiagnosesResults);
            res.make("Sucess Update of DiagnosesResult", 200, tempDiagnosesResults);
        }

        return res;
    }

}
