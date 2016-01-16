package xyz.fanqi.chatsocket;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by fanqi on 16/1/16.
 */
public class ChatSocket extends Thread {
    Socket socket;
    public ChatSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int count = 0;
        while (true){
            count++;
            out("loop:"+count+"\n");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
