package com.tw.dojo.bouncingBall.model;

import java.util.List;

public class CompositeBehaviour implements Behaviour{
    List<Behaviour> behavioursList;

    CompositeBehaviour(List<Behaviour> behavioursList){
        this.behavioursList=behavioursList;
    }

    @Override
    public void behave(Ball ball) {
        behavioursList.forEach(behaviour->{
            behaviour.behave(ball);
        });


    }
}
