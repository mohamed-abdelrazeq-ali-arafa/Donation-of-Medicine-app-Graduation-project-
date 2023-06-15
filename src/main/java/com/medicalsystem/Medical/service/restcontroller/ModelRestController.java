package com.medicalsystem.Medical.service.restcontroller;

import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.services.IDiseaseService;
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
    private IDiseaseService diseaseService;

    public ModelRestController(IDiseaseService diseaseService) {
        this.diseaseService = diseaseService;

    }



    @RequestMapping(value = "/predict", method = RequestMethod.POST)
    public Disease getDisease(@RequestParam("symptoms") String symptomsEncoded) throws IOException, InterruptedException {
        String workingDirectory = "C:\\Users\\mohamed\\Desktop\\MedicalServicePredictionModel";
        var process = new ProcessBuilder("python", "test.py", symptomsEncoded)
                .directory(new File(workingDirectory))
                .start();
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(workingDirectory + "/prediction.txt")));
        String diseaseName = reader.readLine();
        reader.close();

        System.out.println(diseaseName);
        var diseaseResponse = diseaseService.findDiseaseByName(diseaseName);
        if (diseaseResponse.isSuccess())
            return diseaseResponse.getData();
        else {
            process = new ProcessBuilder("python", "DiseaseManagerBSoup.py", diseaseName)
                    .directory(new File("/home/mohamed/PycharmProjects/medicineWebScrap/"))
                    .start();
            process.waitFor();
        }
        diseaseResponse = diseaseService.findDiseaseByName(diseaseName);
        if (diseaseResponse.isSuccess())
            return diseaseResponse.getData();
        return new Disease();
    }

}
