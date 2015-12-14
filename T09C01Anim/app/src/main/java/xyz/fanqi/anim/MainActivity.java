package xyz.fanqi.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //动画集合，动画补间设置为true
//                AnimationSet animationSet = new AnimationSet(true);
//                animationSet.setDuration(1000);
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
//                alphaAnimation.setDuration(1000);
//                animationSet.addAnimation(alphaAnimation);
//
//                TranslateAnimation translateAnimation = new TranslateAnimation(200,0,200,0);
//                translateAnimation.setDuration(1000);
//                animationSet.addAnimation(translateAnimation);
//
//                v.startAnimation(animationSet);

                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.animate_set));
            }
        });
    }
}
