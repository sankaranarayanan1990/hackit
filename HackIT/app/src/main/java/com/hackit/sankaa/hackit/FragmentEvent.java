package com.hackit.sankaa.hackit;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by sankaa on 6/16/2015.
 */
public class FragmentEvent extends Fragment{
    public String[] eventDetails=new String[]{"12-March:No:Event1@ 2pm Dont Miss it:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1 :Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place","12-March:No:Event1:Place"};
    ListAdapter eventListAdapter=null;
    ListView eventListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragment = inflater.inflate(R.layout.tab_2, container, false);
        getData();
        eventListAdapter = new EventRowAdapter(this.getActivity().getApplicationContext(), eventDetails);
        eventListView = (ListView) viewFragment.findViewById(R.id.eventListView);
        eventListView.setAdapter(eventListAdapter);
        return viewFragment;
    }



    private void getData() {

        // placeholder to fill in the Event Date time and Detail of the event
    }



}
