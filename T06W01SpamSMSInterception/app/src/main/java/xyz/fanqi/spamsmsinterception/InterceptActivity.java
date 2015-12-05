package xyz.fanqi.spamsmsinterception;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class InterceptActivity extends ListActivity {
    private SimpleCursorAdapter simpleCursorAdapter;
    private Db db;
    private SQLiteDatabase dbReader;
    private SQLiteDatabase dbWriter;
    private Cursor interceptCursor;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);

        Intent intent=getIntent();
        type=intent.getStringExtra("type");

        db = new Db(this);
        dbReader = db.getReadableDatabase();
        dbWriter = db.getWritableDatabase();


        simpleCursorAdapter = new SimpleCursorAdapter
                (this, R.layout.intercept_list_cell, null,
                        new String[]{"content"},
                        new int[]{R.id.tvContent});
        setListAdapter(simpleCursorAdapter);
        refreshListView();

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(InterceptActivity.this)
                        .setTitle(getResources().getString(R.string.prompt))
                        .setMessage(getResources().getString(R.string.sure_delete) + "?")
                        .setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Cursor cursor = simpleCursorAdapter.getCursor();
                                cursor.moveToPosition(position);
                                int itemId = cursor.getInt(cursor.getColumnIndex("_id"));
                                dbWriter.delete("intercept", "_id=?", new String[]{itemId + ""});
                                cursor.close();
                                refreshListView();
                            }
                        }).setNegativeButton(getResources().getString(R.string.cancel), null).show();

                return true;
            }
        });
    }

    private void showAddDialog() {
        View view = View.inflate(this, R.layout.dialog_intercept, null);
        final EditText etContent = (EditText) view.findViewById(R.id.etContent);

        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.please_input))
                .setView(view)
                .setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = etContent.getText().toString().trim();
                        if (content.equals("")) {
                            Toast.makeText(InterceptActivity.this,getResources().getString(R.string.not_null),Toast.LENGTH_LONG).show();
                        } else {
                            ContentValues values = new ContentValues();
                            values.put("type", type);
                            values.put("content",content);
                            dbWriter.insert("intercept", null, values);
                            refreshListView();
                        }


                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancel), null)
                .show();
    }

    private void refreshListView(){
        interceptCursor = dbReader.query("intercept", null, "type=?", new String[]{type}, null, null, null);
        simpleCursorAdapter.changeCursor(interceptCursor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        interceptCursor.close();
        dbReader.close();
        dbWriter.close();
        db.close();
    }
}
