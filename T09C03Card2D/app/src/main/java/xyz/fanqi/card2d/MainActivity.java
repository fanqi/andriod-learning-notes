package xyz.fanqi.card2d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivA;
    private ImageView ivB;

    //动画1，相对于父容器沿中线缩放，从1到0
    private ScaleAnimation scaleAnimation1 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    //动画2，相对于父容器沿中线缩放，从0到1
    private ScaleAnimation scaleAnimation2 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //布局点击事件
        findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果图片A显示，则给图片添加动画1，否则给图片2添加动画1
                if (ivA.getVisibility() == View.VISIBLE) {
                    ivA.startAnimation(scaleAnimation1);
                } else {
                    ivB.startAnimation(scaleAnimation1);
                }
            }
        });
    }

    private void showImgA() {
        ivA.setVisibility(View.VISIBLE);//显示图片A
        ivB.setVisibility(View.INVISIBLE);//占位隐藏图片B
    }

    private void showImgB() {
        ivA.setVisibility(View.INVISIBLE);
        ivB.setVisibility(View.VISIBLE);
    }

    private void initView() {
        ivA = (ImageView) findViewById(R.id.ivA);
        ivB = (ImageView) findViewById(R.id.ivB);
        showImgA();
        scaleAnimation1.setDuration(500);//动画1执行时间0.5秒
        scaleAnimation2.setDuration(500);//动画2执行时间0.5秒

        //动画1的监听器
        scaleAnimation1.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            //动画1执行完成之后，开始执行动画2
            @Override
            public void onAnimationEnd(Animation animation) {
                //如果图片A的状态是可见的，则去掉图片A的动画，显示图片B，然后给图片B执行动画2
                //反之，则去掉图片B的动画，显示图片A，然后给图片A执行动画2
                if (ivA.getVisibility() == View.VISIBLE) {
                    ivA.setAnimation(null);
                    showImgB();
                    ivB.startAnimation(scaleAnimation2);
                } else {
                    ivB.setAnimation(null);
                    showImgA();
                    ivA.startAnimation(scaleAnimation2);
                }
            }
        });
    }
}
