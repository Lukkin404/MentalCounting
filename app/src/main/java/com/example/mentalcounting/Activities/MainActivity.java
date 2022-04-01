package com.example.mentalcounting.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import com.example.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attribution des rôles des boutons
        Button playButton = findViewById(R.id.new_game_button);
        Button scoreButton = findViewById(R.id.score_button);
        playButton.setOnClickListener(view -> openGame());
        scoreButton.setOnClickListener(view-> openScore());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main,menu);
        return true;
    }

    private void openScore() {
        Intent openScore = new Intent(this, ScoreActivity.class);
        startActivity(openScore);
    }

    private void openGame() {
        Intent open_Game = new Intent(this, GameActivity.class);
        startActivity(open_Game);
    }
}