package xyz.fanqi.mima;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by fanqi on 16/1/18.
 */
public class Main {
    public static void main(String[] args) {
        // NIO Socket接收器
        NioSocketAcceptor acceptor = new NioSocketAcceptor();

        // 通过滤镜链设置滤镜
        // TextLineCodec,把客户端传过来的数据分成一行一行的
        acceptor.getFilterChain().addLast("textLineCodec",
                new ProtocolCodecFilter(
                        new TextLineCodecFactory()
                )
        );

        //自定义滤镜
        acceptor.getFilterChain().addLast("StringFilter", new StringFilter());

        //处理器
        acceptor.setHandler(new SocketHandler());
        try {
            //端口
            acceptor.bind(new InetSocketAddress(8000));
            System.out.println("服务已经启动,监听端口为8000...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
