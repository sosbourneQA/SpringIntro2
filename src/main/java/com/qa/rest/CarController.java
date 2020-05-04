package com.qa.rest;

import com.qa.domain.Car;
import com.qa.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/getAllCars")
    public List<Car> getAllCars() {
        return this.service.readCars();
    }

    @PostMapping("/createCar")
    public Car createCar(@RequestBody Car car) {
        return this.service.createCar(car);
    }

    @DeleteMapping("/deleteCar/{id}")
    public boolean deleteCar(@PathVariable Long id) {
        return this.service.deleteCar(id);
    }

    @GetMapping("/getCarById/{id}")
    public Car getCarById(@PathVariable Long id) {
        return this.service.findCarById(id);
    }

    @PutMapping("/updateCar/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return this.service.updateCar(id, car);
    }

    @PutMapping("/updateCar2")
        public Car updateCar2(@PathParam("id") Long id, @RequestBody Car car) {
        return this.service.updateCar(id, car);
    }
}
