package xyz.fanqi.contentwriter;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });
    }

    public void write() {
        ContentValues values = new ContentValues();
        String[] nameArray = new String[]{"java","python","swift","c#"};
        for(String name : nameArray){
            values.put("name", name);
            getContentResolver().insert(MyProvider.URI, values);
        }
    }
}
