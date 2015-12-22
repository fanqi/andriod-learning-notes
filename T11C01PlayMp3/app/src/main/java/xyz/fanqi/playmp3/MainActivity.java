package xyz.fanqi.playmp3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.BtnPlay).setOnClickListener(this);
        findViewById(R.id.BtnStop).setOnClickListener(this);
        findViewById(R.id.BtnPause).setOnClickListener(this);

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
        }
    }
}
