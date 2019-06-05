package com.example.selflearning;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CustomAnimation extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {

        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

//        t.setAlpha(interpolatedTime);
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime*20)*50), 0);

        super.applyTransformation(interpolatedTime, t);
    }
}
