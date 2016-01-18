package xyz.fanqi.mima;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by fanqi on 16/1/19.
 */
public class StringFilter extends IoFilterAdapter {
    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        super.messageReceived(nextFilter, session, message);

        String line = (String) message;
        System.out.println("String Filter:"+line);
    }
}
