package com.mygdx.game.Tools;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Point2D {
    Random rand;
    public Vector2 vector = new Vector2();
    public double speed;
    public Point2D(Point2D p) {
        x = p.getX();
        y = p.getY();
    }
    private float x,y;
    public Point2D(float x, float y, double speed) {
        this.x = x;
        this.y = y;
    }

    public float getX(){

        return x;
    }
    public float getY(){

        return y;
    }
    public void setX(float x){

        this.x=x;
    }
    public void setY(float x){

        this.y=y;

    }

}
