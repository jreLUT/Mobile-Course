package com.example.exercise2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Creating the buttons and on click listener. And the intent to change the activity
        Button secondActivityBtn = findViewById(R.id.secondActivity);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.example.exercise2.something", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });
// Then we need the google button and add functionality like in the tutorial video
        Button googleBtn = findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.com";
                Uri address = Uri.parse(google);
                Intent toGoogle = new Intent(Intent.ACTION_VIEW, address); // Sets the address to the intent

                try { // Tries to start google
                    startActivity(toGoogle);
                } catch (android.content.ActivityNotFoundException e) {
                    // This is a safer and more modern way to do the same
                    // Toast simply displays a popup in case of a error
                    android.widget.Toast.makeText(getApplicationContext(), "No browser found to open link", android.widget.Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}