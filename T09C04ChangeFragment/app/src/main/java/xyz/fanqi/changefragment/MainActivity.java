package xyz.fanqi.changefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //可以支持早期设备，动画效果是传统的视图动画，不支持属性动画
        //getSupportFragmentManager()
        //只支持新的设备，不支持早期设备
        //getFragmentManager()

        getFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
    }


    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}


