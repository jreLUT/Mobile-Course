package com.example.project;

import java.io.Serializable;

// Represents a single workout session.
public class Workout implements Serializable {

    private String type;
    private int durationMinutes;
    private boolean isCompleted;

    // COnstructor
    public Workout(String type, int durationMinutes, boolean isCompleted) {
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.isCompleted = isCompleted;
    }

    public String getType() {
        return type;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // For changing completion status
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Variable for notes default being an empty string
    private String notes = "";

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}