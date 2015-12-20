package xyz.fanqi.compass;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView tvOrientation;
    private ImageView ivOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过系统服务得到传感器服务管理器
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //方向传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        //方向
        tvOrientation = (TextView) findViewById(R.id.tvOrientation);
        ivOrientation = (ImageView) findViewById(R.id.ivOrientation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this, sensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ORIENTATION:
                initCompass(event.values[0]);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void initCompass(float orientation) {
        String orientationStr = "正北";
        if (orientation > 22.5f && orientation <= 67.5f) {
            orientationStr = "东北";
        } else if (orientation > 67.5f && orientation <= 112.5f) {
            orientationStr = "正东";
        } else if (orientation > 112.5f && orientation <= 157.5f) {
            orientationStr = "东南";
        } else if (orientation > 157.5f && orientation <= 202.5f) {
            orientationStr = "正南";
        } else if (orientation > 202.5f && orientation <= 247.5f) {
            orientationStr = "西南";
        } else if (orientation > 247.5f && orientation <= 292.5f) {
            orientationStr = "正西";
        } else if (orientation > 292.5f && orientation <= 337.5f) {
            orientationStr = "西北";
        }

        tvOrientation.setText(orientationStr+" "+orientation+"°");

        ivOrientation.animate().rotation(orientation).setDuration(100).start();
    }

}
