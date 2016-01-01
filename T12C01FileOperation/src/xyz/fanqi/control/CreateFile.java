package xyz.fanqi.control;

import java.io.File;
import java.io.IOException;

/**
 * Created by fanqi on 15/12/30.
 */
public class CreateFile {
    public static void main(String[] args) {
        File file = new File(FileUtil.FILE_NAME);
        //如果文件不存在则创建文件
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件已经创建了...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已经存在...");
            System.out.println("文件名为:" + file.getName());
            System.out.println("文件的绝对路径:" + file.getAbsolutePath());
            System.out.println("文件的相对路径:" + file.getPath());
            System.out.println("文件大小:"+file.length()+"字节");
            System.out.println("文件是否可读:"+file.canRead());
            System.out.println("文件是否可写:"+file.canWrite());
            System.out.println("文件是否隐藏:"+file.isHidden());
            System.out.println("是否是文件:"+file.isFile());
            System.out.println("是否是文件夹:"+file.isDirectory());

        }
    }
}
