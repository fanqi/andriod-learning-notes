package xyz.fanqi.lockscreen;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DevicePolicyManager devicePolicyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        findViewById(R.id.btnRegDeviceAdmin).setOnClickListener(this);
        findViewById(R.id.btnUnRegDeviceAdmin).setOnClickListener(this);
        findViewById(R.id.btnLockScreen).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegDeviceAdmin:
                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,new ComponentName(this,DeviceManagerBc.class));
                startActivity(intent);
                break;
            case R.id.btnUnRegDeviceAdmin:
                devicePolicyManager.removeActiveAdmin(new ComponentName(this,DeviceManagerBc.class));
                break;
            case R.id.btnLockScreen:
                devicePolicyManager.lockNow();
                break;
            default:
                break;
        }
    }
}
