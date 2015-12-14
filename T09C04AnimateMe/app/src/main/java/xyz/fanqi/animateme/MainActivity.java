package xyz.fanqi.animateme;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimateMe).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //使用代码实现属性动画旋转360，时长1秒钟
        //v.animate().rotation(360).setDuration(1000).start();
        //关键帧，连续两个90,旋转到90度的时候停一下
        //ObjectAnimator.ofFloat(v,"rotation",0,90,90,360).setDuration(1000).start();


        //使用XML配置属性动画
//        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animate_me);
//        objectAnimator.setTarget(v);
//        objectAnimator.start();

        //使用XML配置属性动画集合
        // translationY是相对位置，Y是绝对位置
//        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animate_me_set);
//        animatorSet.setTarget(v);
//        animatorSet.start();

        //使用代码实现属性动画集合

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000);
        //顺序执行
        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(v, "alpha", 0, 1),
                ObjectAnimator.ofFloat(v, "translationY", 0, 200)
        );
        animatorSet.start();
    }
}
