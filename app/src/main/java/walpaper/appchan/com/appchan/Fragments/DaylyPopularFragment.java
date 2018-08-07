package walpaper.appchan.com.appchan.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import walpaper.appchan.com.appchan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaylyPopularFragment extends Fragment {

    private static DaylyPopularFragment INSTANCE =null;
    public DaylyPopularFragment() {
        // Required empty public constructor
    }

    public static DaylyPopularFragment getInstance(){
        if (INSTANCE ==null)
            INSTANCE = new DaylyPopularFragment();
        return INSTANCE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dayly_popular, container, false);
    }

}
