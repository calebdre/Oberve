package com.observe.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.observe.Adapter;
import com.observe.R;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ViewVideosActivity extends AppCompatActivity {

    @Bind(R.id.list) ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_videos);
        ButterKnife.bind(this);
        List<String> names = Arrays.asList("Julia Brooks", "Dorothy Hoffman", "Carol Weaver","Marilyn Meyer");
        List<String> titles = Arrays.asList("Daily Stand up", "Scrum Meeting", "Design Process Peek 1","Coming up with the storyboard");
        list.setAdapter(new Adapter(this, names, titles));
    }

    @OnItemClick(R.id.list)
    public void onListItemClick(){
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("uri", "content://media/external/video/media/45154");
        startActivity(intent);
    }
}