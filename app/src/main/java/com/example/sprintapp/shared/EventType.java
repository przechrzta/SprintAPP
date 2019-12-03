package com.example.sprintapp.shared;


public class EventType {

    private final int id;
    private final String name;


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
