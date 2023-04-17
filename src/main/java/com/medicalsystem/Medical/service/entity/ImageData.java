package com.medicalsystem.Medical.service.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Lob;

@Data
@Document(collection ="image")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ImageData {
    @Id
    private String id;

    private String name;
    private String type;
    @Lob
    private byte[] imageData;

    private String createdBy;

}
