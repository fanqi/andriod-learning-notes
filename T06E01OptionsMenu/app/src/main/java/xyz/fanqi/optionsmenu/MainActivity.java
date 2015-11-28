package xyz.fanqi.optionsmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 方法1:通过xml来定义选项菜单
        // getMenuInflater().inflate(R.menu.main, menu);
        // 方法2:代码动态添加
        // menu.add(groopId,itemId,orderId,title)
        menu.add(1, 100, 1, "菜单1");
        menu.add(1, 101, 2, "菜单2");
        MenuItem item = menu.add(1, 102, 3, "菜单3");
        // 重设标题
        item.setTitle("打开另一个Activity");
        item.setIcon(R.mipmap.ic_launcher);//api>=11的时候,不显示图标
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 方法1
            // case R.id.action_menu_item1:
            // 方法2
            case 100:
                Toast.makeText(this, "点击了菜单1", Toast.LENGTH_SHORT).show();
                break;
            // 方法1
            // case R.id.action_menu_item2:
            case 101:
                Toast.makeText(this, "点击了菜单2", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Intent intent = new Intent(this, AnotherActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
