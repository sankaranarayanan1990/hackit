package com.hackit.sankaa.hackit;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * Created by sankaa on 6/16/2015.
 */
public class FragmentGroup extends Fragment{

    // Groups Tab populate
    GridView groupGrid;
    private ArrayAdapter<String> GridAdapter;
    static final String[] numbers = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    GridView gridView2;

    static final String[] MOBILE_OS = new String[] {
            "Android", "iOS","Windows", "Blackberry" };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragment= inflater.inflate(R.layout.tab_3,container,false);
        groupGrid = (GridView)viewFragment.findViewById(R.id.gridFollow);
        GridAdapter = new ArrayAdapter<String>(this.getActivity(),
                R.layout.grid_item, numbers);
        groupGrid.setAdapter(GridAdapter);
        gridView2 = (GridView) viewFragment.findViewById(R.id.gridAll);

        gridView2.setAdapter(new ImageAdapter(this.getActivity(), MOBILE_OS));



        return viewFragment;
    }
}
