package xyz.fanqi.spamsmsinterception;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.btnEditKeyword).setOnClickListener(this);
        findViewById(R.id.btnEditNumber).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,InterceptActivity.class);
        switch (v.getId()){
            case R.id.btnEditKeyword:
                intent.putExtra("type","keyword");
                break;
            case R.id.btnEditNumber:
                intent.putExtra("type","number");
                break;
        }
        startActivity(intent);
    }
}
