package xyz.fanqi.mima;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by fanqi on 16/1/18.
 */
public class SocketHandler extends IoHandlerAdapter {
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        System.out.println("new session created");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);

        //默认
        /*IoBuffer ioBuffer = (IoBuffer) message;
        String msg = new String(ioBuffer.array(),"UTF-8").trim();
        System.out.println("message received:"+msg);*/

        //TextLineCodec处理之后
        String line = (String) message;
        System.out.println("message received:" + line);
        if (line.equals("quit")) {
            session.close(true);
        }

    }
}
