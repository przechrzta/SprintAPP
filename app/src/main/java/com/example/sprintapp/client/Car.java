package com.example.sprintapp.client;


public class Car {

    private String carBrand;
    private String carModel;
    private String carProductionYear;
    private String fuelType;
    private String carRegistrationNumber;


    public Car() {
        //for serialization
    }

    public Car(String carBrand, String carModel, String carProductionYear, String fuelType, String carRegistrationNumber) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carProductionYear = carProductionYear;
        this.fuelType = fuelType;
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public String getCarBrand(){
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarProductionYear() {
        return carProductionYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }
}
