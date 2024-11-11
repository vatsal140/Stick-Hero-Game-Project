package com.example.ap_project;

public class Menu{
    private int Lastscore;
    private int Highscore;
    private Save save;

    public Menu(int lastscore, int highscore, Save save) {
        this.Lastscore = lastscore;
        this.Highscore = highscore;
        this.save = save;
    }
    public void DisplayMenu(){

    }
    public int getLastscore() {
        return Lastscore;
    }

    public void setLastscore(int lastscore) {
        Lastscore = lastscore;
    }

    public int getHighscore() {
        return Highscore;
    }







    public void setHighscore(int highscore) {
        Highscore = highscore;
    }

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public void Load(GameEngine g1,Save save){

    }


}
