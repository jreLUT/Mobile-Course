package com.example.project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WorkoutDetailActivity extends AppCompatActivity {

    private TextView textViewDetailType;
    private TextView textViewDetailDuration;
    private Switch switchDetailCompleted;
    private EditText editTextDetailNotes;
    private Button btnSaveNotes;
    private Button btnDeleteWorkout;

    private int workoutIndex;
    private Workout currentWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workout_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewDetailType = findViewById(R.id.textViewDetailType);
        textViewDetailDuration = findViewById(R.id.textViewDetailDuration);
        switchDetailCompleted = findViewById(R.id.switchDetailCompleted);
        editTextDetailNotes = findViewById(R.id.editTextDetailNotes);
        btnSaveNotes = findViewById(R.id.btnSaveNotes);
        btnDeleteWorkout = findViewById(R.id.btnDeleteWorkout);
        workoutIndex = getIntent().getIntExtra("WORKOUT_INDEX", -1);

        if (workoutIndex != -1) {
            // Load the workout from the manager by the index
            currentWorkout = WorkoutManager.getInstance().getWorkouts().get(workoutIndex);

            // Set data
            textViewDetailType.setText(currentWorkout.getType());
            textViewDetailDuration.setText("Duration: " + currentWorkout.getDurationMinutes() + " min");
            switchDetailCompleted.setChecked(currentWorkout.isCompleted());

            editTextDetailNotes.setText(currentWorkout.getNotes());
        }

        // Save notes button
        btnSaveNotes.setOnClickListener(v -> {
            if (currentWorkout != null) {
                String newNotes = editTextDetailNotes.getText().toString();
                currentWorkout.setNotes(newNotes);
                // Informs the user
                Toast.makeText(WorkoutDetailActivity.this, "Notes saved.", Toast.LENGTH_SHORT).show();
            }
        });

        // The switch status toggle
        switchDetailCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (currentWorkout != null) {
                    currentWorkout.setCompleted(isChecked);
                }
            }
        });

        // Delete button
        btnDeleteWorkout.setOnClickListener(v -> {
            if (workoutIndex != -1) {
                WorkoutManager.getInstance().removeWorkout(workoutIndex);
                // Informs the user
                Toast.makeText(this, "Workout deleted.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}