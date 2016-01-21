package xyz.fanqi.chatserver;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by fanqi on 16/1/19.
 */
public class Main {
    public static void main(String[] args) {
        //新建NIO Socket 接收器
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        //设置字符串滤镜
        // TextLineCodec,把客户端传过来的数据分成一行一行的
        acceptor.getFilterChain().addLast("textLineCodec",
                new ProtocolCodecFilter(
                        new TextLineCodecFactory()
                )
        );
        //设置处理器
        acceptor.setHandler(new ChatHandler());
        try {
            //绑定端口8000
            acceptor.bind(new InetSocketAddress(8000));
            System.out.println("chat server running on port 8000.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
