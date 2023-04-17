package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.entity.ImageData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IimageDataService {
    String uploadImage(MultipartFile file ) throws IOException;
    byte[] downloadImage(String fileName);
}
