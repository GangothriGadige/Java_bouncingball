package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class Bounceable {

    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int bouncingDirection;
    private final Ball ball;

    public Bounceable(Ball ball, int bouncingDirection) {
        this.ball = ball;
        this.bouncingDirection = bouncingDirection;
    }


    public void update() {
        bouncingDirection = reverseDirectionIfNecessary();
        ball.y = move();
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.bouncingDirection;
    }

    private boolean movingTooLow() {
        return ball.y + ball.radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return ball.y - ball.radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return ball.y + (MOVEMENT_SPEED * bouncingDirection);
    }

    private boolean movingDown() {
        return bouncingDirection == DOWN;
    }

    private boolean movingUp() {
        return bouncingDirection == UP;
    }

}
