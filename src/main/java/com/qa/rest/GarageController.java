package com.qa.rest;

//import com.qa.service.CarService;
import com.qa.domain.Garage;
import com.qa.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GarageController {


    private final GarageService service;

    @Autowired
    public GarageController(GarageService service) {
        this.service = service;
    }

    @GetMapping("/getAllGarages")
    public List<Garage> getAllGarages() {
        return this.service.readGarages();
    }

    @PostMapping("/createGarage")
    public Garage createCar(@RequestBody Garage garage) {
        return this.service.createGarage(garage);
    }

    @DeleteMapping("/deleteGarage/{id}")
    public boolean deleteCar(@PathVariable Long id) {
        return this.service.deleteGarage(id);
    }

    @GetMapping("/getCarById/{id}")
    public Garage getCarById(@PathVariable Long id) {
        return this.service.findGarageById(id);
    }

    @PutMapping("/updateCar/{id}")
    public Garage updateCar(@PathVariable Long id, @RequestBody Garage garage) {
        return this.service.updateGarage(id, garage);
    }

    @PutMapping("/updateGarage2")
    public Garage updateGarage2(@PathParam("id") Long id, @RequestBody Garage garage) {
        return this.service.updateGarage(id, garage);
    }
}
