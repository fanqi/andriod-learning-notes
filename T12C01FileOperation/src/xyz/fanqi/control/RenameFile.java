package xyz.fanqi.control;

import java.io.File;

/**
 * Created by fanqi on 15/12/30.
 */
public class RenameFile {
    public static void main(String[] args) {
        //先执行CreateFile创建一个文件,然后再执行该方法修改名称,内容不会改变
        File file = new File(FileUtil.FILE_NAME);
        File anotherFile = new File("anoterFile.txt");
        file.renameTo(anotherFile);
        System.out.println("文件已经重命名..."+file.getName());
    }
}