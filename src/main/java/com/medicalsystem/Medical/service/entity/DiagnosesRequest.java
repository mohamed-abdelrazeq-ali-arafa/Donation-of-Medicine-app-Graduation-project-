package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection ="diagnosesrequest")
public class DiagnosesRequest {

    //get for user id

    @Id
     private String id;


     private String userId;
     List<String> symptoms;
     String description;
     Long Date;
}
