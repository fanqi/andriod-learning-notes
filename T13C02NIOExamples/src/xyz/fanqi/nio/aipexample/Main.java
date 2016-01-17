package xyz.fanqi.nio.aipexample;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * Created by fanqi on 16/1/16.
 */
public class Main {
    String fileName = "aio.txt";

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() throws IOException {
//        write();
        read();
        //主线程休眠1秒,让异步AIO能够读写文件
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void write() throws IOException {
        //如果没有文件,则可以增加
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                new File(fileName).toPath()
                , StandardOpenOption.WRITE
                , StandardOpenOption.CREATE
        );
//        Future<Integer> future = fileChannel.write(ByteBuffer.wrap("Hello Java AIO".getBytes("UTF-8")), 0);
        fileChannel.write(ByteBuffer.wrap("Hello Java AIO".getBytes("UTF-8"))
                , 0
                , null
                , new CompletionHandler<Integer, Object>() {

                    @Override
                    public void completed(Integer result, Object attachment) {

                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("end");
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        exc.printStackTrace();
                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }

    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    void read() throws IOException {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                new File(fileName).toPath(),StandardOpenOption.READ
        );

        fileChannel.read(buffer, 0, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println(new String(buffer.array()).trim());

                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("end");

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
