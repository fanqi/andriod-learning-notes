package xyz.fanqi.translateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnTranslateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用代码实现移动动画效果
                //相对于当前位置开始往右移动200，往下移动200
//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 200);
//                translateAnimation.setDuration(1000);
//                v.startAnimation(translateAnimation);
                //使用XML实现移动动画效果
                 v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_animation));
            }
        });
    }
}
