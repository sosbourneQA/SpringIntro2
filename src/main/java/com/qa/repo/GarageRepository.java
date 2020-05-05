package com.qa.repo;

import com.qa.domain.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {

//    Garage findByName(String name);

}
