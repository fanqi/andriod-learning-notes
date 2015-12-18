package xyz.fanqi.scaleimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private ImageView imageView;//图片控件
    //最近一次两点间的距离
    float lastDistance = -1f;
    //缩放比例,每次缩放0.1
    private float scaling = 0.1f;
    //缩放距离,偏移距离大于10才进行缩放
    private float scaleDistance = 10l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ImageView控件
        imageView = (ImageView) findViewById(R.id.imageView);
        //为布局设置触摸监听器
        findViewById(R.id.container).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() >= 2) {
                    //X轴偏移量
                    float offsetX = event.getX(0) - event.getX(1);
                    //Y轴偏移量
                    float offsetY = event.getY(0) - event.getY(1);

                    //勾股定理计算当前两点间的距离
                    float currentDistance = (float) Math.sqrt(offsetX * offsetX + offsetY * offsetY);

                    //如果最近的距离大于0才进行缩放,避免第一次点击就发生放大效果
                    if (lastDistance > 0) {
                        //偏移距离,计算当前和最近一次距离的差
                        float offsetDistance = currentDistance - lastDistance;
                        //如果偏移距离大于缩放距离
                        if (Math.abs(offsetDistance) - scaleDistance > 0) {
                            if (offsetDistance > 0) {
                                //放大图片
                                scaleImageView(1 + scaling);
                            } else if (offsetDistance < 0) {
                                //缩小图片
                                scaleImageView(1 - scaling);
                            }
                        }

                    }
                    lastDistance = currentDistance;

                }

                break;
        }
        return true;

    }

    /**
     * 根据缩放比例缩放图片
     *
     * @param scaling 缩放比例
     */
    private void scaleImageView(float scaling) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) (scaling * imageView.getWidth());
        layoutParams.height = (int) (scaling * imageView.getHeight());
        imageView.setLayoutParams(layoutParams);
    }
}
