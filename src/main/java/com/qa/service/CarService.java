package com.qa.service;

import com.qa.domain.Car;
import com.qa.exceptions.CarNotFoundException;
import com.qa.repo.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    private final CarsRepository repo;

    @Autowired
    public CarService(CarsRepository repo) {
        this.repo = repo;
    }

    public List<Car> readCars() {
        return this.repo.findAll();
    }

    public Car createCar(Car car) {
        return this.repo.save(car);
    }

    public Car findCarById(Long id) {
        return this.repo.findById(id).orElseThrow(CarNotFoundException::new);
    }

    public Car updateCar(Long id, Car car) {
        Car update = findCarById(id);
        update.setModel(car.getModel());
        update.setPrice(car.getPrice());
        return this.repo.save(update);
    }

    public boolean deleteCar(Long id) {
        if(!this.repo.existsById(id)) {
            throw new CarNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }



}
