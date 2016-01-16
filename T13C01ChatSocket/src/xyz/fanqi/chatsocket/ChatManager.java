package xyz.fanqi.chatsocket;

import java.util.Vector;

/**
 * Created by fanqi on 16/1/16.
 */
public class ChatManager {
    //单例化
    private ChatManager(){}
    private static final ChatManager chatManager = new ChatManager();
    public static ChatManager getChatManager(){
        return chatManager;
    }

    Vector<ChatSocket> vector = new Vector<ChatSocket>();

    public void add(ChatSocket chatSocket){
        vector.add(chatSocket);
    }

    public void publish(ChatSocket chatSocket,String out){
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket cs=vector.get(i);
            if(!cs.equals(chatSocket)){
                cs.out(out);
            }
        }

    }
}
