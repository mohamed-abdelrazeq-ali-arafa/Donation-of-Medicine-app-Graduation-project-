package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection ="stock")
public class Stock {
    @Id
    private String id;
    private String quantity;
    private String medicineId;
}
