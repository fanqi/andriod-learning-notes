package xyz.fanqi.chatsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        in();
    }

    public void out(String out) {
        try {
            socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void in() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), "UTF-8")
            );
            String line = null;
            while ((line = br.readLine()) != null) {
                ChatManager.getChatManager().publish(this, line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
