package xyz.fanqi.readassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnReadAssets).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //字节流
                    InputStream is = getResources().getAssets().open("info.txt");
                    //文本文件需要包装成字符流
                    InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                    BufferedReader bfr = new BufferedReader(isr);
                    String in = "";
                    while ((in = bfr.readLine()) != null) {
                        System.out.println(in);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
