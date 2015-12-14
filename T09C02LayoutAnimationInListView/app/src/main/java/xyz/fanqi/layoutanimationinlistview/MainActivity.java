package xyz.fanqi.layoutanimationinlistview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    private ArrayAdapter<String> adapter;

    private LayoutAnimationController lac;
    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"hello","android","world"});

        setListAdapter(adapter);

        sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(1000);
        lac = new LayoutAnimationController(sa,0.5f);

        getListView().setLayoutAnimation(lac);
    }
}
