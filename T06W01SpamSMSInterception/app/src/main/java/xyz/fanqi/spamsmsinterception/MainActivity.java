package xyz.fanqi.spamsmsinterception;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    private SimpleCursorAdapter simpleCursorAdapter;
    private Db db;
    private SQLiteDatabase dbRead;
    private SQLiteDatabase dbWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        db = new Db(this);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();

        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.sms_list_cell, null,
                new String[]{"sendNumber", "sendTime", "content"},
                new int[]{R.id.tvSendNumber, R.id.tvSendTime, R.id.tvContent});
        setListAdapter(simpleCursorAdapter);
        refreshListView();

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(MainActivity.this).setTitle(getResources().getString(R.string.prompt))
                        .setMessage(getResources().getString(R.string.sure_delete) + "?")
                        .setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Cursor cursor = simpleCursorAdapter.getCursor();
                        cursor.moveToPosition(position);
                        int itemId = cursor.getInt(cursor.getColumnIndex("_id"));
                        dbWrite.delete("sms", "_id=?", new String[]{itemId + ""});
                        refreshListView();
                    }
                }).setNegativeButton(getResources().getString(R.string.cancel), null).show();

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, getResources().getString(R.string.settings));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshListView() {
        Cursor userCursor = dbRead.query("sms", null, null, null, null, null, null);
        simpleCursorAdapter.changeCursor(userCursor);
    }
}
