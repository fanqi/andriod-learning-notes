package xyz.fanqi.simpleimagebrowser;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOpenImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.dsgl);//图片资源转换成URI
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
