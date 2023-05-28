package com.medicalsystem.Medical.service.Implservices;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDiagnosesRequestRepository;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
;
import com.medicalsystem.Medical.service.entity.User;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.IDiagnosesRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DiagnosesRequestService extends BaseController implements IDiagnosesRequestService {

    private IDiagnosesRequestRepository diagnosesRequestRepository;

    public DiagnosesRequestService (IDiagnosesRequestRepository diagnosesRequestRepository){

        this.diagnosesRequestRepository=diagnosesRequestRepository;

    }


    @Override
    public Response<DiagnosesRequest> addDiagnosesRequest(DiagnosesRequest diagnosesRequest) {
        diagnosesRequest.setUserId(getCurrentUser().getId());
        var res=new Response<DiagnosesRequest>();
        List<String> symptomslist=new ArrayList<String>();
        for(String i :symptomslist) {
            diagnosesRequest.setSymptoms(Collections.singletonList(i));
        }
        diagnosesRequestRepository.save(diagnosesRequest);
        res.make("Success Insert of DiagnosesRequest",201,diagnosesRequest);
        return res;
    }

    @Override
    public Response<DiagnosesRequest> getDiagnosesRequestById(String id) {
        var res = new Response();
        DiagnosesRequest tempDiagnosesRequest = diagnosesRequestRepository.findById(id).orElse(null);
        if (tempDiagnosesRequest == null)
            res.make("Failed Retrive of DiagnosesRequest with this id ", 400, null);
        else {
            res.make("Success Retrive of DiagnosesRequest", 201, tempDiagnosesRequest);

        }
        return res;
    }

    @Override
    public Response<List<DiagnosesRequest>> getDiagnosesRequestForUserId() {

        String id=getCurrentUser().getId();

        var res = new Response();

        boolean result =checkIfDoctorOrNot(getCurrentUser());

        if (result) {
            List<DiagnosesRequest> diagnosesRequests = diagnosesRequestRepository.findAll();
            res.make("Success Retrive of all  DiagnosesRequest", 200, diagnosesRequests);
        }
        else if (result==false)  {
            List<DiagnosesRequest> temp=  diagnosesRequestRepository.findByUserId(id);
            if(temp==null)
                res.make("Failed Retrive of DiagnosesRequest", 400, temp);
            else
                res.make("Success Retrive of DiagnosesRequest", 201, temp);
        }
        return res;
    }


    @Override
    public Response<List<DiagnosesRequest>> getAllDiagnosesRequest() {
        var res = new Response();
        List<DiagnosesRequest> diagnosesRequests = diagnosesRequestRepository.findAll();
        res.make("Sucess retrive of DiagnosesRequest", 200, diagnosesRequests);
        return res;
    }

    @Override
    public Response<DiagnosesRequest> deleteDiagnosesRequestById(String id) {
        var res = new Response();
        DiagnosesRequest tempdiagnosesRequest = diagnosesRequestRepository.findById(id).orElse(null);
        if (tempdiagnosesRequest == null)
            res.make("Failed Deletion of DiagnosesRequest with this id ", 400, null);
        else {
            res.make("Success Deleteion of DiagnosesRequest", 201, tempdiagnosesRequest);
            diagnosesRequestRepository.deleteById(id);
        }
        return res;
    }

    @Override
    public Response<DiagnosesRequest> updateDiagnosesRequest(String id, DiagnosesRequest diagnosesRequest) {
        var res = new Response();
        DiagnosesRequest tempDiagnosesRequest = diagnosesRequestRepository.findById(id).orElse(null);
        if (tempDiagnosesRequest == null)
            res.make("Failed There is No DiagnosesRequest with this id", 400, null);
        else {

            tempDiagnosesRequest.setDescription(diagnosesRequest.getDescription());
            tempDiagnosesRequest.setSymptoms(diagnosesRequest.getSymptoms());
            tempDiagnosesRequest.setDescription(diagnosesRequest.getDescription());
            tempDiagnosesRequest.setDate(diagnosesRequest.getDate());

            diagnosesRequestRepository.save(tempDiagnosesRequest);
            res.make("Sucess Update of DiagnosesRequest", 200, tempDiagnosesRequest);
        }

        return res;
    }
}
