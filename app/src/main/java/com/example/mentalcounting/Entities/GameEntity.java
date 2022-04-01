package com.example.mentalcounting.Entities;

public class GameEntity extends BaseEntity {
    String pseudo;
    String score;

    public String getPseudo() {
        return pseudo;
    }

    public String getScore() {
        return score;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(String score) {
        this.score = score;
    }
}