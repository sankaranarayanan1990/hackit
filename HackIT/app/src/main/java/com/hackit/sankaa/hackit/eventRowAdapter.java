package com.hackit.sankaa.hackit;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by sankaa on 6/18/2015.
 */
public class EventRowAdapter extends ArrayAdapter<String>  {
    public EventRowAdapter(Context context, String[] values){
        super(context,R.layout.eventrowlayout,values);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.eventrowlayout, parent, false);
        String event=getItem(position);
        String[] eventDet=event.split(":");
        TextView textview1=(TextView) view.findViewById(R.id.eventDate);
        textview1.setTextColor(Color.BLACK);
        textview1.setText(eventDet[0]);
        TextView textview2=(TextView) view.findViewById(R.id.eventRow);
        textview2.setTextColor(Color.BLACK);
        textview2.setText(eventDet[1]);
        TextView textview3=(TextView) view.findViewById(R.id.eventPlace);
        textview3.setTextColor(Color.BLACK);
        textview3.setText(eventDet[2]);

        return view;
    }

}
