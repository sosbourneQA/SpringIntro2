package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
}
