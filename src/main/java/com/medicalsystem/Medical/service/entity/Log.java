package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection ="log")
public class Log {
    @Id
    private String id;
    private String title;
    private String discreption;

    //should hold User id
    private String createdBy;

    private Date createdAt;

}
