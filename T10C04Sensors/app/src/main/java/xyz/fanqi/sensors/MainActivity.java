package xyz.fanqi.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //获取当前手机所有的传感器
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        System.out.println("所有的传感器:");
//        for (Sensor sensor : sensorList) {
//            System.out.println(sensor.getName());
//        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_PROXIMITY:
                System.out.println(event.values[0]);//通过输出的数据可以判断前方是否有障碍物
                break;
            case Sensor.TYPE_ACCELEROMETER://可以获取三个值,xyz三个方向的
                System.out.format("x:%f,y:%f,z:%f\n", event.values[0], event.values[1], event.values[2]);
                break;
            case Sensor.TYPE_ORIENTATION:
                System.out.format("%f\n",event.values[0]);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        //距离传感器,一般在手机上方
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        //sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //加速度传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //指南针传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //可以注销所有的传感器监听器,也可以注销特定的传感器监听器
        sensorManager.unregisterListener(this);
    }
}
