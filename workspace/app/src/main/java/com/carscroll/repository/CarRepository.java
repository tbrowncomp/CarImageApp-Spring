package com.carscroll.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carscroll.model.Images;

public interface CarRepository extends MongoRepository<Images, String>{

}
