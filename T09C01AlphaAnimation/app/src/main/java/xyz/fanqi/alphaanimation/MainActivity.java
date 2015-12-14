package xyz.fanqi.alphaanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                使用代码实现透明动画
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
//                alphaAnimation.setDuration(1000);
//                v.startAnimation(alphaAnimation);
//                使用XML文件实现透明动画效果
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha_animation));
            }
        });
    }
}
