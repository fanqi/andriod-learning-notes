package xyz.fanqi.learnsharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String KEY="MyKey";
    EditText etInput;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.etInput);
        sharedPreferences = getPreferences(Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        findViewById(R.id.btnWrite).setOnClickListener(this);
        findViewById(R.id.btnRead).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWrite:
                editor.putString(KEY, etInput.getText().toString());
                if(editor.commit()){
                    Toast.makeText(this,"数据写入成功",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRead:
                Toast.makeText(this,sharedPreferences.getString(KEY,"当前数据不存在"),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
