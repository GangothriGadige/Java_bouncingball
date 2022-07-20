package com.tw.dojo.bouncingBall.model;

public class ElasticBall extends Ball {
    Elasticity elasticity;

    ElasticBall(int x, int y, int radius, int growthDirection) {
        super(x, y, radius);
        elasticity = new Elasticity(this, growthDirection);
    }

    @Override
    public void update() {
        elasticity.update();
    }
}
