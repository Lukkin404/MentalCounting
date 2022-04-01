package com.example.mentalcounting.Activities;

import java.lang.reflect.Type;
import java.util.Random;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;

import com.example.mentalcounting.R;
import com.example.mentalcounting.TypeOperationEnum;

public class GameActivity extends AppCompatActivity {
    Integer premierElement = 0;
    Integer deuxiemeElement = 0;
    private Integer symboleTypeOperation = new Random().nextInt(3);
    private Integer reponseUtilisateur = 0;
    private Integer nbVie=3;
    private Integer score=0;
    private final Integer BORNE_HAUTE = 9999;
    private final TypeOperationEnum typeOperation = null;
    private Menu menu;

    // attribution des rôles des boutons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
        Button buttonSupprimer = findViewById(R.id.clear_button);
        buttonSupprimer.setOnClickListener(view -> Reinitialiser());
        Button buttonNegatif = findViewById(R.id.oppose_button);
        buttonNegatif.setOnClickListener(view -> Opposer());
        Button boutonValider=findViewById(R.id.submit_button);
        boutonValider.setOnClickListener(view -> Verification(symboleTypeOperation));

        InitialisationTypeOperation();
    }

    // génération aléatoire de la première valeur
    public Integer premierElement() {
        premierElement = new Random().nextInt(11); // nouvelle valeur aléatoire allant de 0 à 10
        return premierElement;
    }

    // génération aléatoire de la première valeur
    public Integer deuxiemeElement() {
        deuxiemeElement = new Random().nextInt(11); // nouvelle valeur aléatoire allant de 0 à 10
        return deuxiemeElement;
    }

    // ajoute la valeur sélectionnée à la suite des précédentes (si total inférieur au max)
    public void ajouteValeur(Integer valeur) {
        if (10 * reponseUtilisateur + valeur > BORNE_HAUTE) Toast.makeText(this, "Valeur trop grande", Toast.LENGTH_LONG).show();
        else reponseUtilisateur = 10 * reponseUtilisateur + valeur;
        setReponseUtilisateur();
    }

    // affiche la valeur entrée par l'utilisateur
    private void setReponseUtilisateur() {
        TextView textViewReponse = findViewById(R.id.textView_reponse);
        String string = String.valueOf(reponseUtilisateur);
        textViewReponse.setText(string);
    }

    // transforme la valeur entrée en son opposée
    private void Opposer() {
        reponseUtilisateur *= -1;
        setReponseUtilisateur();
    }

    // supprime la valeur entrée
    private void Reinitialiser() {
        TextView entreeUtilisateur = findViewById(R.id.userInput);
        entreeUtilisateur.setText("");
        reponseUtilisateur = 0;
    }

    // vérifie que le choix de l'utilisateur est bien correct
    private void Verification(Integer symboleAfficher) {
        TextView textView_reponse = findViewById(R.id.textView_reponse);
        String reponse = textView_reponse.getText().toString();
        Integer intReponse = Integer.parseInt(reponse);

        switch(symboleAfficher) {
            case 0: //cas addition
                if(intReponse == (premierElement + deuxiemeElement)) BonneReponse();
                else MauvaiseReponse();
                break;

            case 1: //cas soustraction
                if(intReponse == (premierElement-deuxiemeElement)) BonneReponse();
                else MauvaiseReponse();
                break;

            case 2: //cas multiplication
                if(intReponse == (premierElement*deuxiemeElement)) BonneReponse();
                else MauvaiseReponse();
                break;
        }
    }

    // en cas de bonne réponse
    public void BonneReponse(){
        Toast.makeText(getApplicationContext(),"Bonne réponse !",Toast.LENGTH_LONG).show();
        Reinitialiser();
        symboleTypeOperation = new Random().nextInt(3);
        InitialisationTypeOperation();
        Score();
    }

    // en cas de mauvaise réponse
    public void MauvaiseReponse(){
        Toast.makeText(getApplicationContext(), "Mauvaise réponse...",Toast.LENGTH_LONG).show();
        Reinitialiser();
        ErreurVie();
    }

    // enlève une vie tant qu'il en reste, sinon la partie est finie
    public void ErreurVie(){
        MenuItem vie = menu.findItem(R.id.life_number);
        nbVie--;
        if (nbVie!=0){
            String countVie = String.valueOf(nbVie);
            vie.setTitle(countVie);
        }else finish();
    }

    // incrémente le score
    public void Score(){
        MenuItem scoreMenu = menu.findItem(R.id.score_menu);
        score++;
        String countScore = String.valueOf(score);
        scoreMenu.setTitle(countScore);
    }

    // choisi aléatoirement un opérateur de calcul
    @SuppressLint("SetTextI18n")
    public Integer InitialisationTypeOperation(){
        this.symboleTypeOperation = new Random().nextInt(3);
        TypeOperationEnum symbole;
        switch(symboleTypeOperation) {
            case 0:
                symbole = TypeOperationEnum.ADD;
                break;
            case 1:
                symbole = TypeOperationEnum.SUBSTRACT;
                break;
            case 2:
                symbole = TypeOperationEnum.MULTIPLY;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + symboleTypeOperation);
        }
        TextView calcul = findViewById(R.id.operation);
        calcul.setText(premierElement() + " " + symbole + " " + deuxiemeElement());
        return symboleTypeOperation;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.menu = menu;
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_game,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.score_menu_button) {
            Intent intent = new Intent(this,ScoreActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.back_menu_button) finish();
        if(item.getItemId()==R.id.delete_menu_button) Reinitialiser();
        return super.onOptionsItemSelected(item);
    }
}