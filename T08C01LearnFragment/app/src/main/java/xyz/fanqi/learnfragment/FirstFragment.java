package xyz.fanqi.learnfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fanqi on 15/12/7.
 */
public class FirstFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("First Fragment Create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("First Fragment CreateView");

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btnShowSecondFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null) // 添加到后退栈,点击后退按钮可以退回到第一个Fragment
                        .replace(R.id.container, new SecondFragment())
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("First Fragment Pause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("First Fragment DestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("First Fragment Destroy");
    }
}
