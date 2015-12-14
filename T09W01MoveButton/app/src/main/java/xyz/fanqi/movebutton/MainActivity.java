package xyz.fanqi.movebutton;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TranslateAnimation translateAnimationLeftToRight = new TranslateAnimation(0, 200, 0, 0);
    private TranslateAnimation translateAnimationTopToBottom = new TranslateAnimation(0, 0, 0, 200);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListener();
    }

    private void initClickListener() {
        findViewById(R.id.btnMoveByViewAnimInXML).setOnClickListener(this);
        findViewById(R.id.btnMoveByViewAnimInCode).setOnClickListener(this);
        findViewById(R.id.btnMoveByObjectAnimatorInXML).setOnClickListener(this);
        findViewById(R.id.btnMoveByObjectAnimatorInCode).setOnClickListener(this);
        findViewById(R.id.imageView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMoveByViewAnimInXML:
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.btn_animation_set));
                break;
            case R.id.btnMoveByViewAnimInCode:
                moveByViewAnimInCode(v);
                break;
            case R.id.btnMoveByObjectAnimatorInXML:
                moveByObjectAnimatorInXML(v);
                break;
            case R.id.btnMoveByObjectAnimatorInCode:
                moveByObjectAnimatorInCode(v);
                break;
            case R.id.imageView:
                Rotate3D(v);

                break;
            default:
                break;
        }
    }

    private void Rotate3D(View v) {
        //方法1：用AnimatorSet
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(v, "rotationY", 0.0f, 180.0f).setDuration(1000),
                ObjectAnimator.ofFloat(v, "rotationY", 180.0f, 180.0f).setDuration(1000),
                ObjectAnimator.ofFloat(v, "rotationY", 180.0f, 0.0f).setDuration(1000)
        );
        animatorSet.start();

        //方法2：Rotate3dAnimation
//        AnimationSet animationSet = new AnimationSet(true);
//        // 获取布局的中心点位置，作为旋转的中心点
//        float centerX = v.getWidth() / 2f;
//        float centerY = v.getHeight() / 2f;
//        //翻转180度
//        Rotate3dAnimation rotation3D1 = new Rotate3dAnimation(0, 180, centerX, centerY, 0, true);
//        // 动画持续时间1秒
//        rotation3D1.setDuration(1000);
//        // 动画执行完成之后保持状态
//        rotation3D1.setFillAfter(true);
//        animationSet.addAnimation(rotation3D1);
//        //反向翻转180度
//        Rotate3dAnimation rotation3D2 = new Rotate3dAnimation(0, -180, centerX, centerY, 0, true);
//        // 动画延迟2秒执行
//        rotation3D2.setStartOffset(2000);
//        // 动画持续时间1秒
//        rotation3D2.setDuration(1000);
//        animationSet.addAnimation(rotation3D2);
//        v.startAnimation(animationSet);
    }

    private void moveByObjectAnimatorInXML(View v) {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.btn_animator_set);
        animatorSet.setTarget(v);
        animatorSet.start();
    }

    private void moveByObjectAnimatorInCode(View v) {
        AnimatorSet animatorSet = new AnimatorSet();
        //顺序执行
        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(v, "translationX", 0, 200).setDuration(1000),
                ObjectAnimator.ofFloat(v, "translationY", 0, 200).setDuration(1000),
                ObjectAnimator.ofFloat(v, "translationY", 200, 0).setDuration(1000),
                ObjectAnimator.ofFloat(v, "translationX", 200, 0).setDuration(1000)
        );
        animatorSet.start();
    }

    private void moveByViewAnimInCode(final View v) {
        //方法1：执行从左到右动画结束后执行从上到下动画
//        translateAnimationLeftToRight.setDuration(1000);
//
//        translateAnimationLeftToRight.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                translateAnimationTopToBottom.setDuration(1000);
//                v.startAnimation(translateAnimationTopToBottom);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        v.startAnimation(translateAnimationLeftToRight);

        //方法2：设置从上到下的动画延迟1秒执行
        AnimationSet animationSet = new AnimationSet(true);
        translateAnimationLeftToRight.setDuration(1000);
        animationSet.addAnimation(translateAnimationLeftToRight);
        translateAnimationTopToBottom.setDuration(1000);
        translateAnimationTopToBottom.setStartOffset(1000);
        animationSet.addAnimation(translateAnimationTopToBottom);
        v.startAnimation(animationSet);
    }
}
