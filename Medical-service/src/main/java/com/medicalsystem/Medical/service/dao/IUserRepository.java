package com.medicalsystem.Medical.service.dao;

import com.medicalsystem.Medical.service.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {

}
