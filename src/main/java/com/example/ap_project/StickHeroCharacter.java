package com.example.ap_project;

public class StickHeroCharacter {
    private int score;
    private int cherries;
    private Level Current_Level;
    private Stick stick;

    private static StickHeroCharacter instance;
    // Private constructor to prevent instantiation from outside
    private StickHeroCharacter(int score, int cherries, Level level) {
        this.score = score;
        this.cherries = cherries;
        this.Current_Level = level;
    }

    // Public method to get the singleton instance
    public static StickHeroCharacter getInstance(int score, int cherries, Level level) {
        if (instance == null) {
            instance = new StickHeroCharacter(score, cherries, level);
        }
        return instance;
    }

    // Other methods and getters/setters as before...

    // Example of accessing the singleton:
    // StickHeroCharacter character = StickHeroCharacter.getInstance(0, 0, someLevel);




    public Stick getStick() {
        return stick;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
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

    public Level getCurrent_Level() {
        return Current_Level;
    }

    public void setCurrent_Level(Level current_Level) {
        Current_Level = current_Level;
    }


}
