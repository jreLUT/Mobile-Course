package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWorkouts;
    private WorkoutAdapter adapter;
    private List<Workout> workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workout_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewWorkouts = findViewById(R.id.recyclerViewWorkouts);
        recyclerViewWorkouts.setLayoutManager(new LinearLayoutManager(this));

        // Get data from manager
        workoutList = WorkoutManager.getInstance().getWorkouts();

        // Initialize Adapter with the data and onClickListener
        adapter = new WorkoutAdapter(workoutList, new WorkoutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Workout workout, int position) {
                Intent intent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                intent.putExtra("WORKOUT_INDEX", position); // Pass the index to know which one was clicked
                startActivity(intent);
            }
        });

        // Attach adapter to RecyclerView
        recyclerViewWorkouts.setAdapter(adapter);
    }

    // Refresh list if we come back from another view
    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}