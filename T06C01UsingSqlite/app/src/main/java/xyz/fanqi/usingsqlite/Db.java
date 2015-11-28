package xyz.fanqi.usingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Andriod平台本地存储所使用的数据库是SQLite
 * SQLite官方网站:http://sqlite.org/
 * Created by fanqi on 15/11/28.
 */
public class Db extends SQLiteOpenHelper {


    public Db(Context context) {
        // 创建一个名为db,版本号为1的数据库
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建user表
        db.execSQL("CREATE TABLE user(" +
                "name TEXT DEFAULT NONE," +
                "gender TEXT DEFAULT \"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
