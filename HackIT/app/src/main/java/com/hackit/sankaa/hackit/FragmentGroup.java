package com.hackit.sankaa.hackit;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sankaa on 6/16/2015.
 */
public class FragmentGroup extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragment= inflater.inflate(R.layout.tab_3,container,false);
        return viewFragment;
    }
}
