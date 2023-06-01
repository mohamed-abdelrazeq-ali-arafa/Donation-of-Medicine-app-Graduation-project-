package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "diagnosesresult")
public class DiagnosesResult {

    @Id
    private String id;

    private String diseaseId;

    private List<String> medicationId;


    private String DoctorId;
    private status state;
    private Long createdAt;
    private Long updatedAt;
    private String userId;
    private String diagnoses;
    private String diagnosisRequestId;

    enum status {

        PENDING,
        INPROGRESS,
        COMPLETE

    }
}
