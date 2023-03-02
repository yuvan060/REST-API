package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepo;

@Service
public class ApiService {
	@Autowired
	CarRepo repository;
	
	public boolean addCar(Car car){
		repository.save(car);
		return true;
	}
	
	public List<Car> getCarByOwners(int owners){
		return repository.findByOwners(owners);
	}
	
	public List<Car> getCarByCarName(String carName){
		return repository.findByCarName(carName);
	}
	
	public List<Car> getCarByAddress(String address){
		return repository.findByAddress(address);
	}
	
	public List<Car> getCarByOwnersAndCarType(int owners,String carType){
		return repository.findByOwnersAndCarType(owners, carType);
	}
}