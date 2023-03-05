package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface IDiseaseService {

    public Response addDisease(Disease disease);

    public Response getDiseasById(String id);

    public Response getAllDisease();

    public Response deleteDiseaseById(String id);

    public Response updateDisease(String id,Disease disease);




}
