package xyz.fanqi.scaleanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnScaleMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用代码实现缩放动画效果
                //从左上角开始缩放，x轴从0缩放到1倍，y轴从0缩放到1倍
                //ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1);
                //相对于自身的中心点开始缩放，x轴从0缩放到1倍，y轴从0缩放到1倍
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(1000);
                v.startAnimation(scaleAnimation);
                //使用XML实现缩放动画效果
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation));
            }
        });
    }
}
