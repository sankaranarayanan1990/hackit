package com.hackit.sankaa.hackit;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hackit.sankaa.hackit.Slide.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Arrays;


public class MainPage extends FragmentActivity {
    private ListView drawerList;
    private ArrayAdapter<String> listAdapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //Navigation Drawer
        drawerList = (ListView) findViewById(R.id.drawer_list);
        String[] Ditems = new String[]{"xyz@cisco.com","Settings","About","Contact"};
        ArrayList<String> drawerItems = new ArrayList<String>();
        drawerItems.addAll(Arrays.asList(Ditems));
        listAdapter = new ArrayAdapter<String>(this,R.layout.simplerow,drawerItems);
        drawerList.setAdapter(listAdapter);



        //Setting view Pager and Sliding Layout
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPageAdapters(getSupportFragmentManager(), MainPage.this));
        SlidingTabLayout slidingTabLayout=(SlidingTabLayout)findViewById(R.id.slidingTabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

        //Title of Toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.toolbar_title);




        NavigationDrawerFragment NavBarFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        NavBarFragment.setup(R.id.navigation_drawer,(DrawerLayout)findViewById(R.id.drawerlayout),toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
