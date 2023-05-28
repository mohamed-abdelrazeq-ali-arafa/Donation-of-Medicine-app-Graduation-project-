package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDiseaseRepository;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DiseaseService implements IDiseaseService {
    private IDiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseService(IDiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Response<Disease> addDisease(Disease disease) throws InterruptedException, IOException {
        var res = new Response();
        Disease temp = diseaseRepository.findByName(disease.getName());
        if (temp != null)
            res.make("There is disease with this Name", 400, temp);
        else {
            String workingDirectory = "/home/mohamed/PycharmProjects/medicineWebScrap";
            var process = new ProcessBuilder("python", "DiseaseScraper.py", disease.getName())
                    .directory(new File(workingDirectory))
                    .start();
            process.waitFor();
            temp = diseaseRepository.findByName(disease.getName());
            res.make("Success Insertion", 201, temp);
        }
        return res;
    }

    @Override
    public Response<Disease> getDiseaseById(String id) {
        var res = new Response();
        Disease tempDisease = diseaseRepository.findById(id).orElse(null);
        if (tempDisease == null)
            res.make("Failed Retrive of Disease with this id ", 400, null);
        else {
            res.make("Success Retrive of Disease", 201, tempDisease);

        }
        return res;
    }


    @Override
    public Response<List<Disease>> getAllDisease() {
        var res = new Response();
        List<Disease> diseases = diseaseRepository.findAll();
        res.make("Sucess retrive of disease", 200, diseases);
        return res;
    }

    @Override
    public Response<Disease> deleteDiseaseById(String id) {
        var res = new Response();
        Disease tempDisease = diseaseRepository.findById(id).orElse(null);
        if (tempDisease == null)
            res.make("Failed Deletion of disease with this id ", 400, null);
        else {
            res.make("Success Deleteion of disease", 201, tempDisease);
            diseaseRepository.deleteById(id);
        }
        return res;
    }

    @Override
    public Response<Disease> updateDisease(String id, Disease disease) {
        var res = new Response();
        Disease tempDisease = diseaseRepository.findById(id).orElse(null);
        if (tempDisease == null)
            res.make("Failed There is No Disease with this id", 400, null);
        else {
            tempDisease.setName(disease.getName());
            tempDisease.setDescription(disease.getDescription());
            tempDisease.setSymptomsList(disease.getSymptomsList());
            tempDisease.setAdditionalInformartion(disease.getAdditionalInformartion());
            tempDisease.setDiagnosisList(disease.getDiagnosisList());
            tempDisease.setPreventionList(disease.getPreventionList());
            tempDisease.setTreatmentList(disease.getTreatmentList());
            diseaseRepository.save(tempDisease);
            res.make("Sucess Update of Disease", 200, tempDisease);
        }

        return res;
    }

    @Override
    public Response<Disease> findDiseaseByName(String Name) {
        var res = new Response();
        Disease disease = diseaseRepository.findByName(Name);
        System.out.println(disease);
        if (disease == null)
            res.make("Failed There is No Disease with this name", 400, null);
        else {
            res.make("Sucess find of of Disease", 200, disease);
        }
        return res;
    }

}
