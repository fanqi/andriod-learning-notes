package xyz.fanqi.layoutchangeanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private View.OnClickListener btn_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            linearLayout.removeView(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;
            case R.id.action_add:
                addButton();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addButton() {
        Button button = new Button(this);
        button.setText("remove me");
        linearLayout.addView(button);
        //自定义动画
        //linearLayout.setLayoutTransition();
        button.setOnClickListener(btn_onClickListener);
    }
}
