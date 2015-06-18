package com.hackit.sankaa.hackit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sankaa on 6/16/2015.
 */
public class FragmentPageAdapters extends FragmentPagerAdapter{

    private String FragmentComponents[]=new String[]{"Home","Events","Groups"};
    private Context context;
    public FragmentPageAdapters(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int i) {

        if(i==0){

            return (new FragmentHome());
        }else if(i==1){

            return (new FragmentCalendar());
        }else if (i==2){
            return  new FragmentNotification();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentComponents[position];
    }
}
