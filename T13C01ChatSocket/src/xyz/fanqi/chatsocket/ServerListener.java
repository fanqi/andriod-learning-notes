package xyz.fanqi.chatsocket;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fanqi on 16/1/16.
 */
public class ServerListener extends Thread{
    @Override
    public void run() {
        try {
            //创建socket服务器,监听端口为12345
            ServerSocket serverSocket = new ServerSocket(12345);
            //通过循环监听支持多客户端连接
            while (true){
                //阻塞当前的线程
                Socket socket = serverSocket.accept();
                //可通过浏览器访问127.0.0.1:12345,建立连接
                JOptionPane.showMessageDialog(null,"有客户端连接到本机的12345端口");
                //将socket传递给新的线程,使每个连接独立通信
                new ChatSocket(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
