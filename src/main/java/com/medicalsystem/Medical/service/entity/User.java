package com.medicalsystem.Medical.service.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection="users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String phone;
    private String userName;
    private String gender;
    private String Governorate;
    private String city;
    private String address;

    private enum type{
        DONATOR,
        USER;
    };
    private type enumType;

    private String diseaseId;



}
