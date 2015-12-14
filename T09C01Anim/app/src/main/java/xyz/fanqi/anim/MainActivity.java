package xyz.fanqi.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

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

//                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.animate_set));

                Animation animationSet = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animate_set);

                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this,"Animation Start",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this,"Animation End",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                v.startAnimation(animationSet);
            }
        });
    }
}
