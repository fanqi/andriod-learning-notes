package xyz.fanqi.learnlayout;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout root;
    private Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        用代码控制子对象

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        setContentView(root);

//        btnClickMe = new Button(this);
//        btnClickMe.setText("Click Me");
//        root.addView(btnClickMe);

//        root.addView(btnClickMe,300,200);

//        root.addView(btnClickMe, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        root.addView(btnClickMe, lp);


        for (int i = 0; i < 5; i++) {
            btnClickMe = new Button(this);
//            btnClickMe.setText("Click Me");

            btnClickMe.setText("Remove me");

            btnClickMe.setOnClickListener(this);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.weight = 1;
            root.addView(btnClickMe, lp);

//            root.addView(btnClickMe, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        }
    }

    @Override
    public void onClick(View v) {
        root.removeView(v);
    }
}
