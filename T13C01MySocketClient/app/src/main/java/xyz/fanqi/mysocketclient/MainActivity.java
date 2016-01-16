package xyz.fanqi.mysocketclient;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etIP, etContent;
    TextView tvContent;
    Socket socket = null;
    BufferedReader reader;
    BufferedWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        etIP = (EditText) findViewById(R.id.etIP);
        etContent = (EditText) findViewById(R.id.etContent);
        findViewById(R.id.btnConnect).setOnClickListener(this);
        findViewById(R.id.btnSend).setOnClickListener(this);
        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConnect:
                connect();
                break;
            case R.id.btnSend:
                send();
                break;
        }
    }

    private void connect() {
        final String ip = etIP.getText().toString();

        AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {
            @Override
            protected Void doInBackground(Void... arg0) {
                try {
                    socket = new Socket(ip, 12345);
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    publishProgress("@success");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        publishProgress(line);
                    }
                }catch (IOException e) {
                    Toast.makeText(MainActivity.this, "无法建立连接", Toast.LENGTH_SHORT).show();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                if (values[0].equals("@success")) {
                    Toast.makeText(MainActivity.this, "连接成功！", Toast.LENGTH_SHORT).show();
                }
                tvContent.append("别人说：" + values[0] + "\n");
                super.onProgressUpdate(values);
            }
        };
        read.execute();
    }

    private void send() {
        try {
            tvContent.append("我说：" + etContent.getText().toString() + "\n");
            writer.write(etContent.getText().toString() + "\n");
            writer.flush();
            etContent.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
