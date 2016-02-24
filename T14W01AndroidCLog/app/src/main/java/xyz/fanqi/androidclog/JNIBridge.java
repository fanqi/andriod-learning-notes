package xyz.fanqi.androidclog;

/**
 * Created by fanqi on 16/2/24.
 */
public class JNIBridge {
    public native static void logI(String msg);
    static {
        System.loadLibrary("androidclog");
    }
}
