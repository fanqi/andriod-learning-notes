package xyz.fanqi.testmyserversocket.main;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fanqi on 16/1/16.
 */
public class MyServerSocket {
    public static void main(String[] args) {
        try {
            //创建socket服务器,监听端口为12345
            ServerSocket serverSocket = new ServerSocket(12345);
            //阻塞当前的线程
            Socket socket = serverSocket.accept();
            //可通过浏览器访问127.0.0.1:12345,建立连接
            JOptionPane.showMessageDialog(null,"有客户端连接到本机的12345端口");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
