# Mobile Development Coursework - Android Studio

**Author:** [Jere Verkkomäki]  
**Student Number:** [001833690]

This repository contains my coursework, learning diary and the project for the Anytime course: Software Development Skills: Mobile 2025-26.

## Repository Structure

*   **/Exercises** - Contains all the practical exercise projects completed during the course (Tutorial videos parts 1-3).
    *   `Exercise1/` - My First App (Basic sum calculator).
    *   `Exercise2/` - Quick Add Launcher (Two views that information carries between. Google button).
    *   `Exercise3/` - A RecyclerView that shows fruits, prices, descriptions and images.
*   **/Project** - The source code for the final standalone Android application.
*   **Mobile Learning Diary.pdf** - Document reflecting my learning process and thoughts.

---

## The course project
The project is a simple and intuitive Workout Tracker-app. Users can add workouts, workout durations and toggle if they've completed it or not.
There is a list that shows every saved workout and by clicking on one the user can add extra details or delete the workout.

### Tools:
*   **Language:** Java
*   **Build system:** Gradle (Kotlin DSL)
*   **Mininum SDK:** API Level 24 Nougat
*   **IDE: Android** Studio

### Project Structure:
*   `MainActivity` (The main navigation menu)
*   `AddWorkoutActivity` (Ability to add a workout to the list)
*   `WorkoutListActivity` (Displays the workout data using a RecyclerView and an adapter)
*   `WorkoutDetailActivity` (Shows detailed info about the workout and delete button)
*   `WorkoutManager` (A singleton class that manages the data)

### How to run the project
1. Clone this repository: `git clone https://github.com/jreLUT/Mobile-Course.git`
2. Open the `/Project` folder in **Android Studio** (Nougat Level 24 API or newer should work).
3. Let Gradle sync and build the project.
4. Run the app on an Android Emulator or a physical device via USB debugging (I personally couldn't test the Emulator myself due to having an ARM-based laptop, since it's not supported and used USB debugging.)

### Demonstration Video (No Audio)
*   Link: 

---

## Learning Diary

The mandatory learning diary has been updated as I went through the course in a time span of only 4 days or so. 
It is included in the repo as a pdf-file.
