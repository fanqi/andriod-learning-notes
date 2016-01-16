package xyz.fanqi.nio.nioexample;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO Java 1.4开始的
 * Created by fanqi on 16/1/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() throws IOException {
        File file = new File("nio.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        //write(file);
        //read(file);
        readLine(file);
        System.out.println("end");
    }

    void write(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        FileChannel fosChannel = fos.getChannel();
        fosChannel.write(ByteBuffer.wrap("Hello Java NIO".getBytes("UTF-8")));
        fosChannel.close();
        fos.close();
    }

    void read(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileChannel = fis.getChannel();
        //适合分配的字节比文件大的情况
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.position(), "UTF-8"));
    }

    void readLine(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileChannel fileChannel = fis.getChannel();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = 0;
        while ((len = fileChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            //buffer中的flip方法涉及到bufer中的Capacity,Position和Limit三个概念。
            // 其中Capacity在读写模式下都是固定的，就是我们分配的缓冲大小,
            // Position类似于读写指针，表示当前读(写)到什么位置,
            // Limit在写模式下表示最多能写入多少数据，
            // 此时和Capacity相同，在读模式下表示最多能读多少数据，此时和缓存中的实际数据大小相同。
            // 在写模式下调用flip方法，那么limit就设置为了position当前的值(即当前写了多少数据),postion会被置为0，以表示读操作从缓存的头开始读。
            // 也就是说调用flip之后，读写指针指到缓存头部，并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
            bos.write(byteBuffer.array(), 0, byteBuffer.remaining());
            byteBuffer.clear();
        }

        System.out.println(new String(bos.toByteArray(), "UTF-8"));

    }
}
