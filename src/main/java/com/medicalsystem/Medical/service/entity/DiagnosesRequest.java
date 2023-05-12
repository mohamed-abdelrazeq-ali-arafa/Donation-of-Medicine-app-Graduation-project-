package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="diagnosesrequest")
public class DiagnosesRequest {

    @Id
   private String id;


    private String DoctorId;
    private status state;
    private Long createdAt;
    private Long updatedAt;
    private String userId;
    private String diagnoses;
    enum status {

        PENDNIG,
        INPROGRESS,
        COMPLETE

    }
}
