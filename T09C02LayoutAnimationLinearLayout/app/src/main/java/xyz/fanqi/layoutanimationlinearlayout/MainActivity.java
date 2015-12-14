package xyz.fanqi.layoutanimationlinearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
     private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main,null);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1);
        scaleAnimation.setDuration(5000);
        //按钮一起出来
        //LayoutAnimationController layoutAnimationController = new LayoutAnimationController(scaleAnimation,0);
        //按钮一个接一个出来，一个执行到一半的情况下，第二个按钮出来
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(scaleAnimation,0.5f);
        //setOrder设置子对象的呈现顺序
        //ORDER_NORMAL：从上到下
        //ORDER_RANDOM：随机
        //ORDER_REVERSE：从下到上
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_RANDOM);
        linearLayout.setLayoutAnimation(layoutAnimationController);
        setContentView(linearLayout);
    }
}
