package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface IDiseaseService {

    public void addDisease(Disease disease);

    public Disease getDiseasById(String id);

    public List<Disease> getAllDisease();

    public void deleteDiseaseById(String id);

    public void updateDisease(String id,Disease disease);




}
