package xyz.fanqi.learnintent;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by fanqi on 15/12/5.
 */
public class MyAty extends Activity {
    public static final String ACTION="xyz.fanqi.learnintent.intent.action.MYATY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
    }
}
