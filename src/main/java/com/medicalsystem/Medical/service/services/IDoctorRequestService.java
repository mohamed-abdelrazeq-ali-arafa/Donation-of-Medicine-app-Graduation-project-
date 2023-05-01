package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DoctorRequest;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;


public interface IDoctorRequestService {

    Response<DoctorRequest> addDoctorRequest(DoctorRequest doctorRequest);
    Response<DoctorRequest> deleteDoctorRequest(String id);
    Response<DoctorRequest> updateDoctorRequest(String id,DoctorRequest doctorRequest);
    Response<DoctorRequest> getDoctorRequest(String id);
    Response<List<DoctorRequest>> getAllDoctorRequests();


}
