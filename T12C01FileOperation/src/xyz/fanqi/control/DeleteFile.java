package xyz.fanqi.control;

import java.io.File;

/**
 * Created by fanqi on 15/12/30.
 */
public class DeleteFile {
    public static void main(String[] args){
        File file=new File(FileUtil.FILE_NAME);
        //如果文件存在,则删除文件
        if(file.exists()){
            file.delete();
            System.out.println("文件被删除了...");
        }
    }
}
