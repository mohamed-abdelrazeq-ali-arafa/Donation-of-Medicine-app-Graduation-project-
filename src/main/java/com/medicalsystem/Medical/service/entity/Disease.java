package com.medicalsystem.Medical.service.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection ="disease")
public class Disease {
    @Id
    private String id;

    private String Name;

    private String description;
    private String additionalInformartion;
    private List<String> symptomsList;
    private List<String> diagnosisList;
    private List<String> preventionList;
    private List<String> treatmentList;



}
