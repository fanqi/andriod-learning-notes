package xyz.fanqi.lowpowerlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LowPowerReceiver extends BroadcastReceiver {
    public LowPowerReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("Low Power");
        Toast.makeText(context, "Low Power", Toast.LENGTH_LONG).show();
    }
}
