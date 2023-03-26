package com.fixmyride.model.dto.user.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make",nullable = false)
    private String make;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "year",nullable = false)
    private int year;



    @Column(name = "vin")
    private String vin;

    @Column(name = "user_id")
    private Long userId;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                ", userId=" + userId +
                '}';
    }
}
