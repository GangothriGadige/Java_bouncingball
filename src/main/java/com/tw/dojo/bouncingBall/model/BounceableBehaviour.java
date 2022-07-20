package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BounceableBehaviour implements Behaviour{
    public static final int MOVEMENT_SPEED = 12;
    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;

    public BounceableBehaviour( int direction) {
        this.direction=direction;
    }
    private int reverseDirectionIfNecessary(Ball ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection();
        }

        return this.direction;
    }
    private boolean movingTooLow(Ball ball) {

        return ball.y + ball.radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh(Ball ball) {

        return ball.y - ball.radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }
    private int move(Ball ball) {
        return ball.y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }

    @Override
    public void behave(Ball ball) {
        direction = reverseDirectionIfNecessary(ball);
        ball.y = move(ball);
    }
}
