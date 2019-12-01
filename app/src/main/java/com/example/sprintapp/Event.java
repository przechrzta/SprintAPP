package com.example.sprintapp;

public class Event {

    private String clientName;
    private String phoneNumber;

    private EventType eventType;

    public Event(String clientName, String phoneNumber, EventType eventType) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.eventType = eventType;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EventType getEventType() {
        return eventType;
    }

}
