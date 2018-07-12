package com.carscroll.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.carscroll.model.Images;
import com.carscroll.repository.CarRepository;

public class MongoService {
	@Autowired
	CarRepository repo;
	
	public MongoService(CarRepository repo)
	{
		this.repo = repo;
	}
	
	public List<Images> getCars()
	{			
		return repo.findAll();
	}

	public Images createCar(Images car) {
		repo.insert(car);
		return repo.findOne(car._id);
	}
	
	public void deleteCar(Images car)
	{
		repo.delete(car);
	}
	
	public Images updateCar(Images car)
	{
		Images existingCar = repo.findOne(car._id);
		BeanUtils.copyProperties(existingCar, car);
		return repo.save(existingCar);
	}
}
