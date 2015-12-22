package xyz.fanqi.playmp3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer = null;
    String fileName = "dwjwlxs.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnPlay).setOnClickListener(this);
        findViewById(R.id.BtnStop).setOnClickListener(this);
        findViewById(R.id.BtnPause).setOnClickListener(this);
        findViewById(R.id.BtnPlayIntent).setOnClickListener(this);
        findViewById(R.id.BtnPlayMediaPlayer).setOnClickListener(this);

        if (!fileExist(fileName)) {
            copyToMobile(fileName);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnPlay://开始播放
                if (mediaPlayer == null) {//从头播放
                    mediaPlayer = MediaPlayer.create(this, R.raw.dwjwlxs);
                    mediaPlayer.start();
                } else if (!mediaPlayer.isPlaying()) {//继续播放
                    mediaPlayer.start();
                }
                break;
            case R.id.BtnStop://停止播放
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                break;
            case R.id.BtnPause://暂停播放
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
            case R.id.BtnPlayIntent://使用系统播放程序进行播放
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + getDir() + fileName), "audio/mp3");
                startActivity(intent);
                break;
            case R.id.BtnPlayMediaPlayer://使用MediaPlayer进行播放
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(getDir() + fileName);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        }
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
                fis = getResources().openRawResource(R.raw.dwjwlxs);
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
}
