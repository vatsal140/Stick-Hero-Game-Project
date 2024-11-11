package com.example.ap_project;

import java.io.Serializable;

public class Platform  implements Serializable {
    private int x_coord;
    private int width;

    public Platform(int x_coord,int width) {
        this.x_coord=x_coord;
        this.width=width;

    }
//    public Platform(Platform prev){
//        Platform_generator(prev);
//    }
//
//    public void Platform_generator(Platform prev_xcoord){
//
//    }

    public int getWidth() {
        return width;
    }


    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}


