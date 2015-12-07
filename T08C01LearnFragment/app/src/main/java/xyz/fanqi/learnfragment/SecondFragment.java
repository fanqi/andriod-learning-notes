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
public class SecondFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Second Fragment Create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("Second Fragment CreateView");
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        view.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Second Fragment Pause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Second Fragment DestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Second Fragment Destroy");
    }
}
