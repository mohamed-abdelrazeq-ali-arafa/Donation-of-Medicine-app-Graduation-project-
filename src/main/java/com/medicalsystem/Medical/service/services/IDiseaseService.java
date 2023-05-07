package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;

import java.util.List;

public interface IDiseaseService {

    public Response<Disease> addDisease(Disease disease);

    public Response<Disease> getDiseaseById(String id);

    public Response<List<Disease>> getAllDisease();

    public Response<Disease> deleteDiseaseById(String id);

    public Response<Disease> updateDisease(String id,Disease disease);

    public Response<Disease> findDiseaseByName(String Name);


}
