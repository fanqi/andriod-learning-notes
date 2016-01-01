package xyz.fanqi.control;

import java.io.File;

/**
 * Created by fanqi on 15/12/30.
 */
public class DeleteFolder {
    public static void main(String[] args){
        File folder=new File(FileUtil.FOLDER_NAME);
        //如果文件夹存在,则删除文件夹,如果文件夹不是空的,则无法删除
        if(folder.exists()){
            System.out.println("文件删除"+(folder.delete()?"成功":"失败"));
        }
    }
}
