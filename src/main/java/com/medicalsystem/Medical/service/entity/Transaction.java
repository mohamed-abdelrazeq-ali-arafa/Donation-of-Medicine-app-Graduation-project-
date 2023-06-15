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

    // hold User id create the transaction
    private String userId;

    private Long createdAt;


    //medicine has been donated
    private String medicineId;

    public enum status {
        Pending, Delivered, Rejected, Completed, Cancelled, InProgress, Active, AttachedToDonationRequest
    }

    private status myStatusValue;
    private String receiverId;
    private String senderId;
    private boolean isDelivered;
    private boolean isReceived;
    private int quantity;
    private String donationRequestId;


}
