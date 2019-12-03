package com.example.sprintapp.shared;


public class EventType {

    private int id;
    private String name;


    @SuppressWarnings("unused")
    public EventType() {
        // for serialization
    }

    public EventType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
