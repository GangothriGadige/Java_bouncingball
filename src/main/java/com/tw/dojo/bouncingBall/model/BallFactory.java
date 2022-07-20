package com.tw.dojo.bouncingBall.model;

public class BallFactory {

    public static Ball[] all()  {
        return new Ball[]{
                bouncingBall(75, 50, Bounceable.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elasticity.SHRINK),
               elasticBouncingBall(350, 200, Ball.DEFAULT_RADIUS,Bounceable.DOWN,
                        Elasticity.SHRINK)
                //bouncingElasticBall() --> Let's make a new ball!

        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BouncingBall(centerX, centerY, direction);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new ElasticBall(centerX, centerY, radius, direction);
    }

    public static Ball elasticBouncingBall(int centerX, int centerY, int radius, int direction,int growthDirection) {
        System.out.println("Inside elasticBouncingball constructor");
        return new ElasticBouncingBall(centerX, centerY, radius, direction, growthDirection);
    }


}
