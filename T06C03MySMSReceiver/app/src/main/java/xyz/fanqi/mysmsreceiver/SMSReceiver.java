package xyz.fanqi.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by fanqi on 15/11/29.
 */
public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //System.out.println("短信已经接收到了");
        Bundle extras = intent.getExtras();
        if (extras == null) return;
        Object[] pdus = (Object[]) extras.get("pdus");//太长的短信会被拆分成多条

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String fromAddress = smsMessage.getOriginatingAddress();//得到发送号码
            String messageBody = smsMessage.getMessageBody();//短信内容

            System.out.format("发送者:%s,信息内容:%s\n", fromAddress, messageBody);
        }
    }
}
