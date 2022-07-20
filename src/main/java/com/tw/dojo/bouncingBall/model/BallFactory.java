package com.tw.dojo.bouncingBall.model;

import java.util.List;

public class BallFactory {

    public static Ball[] all()  {
        return new Ball[]{
                bouncingBall(75, 50, BounceableBehaviour.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBehaviour.SHRINK),
               bouncingElasticBall(400, 100, Ball.DEFAULT_RADIUS,BounceableBehaviour.DOWN,
                        ElasticBehaviour.SHRINK)
                //bouncingElasticBall() --> Let's make a new ball!

        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction){
        List<Behaviour> behaviours = List.of(new BounceableBehaviour(direction));
        CompositeBehaviour behaviour = new CompositeBehaviour(behaviours);
        return new Ball(centerX,centerY,behaviour);
    }
    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        List<Behaviour> behaviours = List.of(new ElasticBehaviour(direction));
        CompositeBehaviour behaviour = new CompositeBehaviour(behaviours);
        return new  Ball(centerX,centerY,radius,behaviour);
    }
    public static Ball bouncingElasticBall(int centerX, int centerY,int radius, int bounceDirection, int elasticDirection) {
        List<Behaviour> behaviours = List.of(new BounceableBehaviour(bounceDirection),new ElasticBehaviour(elasticDirection));
        CompositeBehaviour behaviour = new CompositeBehaviour(behaviours);
        return new Ball(centerX,centerY,radius,behaviour);
    }

}
