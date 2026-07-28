package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter for the recyclerView
public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    private List<Workout> workoutList;
    private OnItemClickListener listener;

    // Handles clicks on list items
    public interface OnItemClickListener {
        void onItemClick(Workout workout, int position);
    }

    // Constructor
    public WorkoutAdapter(List<Workout> workoutList, OnItemClickListener listener) {
        this.workoutList = workoutList;
        this.listener = listener;
    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item_workout.xml layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position) {
        // Get the workout at the current position
        Workout currentWorkout = workoutList.get(position);

        // Set the data to the text views
        holder.textViewItemType.setText(currentWorkout.getType());

        String status = currentWorkout.isCompleted() ? "Yes" : "No";
        holder.textViewItemDetails.setText("Duration: " + currentWorkout.getDurationMinutes() + " min | Completed: " + status);

        // Handles item click
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentWorkout, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemType;
        TextView textViewItemDetails;


        // Calls the constructor
        public WorkoutViewHolder(View itemView) {
            super(itemView);
            textViewItemType = itemView.findViewById(R.id.textViewItemType);
            textViewItemDetails = itemView.findViewById(R.id.textViewItemDetails);
        }
    }
}
