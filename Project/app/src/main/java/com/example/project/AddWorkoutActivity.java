package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddWorkoutActivity extends AppCompatActivity {

    private EditText editTextWorkoutType;
    private EditText editTextDuration;
    private Switch switchCompleted;
    private Button btnSaveWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_workout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.add_workout_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find views by their id
        editTextWorkoutType = findViewById(R.id.editTextWorkoutType);
        editTextDuration = findViewById(R.id.editTextDuration);
        switchCompleted = findViewById(R.id.switchCompleted);
        btnSaveWorkout = findViewById(R.id.btnSaveWorkout);

        // Save button click
        btnSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWorkout();
            }
        });
    }

    private void saveWorkout() {
        String type = editTextWorkoutType.getText().toString().trim();
        String durationStr = editTextDuration.getText().toString().trim();

        // Check if fields are empty
        if (type.isEmpty() || durationStr.isEmpty()) {
            Toast.makeText(this, "Fill both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // String to int...
        int duration = Integer.parseInt(durationStr);
        boolean isCompleted = switchCompleted.isChecked();

        // Creates a new workout object
        Workout newWorkout = new Workout(type, duration, isCompleted);

        // Add to our manager
        WorkoutManager.getInstance().addWorkout(newWorkout);
        // Displays a simple message to notify that the entry actually went through
        Toast.makeText(this, "Workout saved!", Toast.LENGTH_SHORT).show();
        // Returns to the main menu as it's conventional
        finish();
    }
}