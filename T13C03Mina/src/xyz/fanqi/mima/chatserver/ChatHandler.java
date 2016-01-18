package xyz.fanqi.mima.chatserver;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanqi on 16/1/19.
 */
public class ChatHandler extends IoHandlerAdapter {
    List<IoSession> sessions = new ArrayList<>();

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        sessions.add(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        sessions.remove(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        //将接受到得消息转发出去
        for (IoSession  ioSession: sessions) {
            ioSession.write(message);
        }
    }
}
