package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.Implservices.DiseaseService;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.services.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users/model")
public class ModelRestController {
    private final List<String> symptoms = new ArrayList<>();

    @Autowired
    DiseaseRestController diseaseRestController;

    public ModelRestController() {
        addSymptomsToList(symptoms);
    }

    @RequestMapping(value = "/symptoms", method = RequestMethod.GET)
    public List<String> sendSymptoms() {
        return symptoms;
    }

    private static void addSymptomsToList(List<String> symptoms) {
        symptoms.add("itching");
        symptoms.add("skin_rash");
        symptoms.add("chills");
        symptoms.add("joint_pain");
        symptoms.add("vomiting");
        symptoms.add("fatigue");
        symptoms.add("weight_loss");
        symptoms.add("lethargy");
        symptoms.add("cough");
        symptoms.add("high_fever");
        symptoms.add("breathlessness");
        symptoms.add("sweating");
        symptoms.add("headache");
        symptoms.add("yellowish_skin");
        symptoms.add("dark_urine");
        symptoms.add("nausea");
        symptoms.add("loss_of_appetite");
        symptoms.add("abdominal_pain");
        symptoms.add("diarrhoea");
        symptoms.add("mild_fever");
        symptoms.add("yellowing_of_eyes");
        symptoms.add("swelled_lymph_nodes");
        symptoms.add("malaise");
        symptoms.add("blurred_and_distorted_vision");
        symptoms.add("phlegm");
        symptoms.add("chest_pain");
        symptoms.add("dizziness");
        symptoms.add("excessive_hunger");
        symptoms.add("loss_of_balance");
        symptoms.add("irritability");
        symptoms.add("muscle_pain");
    }

    @RequestMapping(value = "/predict", method = RequestMethod.POST)
    public Disease getDisease(@RequestParam("symptoms") String SymptomsEncoded) throws IOException {
        var process = Runtime.getRuntime().exec("python C:\\Users\\mohamed\\Desktop\\MedicalServicePredictionModel\\test.py " + SymptomsEncoded);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\mohamed\\Desktop\\MedicalServicePredictionModel\\prediction.txt")));
        String diseaseName = reader.readLine();
        reader.close();

        //todo: search for disease name in disease table if found return it , run script passed
        Disease disease = new Disease();
        if(  diseaseRestController.getDiseaseByName(diseaseName).getData()==null)
            return null;
        else
            disease.setName(diseaseName);

        return diseaseRestController.getDiseaseByName(diseaseName).getData();




    }

}
