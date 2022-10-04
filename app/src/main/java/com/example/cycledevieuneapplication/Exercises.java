package com.example.cycledevieuneapplication;

public class Exercises {
    private String id;
    private String name;
    private String description;
    private String muscles;

    public Exercises(String id, String name, String description, String muscles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.muscles = muscles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscles() {
        return muscles;
    }

    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }
}
