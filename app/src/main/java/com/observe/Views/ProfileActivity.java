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

public class ProfileActivity extends AppCompatActivity{

    @Bind(R.id.list) ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        List<String> names = Arrays.asList("Scrum meeting", "Storyboarding on iOS");
        list.setAdapter(new Adapter(this, names));
    }

    @OnItemClick(R.id.list)
    public void onListItemClick(){
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("uri", "content://media/external/video/media/45154");
        startActivity(intent);
    }
}
