package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDoctorRequestRepository;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.DoctorRequest;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.IDoctorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorRequestService extends BaseController implements IDoctorRequestService  {

    private IDoctorRequestRepository doctorRequestRepository;

    @Autowired
    DoctorRequestService(IDoctorRequestRepository doctorRequest){
        this.doctorRequestRepository=doctorRequest;
    }


    @Override
    public Response<DoctorRequest> addDoctorRequest(DoctorRequest doctorRequest) {
        var res = new Response();
        doctorRequest.setUserId(getCurrentUser().getId());
        doctorRequestRepository.save(doctorRequest);
        res.make("Success Insert of Doctor Request", 201, doctorRequest);
        return res;
    }

    @Override
    public Response<DoctorRequest> deleteDoctorRequest(String id) {
        var res = new Response();
        DoctorRequest tempDoctorRequest = doctorRequestRepository.findById(id).orElse(null);
        if (tempDoctorRequest == null)
            res.make("Failed delete of Doctor Request  with this id ", 400, null);
        else {
            doctorRequestRepository.deleteById(id);
            res.make("Success Retrive of Disease", 201, tempDoctorRequest);
        }
        return res;
    }

    @Override
    public Response<DoctorRequest> updateDoctorRequest(String id,DoctorRequest doctorRequest) {
        var res = new Response();
        DoctorRequest tempDoctorRequest = doctorRequestRepository.findById(id).orElse(null);
        if (tempDoctorRequest == null)
            res.make("Failed There is No DoctorRequest with this id", 400, null);
        else {
            tempDoctorRequest.setUserId(doctorRequest.getUserId());
            tempDoctorRequest.setState(doctorRequest.getState());
            tempDoctorRequest.setMessage(doctorRequest.getMessage());
            doctorRequestRepository.save(tempDoctorRequest);
            res.make("Sucess Update of doctor Request", 200, tempDoctorRequest);
        }
        return res;
    }

    @Override
    public Response<DoctorRequest> getDoctorRequest(String id) {
        var res = new Response();
        DoctorRequest tempDoctorRequest = doctorRequestRepository.findById(id).orElse(null);
        if (tempDoctorRequest == null)
            res.make("Failed Retrive of Doctor Request  with this id ", 400, null);
        else {
            res.make("Success Retrive of Doctor Request", 201, tempDoctorRequest);

        }
        return res;
    }

    @Override
    public Response<List<DoctorRequest>> getAllDoctorRequests() {
        var res = new Response();
        List<DoctorRequest> tempDoctorRequest = doctorRequestRepository.findAll();
        if (tempDoctorRequest == null)
            res.make("Failed Retrive of Doctor Request  with this id ", 400, null);
        else {
            res.make("Success Retrive of Doctor Request", 201, tempDoctorRequest);

        }
        return res;
    }


}
