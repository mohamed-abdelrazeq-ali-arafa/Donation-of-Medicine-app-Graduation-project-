package com.medicalsystem.Medical.service.dao;



import com.medicalsystem.Medical.service.entity.ImageData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IImageDataRepository extends MongoRepository<ImageData,String> {

    Optional<ImageData> findByName(String fileName);
}
