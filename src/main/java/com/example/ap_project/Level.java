package com.example.ap_project;

import javafx.scene.input.MouseButton;

import java.io.Serializable;

public class Level implements Serializable {

    Platform p1;
    Platform p2;
    Cherries cherry;


    public Level() {
        HelloApplication.controller.initialize();
        this.p1=new Platform((int) HelloApplication.controller.p1.getTranslateX(), (int) HelloApplication.controller.p1.getWidth());
        this.p2=new Platform((int) HelloApplication.controller.p2.getTranslateX(), (int) HelloApplication.controller.p2.getWidth());
        this.cherry=HelloApplication.controller.getCherry_details();
        }

    public Level(int p1_translate,int p1_width,int p2_translate,int p2_width,Cherries cherry) {
//        HelloApplication.controller.initialize();
        this.p1=new Platform(p1_translate, p1_width);
        this.p2=new Platform( p2_translate, p2_width);
        this.cherry=cherry;
    }


    @Override
    public String toString() {
        return "Level{" +
                "p1=" + p1.getWidth() +
                ", p2=" + p2.getWidth() +
                ", cherry=" + cherry.getX_coordinate() +
                '}';
    }

    public Platform getP1() {
        return p1;
        }

public void setP1(Platform p1) {
        this.p1 = p1;
        }

public Platform getP2() {
        return p2;
        }

public void setP2(Platform p2) {
        this.p2 = p2;
        }

public Cherries getCherry() {
        return cherry;
        }

public void setCherry(Cherries cherry) {
        this.cherry = cherry;
        }
        }
