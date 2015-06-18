package com.hackit.sankaa.hackit;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    public static final String File_name = "testpref";
private ActionBarDrawerToggle mDrawerToggle;
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

   private DrawerLayout mDrawerLayout;

    private boolean mUserLeanedDrawer;
    private boolean mFromSavedState;

    private View containerView ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserLeanedDrawer=Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
    if(savedInstanceState!=null){
        mFromSavedState = true;
    }
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.navigation_drawer, container, false);
    }



public void setup(int fragmentid,DrawerLayout drawerlayout, Toolbar toolbar) {

    mDrawerLayout=drawerlayout;
    containerView=getActivity().findViewById(fragmentid);

    mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerlayout,toolbar,R.string.drawer_open,R.string.drawer_close){

        @Override
        public void onDrawerOpened(View drawerView) {

            super.onDrawerOpened(drawerView);
            if(!mUserLeanedDrawer){
                mUserLeanedDrawer=true;
                saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLeanedDrawer+"");
            }
            getActivity().invalidateOptionsMenu();
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            getActivity().invalidateOptionsMenu();
        }
    };
    if(!mUserLeanedDrawer && !mFromSavedState){
        mDrawerLayout.openDrawer(containerView);
    }
    mDrawerLayout.setDrawerListener(mDrawerToggle);
    mDrawerLayout.post(new Runnable() {
        @Override
        public void run() {
            mDrawerToggle.syncState();
        }
    });
}
    public static void saveToPreferences(Context context,String prefname,String prefvalue){
        SharedPreferences sharedPrederences=context.getSharedPreferences(File_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPrederences.edit();
        editor.putString(prefname,prefvalue);
        editor.apply();
    }

    public static String readFromPreferences(Context context,String prefname,String defaultvalue){
        SharedPreferences sharedPrederences=context.getSharedPreferences(File_name,Context.MODE_PRIVATE);
        return sharedPrederences.getString(prefname,defaultvalue);
    }

    }
