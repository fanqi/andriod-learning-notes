package xyz.fanqi.rwexternaldata;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etInput;
    TextView tvOutput;
    File sdcard = Environment.getExternalStorageDirectory();
    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.etInput);
        tvOutput = (TextView) findViewById(R.id.tvOutput);

        findViewById(R.id.btnWrite).setOnClickListener(this);
        findViewById(R.id.btnRead).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                writeData();
                break;
            case R.id.btnRead:
                readData();
                break;
        }
    }


    private void writeData() {
        if (!sdcard.exists()) {
            Toast.makeText(this, "当前系统不存在sdcard目录", Toast.LENGTH_SHORT).show();
            return;
        }
        File myfile = new File(sdcard, fileName);
        try {
            myfile.createNewFile();
            Toast.makeText(this, "文件创建成功", Toast.LENGTH_SHORT).show();
            FileOutputStream fos = new FileOutputStream(myfile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(etInput.getText().toString().trim());
            osw.flush();
            fos.flush();
            osw.close();
            fos.close();
            Toast.makeText(this, "文件写入数据成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void readData() {
        File myfile = new File(sdcard, fileName);
        if (myfile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(myfile);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                char[] bytes = new char[fis.available()];
                isr.read(bytes);
                tvOutput.setText(new String(bytes));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
