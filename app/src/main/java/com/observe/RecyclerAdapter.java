package com.observe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{
    List<String> names;
    private Context context;

    public RecyclerAdapter(List<String> names, Context context) {
        this.names = names;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view_item, parent, false);
        return  new Holder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.Holder holder, int position) {
        holder.text.setText(names.get(position));
        if(position == 0){
            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.thumbnail, null));
            holder.text.setText("Joe Hill");
        }else{
            Picasso.with(context).load("http://api.randomuser.me/portraits/med/women/" + position + ".jpg").into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public Holder(View itemView) {
            super(itemView);
            text =  (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.profile_image);
            ((ViewGroup) itemView).removeView(itemView.findViewById(R.id.chevron));
        }
    }
}
