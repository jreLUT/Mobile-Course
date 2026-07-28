package com.example.project;

import java.util.ArrayList;
import java.util.List;

// Singleton class to store workout data
public class WorkoutManager {

    private static WorkoutManager instance;
    private List<Workout> workoutList;

    private WorkoutManager() {
        workoutList = new ArrayList<>();

    }

    // Returns the single instance of this class
    public static WorkoutManager getInstance() {
        if (instance == null) {
            instance = new WorkoutManager();
        }
        return instance;
    }

    // Returns the list of all workouts
    public List<Workout> getWorkouts() {
        return workoutList;
    }

    // Adds a new workout to the list
    public void addWorkout(Workout workout) {
        workoutList.add(workout);
    }

    // Removes a workout based on its index in the list
    public void removeWorkout(int index) {
        if (index >= 0 && index < workoutList.size()) {
            workoutList.remove(index);
        }
    }
}
