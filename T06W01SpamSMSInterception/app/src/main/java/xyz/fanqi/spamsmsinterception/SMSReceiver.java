package xyz.fanqi.spamsmsinterception;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by fanqi on 15/11/29.
 */
public class SMSReceiver extends BroadcastReceiver {
    private Db db;
    private SQLiteDatabase dbReader;
    private SQLiteDatabase dbWriter;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) return;

        String sendNumber = "";//短信号码
        String sendTime = "";//发送时间
        String content = "";//短信内容
        Boolean isSpamSMS = false;//是否是垃圾短信

        Object[] pdus = (Object[]) extras.get("pdus");//太长的短信会被拆分成多条

        for (int i = 0; i < pdus.length; i++) {

            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            sendNumber = smsMessage.getOriginatingAddress();//得到发送号码
            //得到短信发送时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sendTime = sdf.format(new Date(smsMessage.getTimestampMillis()));
            content += smsMessage.getMessageBody();//得到短信内容
        }

        db = new Db(context);
        dbReader = db.getReadableDatabase();

        Cursor interceptCursor = dbReader.query("intercept", null, null, null, null, null, null);
        while (interceptCursor.moveToNext()) {
            String type = interceptCursor.getString(interceptCursor.getColumnIndex("type"));
            String interceptContent = interceptCursor.getString(interceptCursor.getColumnIndex("content"));

            if ((type.equals("number") && sendNumber.equals(interceptContent))
                    || (type.equals("keyword") && content.contains(interceptContent))) {
                isSpamSMS = true;
                break;
            }
        }
        interceptCursor.close();
        dbReader.close();

        if(isSpamSMS){
            dbWriter = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("sendNumber",sendNumber);
            cv.put("sendTime",sendTime);
            cv.put("content",content);
            dbWriter.insert("sms", null, cv);
            abortBroadcast();
            context.sendBroadcast(new Intent("xyz.fanqi.spamsmsinterception.intent.action.SpamSMSReciver"));
            dbWriter.close();
        }

        db.close();
    }

}
