package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection ="medicine")
public class Medicine {

    @Id
    private String id;
    private String name;
    private List<String> uses;
    private List<String> sideEffects;
    private List<String> precautions;
    private List<String> overDos;
    private String additionalInformation;
    private List<String> diseasesID;


}
