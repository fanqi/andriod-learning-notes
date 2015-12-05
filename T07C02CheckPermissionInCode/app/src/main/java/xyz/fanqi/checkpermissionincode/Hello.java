package xyz.fanqi.checkpermissionincode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by fanqi on 15/12/5.
 */
public class Hello {

    public static final String PERMISSION_SAY_HELLO = "xyz.fanqi.checkpermissionincode.permission.SAY_HELLO";

    public static void sayHello(Context context){
        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

        if(checkResult != PackageManager.PERMISSION_GRANTED){
            throw new SecurityException("执行SayHello方法需要有xyz.fanqi.checkpermissionincode.permission.SAY_HELLO权限");
        }

        System.out.println("Hello,World!");
    }
}
