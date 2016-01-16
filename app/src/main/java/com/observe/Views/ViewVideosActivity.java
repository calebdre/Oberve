package com.observe.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
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
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(getResources().getColor(R.color.textBg, null));
        List<String> names = Arrays.asList("Julia Brooks", "Dorothy Hoffman", "Carol Weaver","Marilyn Meyer");
        List<String> titles = Arrays.asList("Daily Stand up", "Scrum Meeting", "Design Process Peek 1","Coming up with the storyboard");
        list.setAdapter(new Adapter(this, names, titles));
    }

    @OnItemClick(R.id.list)
    public void onListItemClick(){
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("uri", "content://media/external/video/media/45159");
        startActivity(intent);
    }
}