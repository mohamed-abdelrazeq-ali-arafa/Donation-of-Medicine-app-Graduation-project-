package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="DoctorRequest")
public class DoctorRequest {
    @Id
    private String id;
    private String userId;

    private enum status {
        ACCEPTED,
        DECLINE,
        Message
    }
    private status state;
    private String message;

}
