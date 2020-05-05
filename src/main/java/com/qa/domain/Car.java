package com.qa.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private Double price;

    @ManyToOne(targetEntity = Garage.class)
    private Garage garage;

    public Car() {
    }

    public Car(String model, Double price) {
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id) &&
                Objects.equals(model, car.model) &&
                Objects.equals(price, car.price) &&
                Objects.equals(garage, car.garage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, price, garage);
    }
}
