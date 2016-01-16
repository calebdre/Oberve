package com.observe;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends ArrayAdapter<String>{
    private List<String> values;
    private Context context;
    private boolean pictures = false;

    public Adapter(Context context, List<String> values) {
        super(context, 0);
        this.context = context;
        this.values = values;
    }

    public Adapter(Context context, List<String> pythonista, boolean b) {
        super(context, 0);
        values = pythonista;
        this.context = context;
        pictures = true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = ((Activity)context).getLayoutInflater().inflate(R.layout.adapter_view_item, parent, false);
        ((TextView) v.findViewById(R.id.text)).setText(getItem(position));

        if(pictures){
            Picasso.with(context).load("http://api.randomuser.me/portraits/med/women/" + position + ".jpg").into((ImageView) v.findViewById(R.id.profile_image));
        }
        return v;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public String getItem(int position) {
        return values.get(position);
    }
}
