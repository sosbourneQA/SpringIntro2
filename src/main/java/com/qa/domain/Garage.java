package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Garage {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "garage", fetch = FetchType.LAZY)
    private List<Car> garages = new ArrayList<>();

    public Garage() {
    }

    public Garage(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getGarages() {
        return garages;
    }

    public void setGarages(List<Car> garages) {
        this.garages = garages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return id.equals(garage.id) &&
                Objects.equals(name, garage.name) &&
                Objects.equals(garages, garage.garages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, garages);
    }
}
