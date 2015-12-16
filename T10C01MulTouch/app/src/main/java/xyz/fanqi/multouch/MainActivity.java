package xyz.fanqi.multouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.container);
        imageView = (ImageView) findViewById(R.id.imageView);


        //触摸监听器
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            float currentDistance;
            float lastDistance = -1;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    //按下事件
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("action down");
                        break;
                    //移动事件
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("action move");
                        //得到当前的触摸点的坐标
//                        System.out.println(String.format("x:%f,y:%f", event.getX(), event.getY()));
                        //方法1
                        //imageView.setX(event.getX());
                        //imageView.setY(event.getY());
                        //方法2
//                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
//                        layoutParams.leftMargin = (int) event.getX();
//                        layoutParams.topMargin = (int) event.getY();
//                        imageView.setLayoutParams(layoutParams);
                        //获取触摸点的数量
//                        System.out.println("pointer count:"+event.getPointerCount());
//                        //获取多个触摸点的坐标，触摸点从0开始
//                        if(event.getPointerCount()>=2)
//                            System.out.println(String.format("x1:%f y1:%f;x2:%f y2:%f",event.getX(0),event.getY(0),event.getX(1),event.getY(1)));

                        //缩放图片示例
                        if (event.getPointerCount() >= 2) {
                            float offsetX = event.getX(0) - event.getX(1);
                            float offsetY = event.getY(0) - event.getY(1);

                            currentDistance = (float) Math.sqrt(offsetX * offsetX + offsetY * offsetY);

                            float offsetDistance = currentDistance - lastDistance;
                            //缩放比例
                            float scaling = 1.0f;
                            if (lastDistance > 0) {
                                //理论上是0，实际上设置5可以提升程序的容错能力,距离变化在（-5，5）之间不缩放
                                if (offsetDistance > 5) {
                                    System.out.println("放大");
                                    scaling = 1.1f;
                                } else if (offsetDistance < -5) {
                                    System.out.println("缩小");
                                    scaling = 0.9f;
                                } else {
                                    System.out.println("不变");
                                }
                                //缩放图片
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                                layoutParams.width = (int) (scaling * imageView.getWidth());
                                layoutParams.height = (int) (scaling * imageView.getHeight());
                                imageView.setLayoutParams(layoutParams);
                            }

                            lastDistance = currentDistance;
                        }

                        break;
                    //松开事件
                    case MotionEvent.ACTION_UP:
                        System.out.println("action up");
                        break;
                }
                //三个事件是有依赖关系的
                //如果返回false，表示事件执行不成功,后续事件是不会触发的
                return true;
            }
        });

    }
}
