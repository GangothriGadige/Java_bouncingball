package com.tw.dojo.bouncingBall.model;

import java.awt.*;

public class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;
    protected Behaviour behaviour;

    protected Ball(int centerX, int centerY, Behaviour behaviour) {
        this.x=centerX;
        this.y=centerY;
        this.behaviour=behaviour;
        this.radius = DEFAULT_RADIUS;
    }

    protected Ball(int centerX, int centerY, int radius, Behaviour behaviour) {
        this.x=centerX;
        this.y=centerY;
        this.radius=radius;
        this.behaviour=behaviour;
    }


    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }
    public void update(){
        behaviour.behave(this);
    }

}
