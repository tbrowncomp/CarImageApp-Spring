package com.carscroll.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carscroll.model.Images;
import com.carscroll.repository.CarRepository;
import com.carscroll.service.MongoService;

@RestController
@RequestMapping("api/v1/")
public class HomeController {
	
	private MongoService dbService;
	
	public HomeController(CarRepository repo)
	{
		dbService = new MongoService(repo);
	}

	@RequestMapping("/")
	public String home()
	{
		return "Hey, Buddy!";
	}
		
	@RequestMapping(value="cars", method = RequestMethod.GET)
	public List<Images> listCars()
	{
		return dbService.getCars();
	}
	
	@RequestMapping(value="cars", method = RequestMethod.POST)
	public Images create(@RequestBody Images car)
	{
		return dbService.createCar(car);
	}
	
	@RequestMapping(value="cars", method = RequestMethod.PUT)
	public Images update(@RequestBody Images car)
	{
		return dbService.updateCar(car);
	}
	
	@RequestMapping(value="cars", method = RequestMethod.DELETE)
	public void delete(@RequestBody Images car)
	{
		dbService.deleteCar(car);
	}
}
