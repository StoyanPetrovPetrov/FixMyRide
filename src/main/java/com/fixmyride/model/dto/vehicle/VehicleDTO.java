package com.fixmyride.model.dto.vehicle;


import jakarta.validation.constraints.NotEmpty;

public class VehicleDTO {

    private Long id;
    @NotEmpty
    private String make;

    @NotEmpty
    private String model;

    @NotEmpty
    private int year;

    @NotEmpty
    private String vin;

    @NotEmpty
    private Long userId;

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
}
