package com.example.ap_project;

import java.io.Serializable;
import java.util.Random;

public class Cherries implements Serializable {
    private int x_coordinate;

    public  Cherries(int cord1,int cord2) {


        Random random = new Random();

        int binomial = random.nextInt(2);
        if (binomial == 1&cord2-cord1>30) {
            System.out.println("CHERRY GENERATED");

            this.x_coordinate = random.nextInt(cord2-26 - cord1) + cord1+26;
        }
        else{
            System.out.println("CHerry not spawned");
            this.x_coordinate=1000;
        }
    }

    public void cherriesVanishing(int amount) {
        // cherries vanish after being eaten
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }
}

