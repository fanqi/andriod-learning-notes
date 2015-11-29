package xyz.fanqi.contentwriter;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by fanqi on 15/11/29.
 */
public class MyProvider extends ContentProvider {
    // 定义一个数据库
    SQLiteDatabase database;

    public static final Uri URI = Uri.parse("content://xyz.fanqi.cp");
    @Override
    public boolean onCreate() {
        // Context.MODE_PRIVATE 数据库只能够被当前类所调用
        database = getContext().openOrCreateDatabase("mycp.db3", Context.MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE tab(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL)");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Cursor cursor = database.query("tab",null,null,null,null,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        database.insert("tab","_id",values);
//        database.close();
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
