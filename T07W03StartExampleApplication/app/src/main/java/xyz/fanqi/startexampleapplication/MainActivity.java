package xyz.fanqi.startexampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartExampleApplication).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent("xyz.fanqi.exampleapplication.intent.action.ExampleApplication"));
                }catch (Exception e){
                    throw new SecurityException("您没有启动Example Application的权限");
                }
            }
        });
    }
}
