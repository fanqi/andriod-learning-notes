package xyz.fanqi.locationsharing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements ServiceConnection {
    public LocationClient mLocationClient = null;
    public BDLocationListener myLocationListener = new MyLocationListener();
    public MapView mapView = null;
    LatLng currentLatLng = null;
    private LocationService.Binder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //绑定服务
        bindService(new Intent(this, LocationService.class), this, Context.BIND_AUTO_CREATE);
        //声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        //注册监听函数
        mLocationClient.registerLocationListener(myLocationListener);
        initLocation();
        mLocationClient.start();
        //获取地图控件引用
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.getMap().setMyLocationEnabled(true);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("绑定服务成功");
        binder = (LocationService.Binder) service;
        binder.getService().setCallback(new LocationService.Callback() {
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data",data);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data = msg.getData().getString("data");
            try {
                JSONArray messages = new JSONArray(data);
                markLocation(messages);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }

    private class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            currentLatLng = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
            JSONObject latLng = new JSONObject();
            try {
                latLng.put("latitude", bdLocation.getLatitude());
                latLng.put("longitude", bdLocation.getLongitude());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(binder!=null){
                binder.setData(latLng.toString());
            }
        }
    }


    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(1000);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        mLocationClient.setLocOption(option);
    }

    private void markLocation(JSONArray messages) {

        BaiduMap baiduMap = mapView.getMap();
        baiduMap.clear();

        //设置中心点
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(currentLatLng);
        baiduMap.animateMapStatus(u);


        //依次添加坐标点
        for (int i = 0; i < messages.length(); i++) {
            JSONObject message = null;
            try {
                message = messages.getJSONObject(i);
                if (message.getJSONObject("latLng") == null) continue;
                JSONObject latLng = message.getJSONObject("latLng");
                //定义Maker坐标点
                LatLng point = new LatLng(latLng.getDouble("latitude"), latLng.getDouble("longitude"));
                //构建Marker图标
                BitmapDescriptor bitmap = null;
                switch (message.getInt("sessionId")) {
                    case 1:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
                        break;
                    case 2:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markb);
                        break;
                    case 3:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markc);
                        break;
                    case 4:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markd);
                        break;
                    case 5:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marke);
                        break;
                    case 6:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markf);
                        break;
                    case 7:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markg);
                        break;
                    case 8:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markh);
                        break;
                    case 9:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marki);
                        break;
                    case 10:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_markj);
                        break;
                    default:
                        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
                }
                //构建MarkerOption，用于在地图上添加Marker
                OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
                //在地图上添加Marker，并显示
                baiduMap.addOverlay(option);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

}
