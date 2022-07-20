package com.tw.dojo.bouncingBall.model;

public class ElasticBehaviour implements Behaviour{
    public static final int GROWTH_RATE = 2;
    protected static final int GROW = 1;
    protected static final int SHRINK = -1;
    private int growthDirection;

    public ElasticBehaviour( int growthDirection) {
        this.growthDirection = growthDirection;
    }

    private int reverseGrowthDirectionIfNecessary(Ball ball) {
        if (growingTooBig(ball) || shrinkingTooSmall(ball)) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall(Ball ball) {
        return ball.radius <= 0 && shrinking();
    }

    private boolean growingTooBig(Ball ball) {
        return ball.radius >= ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next(Ball ball) {
        return ball.radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
    @Override
    public void behave(Ball ball) {
        growthDirection = reverseGrowthDirectionIfNecessary(ball);
        ball.radius = next(ball);
    }

}
