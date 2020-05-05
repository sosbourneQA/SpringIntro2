package com.qa.service;

import com.qa.domain.Garage;
import com.qa.exceptions.GarageNotFoundException;
import com.qa.repo.GaragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    private final GaragesRepository repo;

    @Autowired
    public GarageService(GaragesRepository repo) {
        this.repo = repo;
    }

    public List<Garage> readGarages() {
        return this.repo.findAll();
    }

    public Garage createGarage(Garage garage) {
        return this.repo.save(garage);
    }

    public Garage findGarageById(Long id) {
        return this.repo.findById(id).orElseThrow(GarageNotFoundException::new);
    }

    public Garage updateGarage(Long id, Garage garage) {
        Garage update = findGarageById(id);
        update.setName(garage.getName());
        return this.repo.save(update);
    }

    public boolean deleteGarage(Long id) {
        if(!this.repo.existsById(id)) {
            throw new GarageNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}
