package com.example.mentalcounting.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.mentalcounting.R;

public class ScoreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Button retour = findViewById(R.id.previous_button);
        retour.setOnClickListener(view -> finish());
    }
}