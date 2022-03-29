package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    Integer premierElement = 0;
    Integer deuxiemeElement = 0;
    private TypeOperationEnum typeOperation;
    private TextView textViewCalcul;
    Double resultat;
    private Integer BORNE_HAUTE = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textViewCalcul = findViewById(R.id.textViewCalcul);
        Button bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> ajouteValeur(1));
        Button bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> ajouteValeur(2));
        Button bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> ajouteValeur(3));
        Button bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> ajouteValeur(4));
        Button bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> ajouteValeur(5));
        Button bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> ajouteValeur(6));
        Button bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> ajouteValeur(7));
        Button bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> ajouteValeur(8));
        Button bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> ajouteValeur(9));
        Button bouton0 = findViewById(R.id.button_0);
        bouton0.setOnClickListener(view -> ajouteValeur(0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_game,menu);
        MenuItem toolbarScore = menu.findItem(R.id.toolbarScore);
        MenuItem toolbarPossibleErrors = menu.findItem(R.id.toolbarPossibleErrors);
        //toolbarScore.setOnMenuItemClickListener(menuItem -> ());
        //toolbarPossibleErrors.setOnMenuItemClickListener(menuItem -> ());
        return true;
    }

    private void ajouteValeur(Integer valeur){
        if(10*resultat+valeur > BORNE_HAUTE){
            Toast.makeText(this,getString(R.string.ERREUR_TROP_GRAND),Toast.LENGTH_LONG).show();
        }else{
            resultat = 10*resultat+valeur;
        }

        majTextView();
    }

    private void majTextView() {
        String textAAfficher=resultat+"";
        textViewCalcul.setText(textAAfficher);
    }

    private boolean videTextView() {
        textViewCalcul.setText("");
        premierElement=0;
        typeOperation = null;
        deuxiemeElement = 0;
        return true;
    }

    /*private void ouvreLastComputeActivity(double resultat) {
        Intent i = new Intent(this, LastComputeActivity.class);
        i.putExtra("premierElement",premierElement);
        i.putExtra("deuxiemeElement",deuxiemeElement);
        i.putExtra("symbol",typeOperation.getSymbol());
        i.putExtra("resultat",resultat);
        startActivity(i);
    }*/
}