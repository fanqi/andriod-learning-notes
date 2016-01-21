package xyz.fanqi.locationsharing;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LocationService extends Service {
    public static final String IP = "192.168.31.105";
    public static final int PORT = 8000;
    Socket socket = null;
    BufferedReader reader;
    BufferedWriter writer;

    public LocationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public class Binder extends android.os.Binder {
        public void setData(String data) {
            if(writer!=null) {
                send(data);
            }
        }

        public LocationService getService() {
            return LocationService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        connect();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {
        void onDataChange(String data);
    }

    /**
     * 建立socket连接
     */
    private void connect() {
        AsyncTask<Void, String, Void> read = new AsyncTask<Void, String, Void>() {
            @Override
            protected Void doInBackground(Void... arg0) {
                try {
                    socket = new Socket(IP, PORT);
                    writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    publishProgress("@success");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        publishProgress(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("无法建立连接");
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {

                if (values[0].equals("@success")) {
                    System.out.println("成功建立连接");
                } else {
                    String str = "";
                    if (callback != null) {
                        callback.onDataChange(values[0]);
                    }
                }
                super.onProgressUpdate(values);
            }
        };
        read.execute();
    }

    private void send(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
