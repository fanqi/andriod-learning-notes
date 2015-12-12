package xyz.fanqi.addcards;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(rootLayout);

        for (int i = 1; i <= 5; i++) {
            LinearLayout childLayout = new LinearLayout(this);
            LinearLayout.LayoutParams childLayoutLp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            childLayoutLp.weight = 1;
            childLayout.setOrientation(LinearLayout.HORIZONTAL);

            rootLayout.addView(childLayout, childLayoutLp);
            for (int j = 1; j <= 4; j++) {
                TextView tv = new TextView(this);
                tv.setText(String.valueOf((i - 1) * 4 + j));
                tv.setBackgroundColor(Color.RED);
                tv.setGravity(Gravity.CENTER);//设置TextView文字居中
                tv.setTextSize(30);
                LinearLayout.LayoutParams tvLp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                tvLp.weight = 1;
                tvLp.setMargins(16, 16, 16, 16);//设置边距(左上右下)
                childLayout.addView(tv, tvLp);
            }
        }

    }
}
