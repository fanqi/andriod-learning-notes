package xyz.fanqi.playmp4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String fileName = "kqkp.mp4";

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnPlayIntent).setOnClickListener(this);
        findViewById(R.id.btnPlayVideoView).setOnClickListener(this);
        if (!fileExist(fileName)) {
            copyToMobile(fileName);
        }

        videoView = (VideoView) findViewById(R.id.videoView);
    }

    /**
     * 获取文件目录
     *
     * @return 文件路径
     */
    private String getDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/myplayer/";
    }

    /**
     * 判断文件是否存在
     *
     * @param fileName
     * @return 文件是否存在
     */
    private boolean fileExist(String fileName) {
        File file = new File(getDir() + fileName);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 复制文件到扩展存储
     *
     * @param fileName
     */
    private void copyToMobile(final String fileName) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                File dir = new File(getDir());
                if (!dir.exists()) {
                    dir.mkdir();
                }

                InputStream fis = null;
                OutputStream fos = null;
                fis = getResources().openRawResource(R.raw.kqkp);
                File to = new File(getDir(), fileName);
                try {
                    fos = new FileOutputStream(to);
                    byte[] buf = new byte[4096];
                    while ((fis.read(buf)) != -1) {
                        fos.write(buf);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayIntent:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + getDir() + fileName), "video/mp4");
                startActivity(intent);
                break;
            case R.id.btnPlayVideoView:
                videoView.setVideoPath(getDir() + fileName);
                videoView.setMediaController(new MediaController(this));
                videoView.start();
                break;
        }
    }
}
