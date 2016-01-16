package xyz.fanqi.nio.ioexample;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * Created by fanqi on 16/1/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
//        write(file);
//        read(file);
        readLine(file);
        System.out.println("end");
    }

    private static void write(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("Hello Java IO".getBytes("UTF-8"));
        fos.close();
    }

    private static void read(File file) throws IOException {
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];
            /*for (int len = 0; len != -1; len = fis.read(buffer)) {
                bos.write(buffer, 0, len);
            }*/
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            bos.close();
            fis.close();
            System.out.println(new String(bos.toByteArray(), "UTF-8"));
        }

    }

    public static void readLine(File file) throws IOException {
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            fis.close();
            System.out.println(sb.toString());

        }

    }
}
