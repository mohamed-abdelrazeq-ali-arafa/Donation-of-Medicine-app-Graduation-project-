package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;

import java.util.List;

public interface IDiagnosesRequestService {


    public Response<DiagnosesRequest> addDiagnosesRequest(DiagnosesRequest diagnosesRequest);

    public Response<DiagnosesRequest> getDiagnosesRequestById(String id);

    public Response<List<DiagnosesRequest>> getDiagnosesRequestForUserId();

    public Response<List<DiagnosesRequest>> getAllDiagnosesRequest();

    public Response<DiagnosesRequest> deleteDiagnosesRequestById(String id);


    public Response<DiagnosesRequest> updateDiagnosesRequest(String id,DiagnosesRequest diagnosesRequest);





}
