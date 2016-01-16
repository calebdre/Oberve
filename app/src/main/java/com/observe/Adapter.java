package com.observe;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<String>{
    private List<String> values;
    private Context context;

    public Adapter(Context context, List<String> values) {
        super(context, 0);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = ((Activity)context).getLayoutInflater().inflate(R.layout.adapter_view_item, parent, false);
        ((TextView) v.findViewById(R.id.text)).setText(getItem(position));

        return v;
    }

    @Override
    public int getCount() {
        return values.size();
    }
}
