package com.ghiyats.fish.temannelayan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ghiyats.fish.temannelayan.Model.RangerModel;
import com.ghiyats.fish.temannelayan.R;

import java.util.ArrayList;

/**
 * Created by Ghiyats on 6/15/2015.
 */
public class rangerAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<RangerModel> rangers;
    private LayoutInflater inflater;

    public rangerAdapter(ArrayList<RangerModel> rangers, Activity activity) {
        this.rangers = rangers;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return rangers.size();
    }

    @Override
    public Object getItem(int position) {
        return rangers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.ranger_row,null);
        }



        return convertView;
    }
}
