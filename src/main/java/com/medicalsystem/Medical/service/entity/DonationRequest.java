package com.medicalsystem.Medical.service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "DonationRequest")
public class DonationRequest {
 @Id
 private String id;

 private int collected;
 private int needed;
 private int conteibuterCount;
 private String medicineId;
 private long endDate;



}
