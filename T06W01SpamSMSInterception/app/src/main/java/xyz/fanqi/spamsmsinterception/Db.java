package xyz.fanqi.spamsmsinterception;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fanqi on 15/11/28.
 */
public class Db extends SQLiteOpenHelper {


    public Db(Context context) {
        // 创建一个名为spamSMS垃圾短信,版本号为1的数据库
        super(context, "spamSms", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建sms短信表
        db.execSQL("CREATE TABLE sms(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sendNumber TEXT DEFAULT NONE," +
                "sendTime TEXT DEFAULT NONE," +
                "content TEXT DEFAULT NONE)");

        //创建屏蔽表,type分为number和keyword
        db.execSQL("CREATE TABLE intercept(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "type TEXT DEFAULT NONE," +
                "content TEXT DEFAULT NONE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
