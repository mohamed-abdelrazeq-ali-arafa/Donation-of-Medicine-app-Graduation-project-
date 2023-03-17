package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.Disease;
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
        var process = Runtime.getRuntime().exec("python /home/mohamed/PycharmProjects/MedicalServicePredictionModel/test.py " + SymptomsEncoded);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mohamed/PycharmProjects/MedicalServicePredictionModel/prediction.txt")));
        String line = reader.readLine();
        reader.close();

        //todo: get disease from database
        Disease disease = new Disease();
        disease.setName(line);
        return disease;
    }

}
