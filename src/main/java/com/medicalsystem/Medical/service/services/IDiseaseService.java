package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface IDiseaseService {

    public Response<Disease> addDisease(Disease disease);

    public Response<Disease> getDiseasById(String id);

    public Response<Disease> getDiseasByName(String name);

    public Response<List<Disease>> getAllDisease();

    public Response<Disease> deleteDiseaseById(String id);

    public Response<Disease> updateDisease(String id,Disease disease);

    public Response<Disease> findDiseaseByName(String name);


}
