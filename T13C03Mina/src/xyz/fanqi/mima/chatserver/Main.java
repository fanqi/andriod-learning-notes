package xyz.fanqi.mima.chatserver;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by fanqi on 16/1/19.
 */
public class Main {
    public static void main(String[] args) {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.setHandler(new ChatHandler());
        try {
            acceptor.bind(new InetSocketAddress(8000));
            System.out.println("server started at port 8000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
