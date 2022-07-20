package com.tw.dojo.bouncingBall.model;

public class ElasticBouncingBall extends Ball{
    Bounceable bounceable;
    Elasticity elasticity;

    ElasticBouncingBall(int x,int y,int radius,int bouncingDirection,int growthDirection){
        super(x,y,radius);
        bounceable = new Bounceable(this, bouncingDirection);
        elasticity = new Elasticity(this, growthDirection);
    }

    @Override
    public void update() {
        bounceable.update();
        elasticity.update();
    }
}
