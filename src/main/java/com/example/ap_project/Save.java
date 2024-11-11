package com.example.ap_project;

import java.io.Serializable;

public class Save implements Serializable {
    Level level;
    int score;
    int cherries;
    int Highscore;

    public int getHighscore() {
        return Highscore;
    }

    public void setHighscore(int highscore) {
        Highscore = highscore;
    }

    public Save(Level level, int score, int cherries) {
        this.level = level;
        this.score = score;
        this.cherries = cherries;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }
}
