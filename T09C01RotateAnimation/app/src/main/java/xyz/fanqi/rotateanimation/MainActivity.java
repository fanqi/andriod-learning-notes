package xyz.fanqi.rotateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRotateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用代码实现旋转动画效果
                //围绕左上角旋转1周
                //RotateAnimation rotateAnimation = new RotateAnimation(0,360);
                //围绕坐标(100,100)旋转1周
                //RotateAnimation rotateAnimation = new RotateAnimation(0,360,100,100);
                //围绕按钮中心点旋转1周
                //RotateAnimation rotateAnimation = new RotateAnimation(0,360,v.getPivotX(), v.getPivotY());
                //相对于按钮自身的中心点旋转1周
//                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotateAnimation.setDuration(1000);
//                v.startAnimation(rotateAnimation);
                //使用XML实现旋转动画效果
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_animation));
            }
        });
    }
}
