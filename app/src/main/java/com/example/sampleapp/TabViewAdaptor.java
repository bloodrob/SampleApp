package com.example.sampleapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabViewAdaptor extends FragmentPagerAdapter {
    private Context myContext;
    private int totalTabs;

    //constructor
    public  TabViewAdaptor(Context myContext, FragmentManager fm, int totalTabs){
        super(fm);
        this.myContext = myContext;
        this.totalTabs = totalTabs;
    }
    @NonNull
    @Override
    //for fragment tabs, get the item
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SampleOne sampleOne = new SampleOne();
                return sampleOne;
            case 1:
                SampleTwo sampleTwo = new SampleTwo();
                return sampleTwo;
            case 2:
                SampleThree sampleThree = new SampleThree();
                return sampleThree;
            case 3:
                SampleFour sampleFour = new SampleFour();
                return sampleFour;
        }
        return new SampleOne();
    }

    //count total tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
