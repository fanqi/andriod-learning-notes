package xyz.fanqi.simpleimagebrowser;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
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
                //显式Intent
//                Intent intent = new Intent(MainActivity.this,ImageActivity.class);
//                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.dsgl);//图片资源转换成URI

                //隐式Intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dsgl);
                Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,null,null));
                intent.setDataAndType(uri,"image/*");
                startActivity(intent);
            }
        });
    }
}
