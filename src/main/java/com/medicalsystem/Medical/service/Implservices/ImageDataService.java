package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.ImageUtils;
import com.medicalsystem.Medical.service.dao.IImageDataRepository;
import com.medicalsystem.Medical.service.entity.ImageData;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ImageDataService  extends BaseController implements com.medicalsystem.Medical.service.services.IimageDataService {

    @Autowired
    private IImageDataRepository iimageDataRepository;

    public ImageDataService(IImageDataRepository iimageDataRepository) {
        this.iimageDataRepository = iimageDataRepository;
    }

        @Override
        public String uploadImage(MultipartFile file) throws IOException {
            ImageData imageData = new ImageData();
             imageData = iimageDataRepository.save(ImageData.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                     .createdBy(getCurrentUser().getId())
                    .imageData(ImageUtils.compressImage(file.getBytes())).build());
            if (imageData != null) {
                return "file uploaded successfully : " + file.getOriginalFilename();
            }
            return null;
        }



    @Override
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = iimageDataRepository.findById(fileName);
        //Optional<ImageData> dbImageData = iimageDataRepository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
