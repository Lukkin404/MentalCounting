package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Game extends AppCompatActivity {

    Integer premierElement;
    Integer deuxiemeElement;
    String symbol;
    Double resultat;

    public Integer getPremierElement() {
        return premierElement;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public Integer getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public void setDeuxiemeElement(Integer deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}