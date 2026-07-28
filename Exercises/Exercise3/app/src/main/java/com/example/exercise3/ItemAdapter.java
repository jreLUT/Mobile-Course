package com.example.exercise3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final Context context;
    private final String[] items;
    private final String[] prices;
    private final String[] descriptions;


    public ItemAdapter(Context c, String[] i, String[] p, String[] d) {
        this.context = c;
        this.items = i;
        this.prices = p;
        this.descriptions = d;
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;
        TextView priceTextView;

        public ItemViewHolder(@NonNull View v) {
            super(v);
            nameTextView = v.findViewById(R.id.nameTextView);
            descriptionTextView = v.findViewById(R.id.descriptionTextView);
            priceTextView = v.findViewById(R.id.priceTextView);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // new view for each
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recyclerview_detail, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Sets the data to textviews
        holder.nameTextView.setText(items[position]);
        holder.descriptionTextView.setText(descriptions[position]);
        holder.priceTextView.setText(prices[position]);

        // Onclick
        holder.itemView.setOnClickListener(view -> {
            Intent showDetailActivity = new Intent(context, DetailActivity.class);
            // position is the index (0, 1, 2...)
            showDetailActivity.putExtra("com.example.exercise3.ITEM_INDEX", position);
            context.startActivity(showDetailActivity);
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}

