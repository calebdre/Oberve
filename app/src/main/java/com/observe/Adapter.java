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
    private List<String> values2;
    private Context context;
    private boolean pictures = false;

    public Adapter(Context context, List<String> values) {
        super(context, 0);
        this.context = context;
        this.values = values;
    }

    public Adapter(Context context, List<String> values, List<String> values2) {
        super(context, 0);
        this.context = context;
        this.values = values;
        this.values2 = values2;
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

        if(pictures || values2 != null){
            if(position == 0){
                ((ImageView) v.findViewById(R.id.profile_image)).setImageDrawable(context.getResources().getDrawable(R.drawable.thumbnail, null));
                ((TextView) v.findViewById(R.id.text)).setText("Joe Hill");
            }else{
                Picasso.with(context).load("http://api.randomuser.me/portraits/med/women/" + position + ".jpg").into((ImageView) v.findViewById(R.id.profile_image));
            }
        }

        if(values2 != null){
            ((TextView) v.findViewById(R.id.subtitle)).setText(values2.get(position));
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
