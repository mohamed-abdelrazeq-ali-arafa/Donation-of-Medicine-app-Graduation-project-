package com.medicalsystem.Medical.service.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Document(collection ="transactions")
public class Transaction {

    @Id
    private String id;
    //should hold User idl
    private String createdBy;

    private Date createdAt;

    //changed
    private String medicineId;

    private enum status {
        PENDING,
        DONE,
        REJECTED
    }
    private status myStatusValue;


}
