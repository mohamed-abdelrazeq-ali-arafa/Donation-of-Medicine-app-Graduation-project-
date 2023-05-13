package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CollectionTable;
import java.util.Date;
import java.util.List;

@Data
@Document(collection ="diagnosesresult")
public class DiagnosesResult {

    @Id
    private String id;

    private List<String> symptoms;
    private List<String> medications;
    private String description;
    private String userId;




}
