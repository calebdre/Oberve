package com.observe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.observe.Views.Fragments.BoardsFragment;
import com.observe.Views.Fragments.QuestionsFragment;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public CustomPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BoardsFragment tab1 = new BoardsFragment();
                return tab1;
            case 1:
                QuestionsFragment tab2 = new QuestionsFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
