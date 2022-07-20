package com.tw.dojo.bouncingBall.model;

public class Elasticity {
    public static final int GROWTH_RATE = 2;
    protected static final int GROW = 1;
    protected static final int SHRINK = -1;
    private final Ball ball;
    private int growthDirection;

    public Elasticity(Ball ball, int growthDirection) {
        this.ball = ball;
        this.growthDirection = growthDirection;
    }

    public void update(){
        growthDirection = reverseGrowthDirectionIfNecessary();
        ball.radius = next();
    }
    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return ball.radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return ball.radius >= ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return ball.radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
