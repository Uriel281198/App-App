package walpaper.appchan.com.appchan.Adapater;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import walpaper.appchan.com.appchan.Fragments.CategoryFragment;
import walpaper.appchan.com.appchan.Fragments.DaylyPopularFragment;
import walpaper.appchan.com.appchan.Fragments.RecentsFragment;


/**
 * Created by Uriel on 02/08/2018.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
       if (position==0)
           return CategoryFragment.getInstance();
       else if (position==1)
           return DaylyPopularFragment.getInstance();
       else if (position==2)
           return RecentsFragment.getInstance();
       else return null;


    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Category";

            case 1:
                return "Popular";

            case 2:
                return "Recents";
        }
        return "";
    }
}
