package com.example.sprintapp.shared;

public class Event {

    private String clientName;
    private String phoneNumber;
    private String additionalInfo;
    private String carModel;
    private String carProductionYear;
    private String carRegistrationNumber;
    private String eventType;


    @SuppressWarnings("unused")
    public Event() {
        // for serialization
    }

    public Event(String clientName, String phoneNumber, String additionalInfo, String carModel, String carProductionYear, String carRegistrationNumber, String eventType) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.additionalInfo = additionalInfo;
        this.carModel = carModel;
        this.carProductionYear = carProductionYear;
        this.carRegistrationNumber = carRegistrationNumber;
        this.eventType = eventType;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarProductionYear() {
        return carProductionYear;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    public String getEventType() {
        return eventType;
    }

}
