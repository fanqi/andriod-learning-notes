package xyz.fanqi.hellojni;

/**
 * Created by fanqi on 16/2/14.
 */
public class JNIBridge {
    public static native String getString();
    static {
        System.loadLibrary("hellojni");
    }
}
