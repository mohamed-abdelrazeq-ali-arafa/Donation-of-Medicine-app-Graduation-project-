package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import com.medicalsystem.Medical.service.entity.DiagnosesResult;

import java.util.List;

public interface IDiagnosesResultService {

    public Response<DiagnosesResult> addDiagnosesResult(DiagnosesResult DiagnosesResult);

    public Response<DiagnosesResult> getDiagnosesResultById(String id);

    public Response<List<DiagnosesResult>> getDiagnosesResultForUserId();

    public Response<List<DiagnosesResult>> getAllDiagnosesResult();

    public Response<DiagnosesResult> deleteDiagnosesResultRequestById(String id);

    public Response<DiagnosesResult> updateDiagnosesResult(String id,DiagnosesResult DiagnosesResult);



}
