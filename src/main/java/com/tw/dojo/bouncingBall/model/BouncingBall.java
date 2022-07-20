package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingBall extends Ball {

    Bounceable bounceable;

    BouncingBall(int x, int y, int direction) {

        super(x, y);
        bounceable = new Bounceable(this,direction);
    }

    @Override
    public void update() {
        bounceable.update();
    }

}
