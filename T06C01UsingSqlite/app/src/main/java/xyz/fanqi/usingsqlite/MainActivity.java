package xyz.fanqi.usingsqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Db db = new Db(this);
        //写入两条数据
//        SQLiteDatabase dbWrite = db.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put("name","小张");
//        cv.put("gender","男");
//        dbWrite.insert("user", null, cv);
//
//        cv = new ContentValues();
//        cv.put("name","小李");
//        cv.put("gender","女");
//        dbWrite.insert("user", null, cv);
//        dbWrite.close();

        //读取数据
        SQLiteDatabase dbRead = db.getReadableDatabase();
        Cursor userCursor = dbRead.query("user", null, null, null, null, null, null);
        while (userCursor.moveToNext()){
            String name = userCursor.getString(userCursor.getColumnIndex("name"));
            String gender = userCursor.getString(userCursor.getColumnIndex("gender"));
            System.out.println(String.format("name=%s,gender=%s",name,gender));
        }
        userCursor.close();
        db.close();
    }
}
