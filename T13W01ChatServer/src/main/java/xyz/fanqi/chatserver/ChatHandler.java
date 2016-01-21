package xyz.fanqi.chatserver;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanqi on 16/1/19.
 */
public class ChatHandler extends IoHandlerAdapter {
    List<IoSession> sessions = new ArrayList<IoSession>();
    JSONArray messages = new JSONArray();

    public void addMessage(long sessionId, String action, JSONObject latLng) {
        JSONObject message = new JSONObject();
        message.put("sessionId", sessionId);
        message.put("action", action);
        message.put("latLng", latLng);
        messages.put(message);
    }

    public void addMessage(long sessionId, String action) {
        JSONObject message = new JSONObject();
        message.put("sessionId", sessionId);
        message.put("action", action);
        messages.put(message);
    }

    public void delMessage(long sessionId) {
        for (int i = 0; i < messages.length(); i++) {
            JSONObject message = (JSONObject) messages.get(i);
            if (message.getLong("sessionId") == sessionId) {
                messages.remove(i);
                break;
            }
        }

    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        sessions.add(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        sessions.remove(session);
        delMessage(session.getId());
        messageBroadcast(session, messages.toString(), "all");
    }


    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        JSONObject latLng = new JSONObject((String) message);
        delMessage(session.getId());
        addMessage(session.getId(), "online", latLng);
        messageBroadcast(session, messages.toString(), "all");
    }

    public void messageBroadcast(IoSession session, String message, String type) {

        for (IoSession ioSession : sessions) {
            if (type.equals("all")) {
                ioSession.write(message);
            } else if (type.equals("others")) {
                if (ioSession.getId() != session.getId())
                    ioSession.write(message);
            }

        }
    }


}
