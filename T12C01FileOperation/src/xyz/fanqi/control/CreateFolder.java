package xyz.fanqi.control;

import java.io.File;

/**
 * Created by fanqi on 15/12/30.
 */
public class CreateFolder {
    public static void main(String[] args) {
        File folder=new File(FileUtil.FOLDER_NAME);
        if(!folder.exists()){
            folder.mkdirs();
        }
    }
}
