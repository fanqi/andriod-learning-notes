package xyz.fanqi.chatsocket;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fanqi on 16/1/16.
 */
public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            //创建socket服务器,监听端口为12345
            ServerSocket serverSocket = new ServerSocket(12345);
            //通过循环监听支持多客户端连接
            while (true) {
                //block
                Socket socket = serverSocket.accept();
                //将socket传递给新的线程,使每个连接独立通信
                ChatSocket chatSocket = new ChatSocket(socket);
                chatSocket.start();
                ChatManager.getChatManager().add(chatSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
