package xyz.fanqi.changefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fanqi on 15/12/15.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);

        root.findViewById(R.id.btnShowAnotherFragment).setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.enter,R.animator.exit,R.animator.enter,R.animator.exit)
                .addToBackStack("another framgent")
                .replace(R.id.container, new AnotherFragment())
                .commit()) {
        }
    }


}
