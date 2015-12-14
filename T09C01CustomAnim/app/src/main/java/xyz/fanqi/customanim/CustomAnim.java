package xyz.fanqi.customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by fanqi on 15/12/14.
 */
public class CustomAnim extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        System.out.println("init");
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        System.out.println(interpolatedTime);

        //透明效果
        //t.setAlpha(interpolatedTime);
        //移动效果
        //t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);
        //摇摆效果，调大摇摆距离可以调大50，加快摇摆速度可以调大10
        t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*10)*50,0);
        super.applyTransformation(interpolatedTime, t);
    }
}
