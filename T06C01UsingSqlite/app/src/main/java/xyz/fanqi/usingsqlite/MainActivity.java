package xyz.fanqi.usingsqlite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    private SimpleCursorAdapter adapter;
    private EditText etName;
    private EditText etGender;
    private Db db;
    private SQLiteDatabase dbRead;
    private SQLiteDatabase dbWrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Db db = new Db(this);
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
//        SQLiteDatabase dbRead = db.getReadableDatabase();
        //在后台输出user信息
//        Cursor userCursor = dbRead.query("user", null, null, null, null, null, null);
//        while (userCursor.moveToNext()){
//            String name = userCursor.getString(userCursor.getColumnIndex("name"));
//            String gender = userCursor.getString(userCursor.getColumnIndex("gender"));
//            System.out.println(String.format("name=%s,gender=%s",name,gender));
//        }
//        userCursor.close();
//        db.close();



        //通过界面操作数据库
        db = new Db(this);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getReadableDatabase();


        adapter =new SimpleCursorAdapter(this,R.layout.user_list_cell,null,new String[]{"name","gender"},new int[]{R.id.tvName,R.id.tvGender});
        setListAdapter(adapter);

        //刷新数据
        refreshListView();

        etName = (EditText) findViewById(R.id.etName);
        etGender = (EditText) findViewById(R.id.etGender);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name",etName.getText().toString());
                cv.put("gender",etGender.getText().toString());
                dbWrite.insert("user",null,cv);
                refreshListView();
            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {
                new AlertDialog.Builder(MainActivity.this).setTitle("提醒").setMessage("您确定要删除该项吗?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Cursor cursor = adapter.getCursor();
                        cursor.moveToPosition(position);
                        int itemId=cursor.getInt(cursor.getColumnIndex("_id"));
                        dbWrite.delete("user","_id=?",new String[]{itemId+""});
                        refreshListView();
                    }
                }).setNegativeButton("取消",null).show();

                return true;
            }
        });


    }

    private void refreshListView(){
        Cursor userCursor = dbRead.query("user", null, null, null, null, null, null);
        adapter.changeCursor(userCursor);
    }
}
