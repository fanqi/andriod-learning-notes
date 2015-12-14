package xyz.fanqi.animateme;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        // TODO: 15/12/14 为什么代码实现的属性动画，按钮只能执行一次
//        v.animate().rotation(360).setDuration(1000).start();

        //使用XML配置属性动画
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animate_me);
        objectAnimator.setTarget(v);
        objectAnimator.start();
    }
}
