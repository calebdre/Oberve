package com.observe.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.observe.Adapter;
import com.observe.R;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfessionsActivity extends AppCompatActivity {

    @Bind(R.id.boards_list) ListView profsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);
        ButterKnife.bind(this);

        profsList.setAdapter(new Adapter(this, Arrays.asList("Web Designer", "Back-End Engineer", "Front-End Engineer", "Pythonista", "Android Developer", "iOS Developer", "Windows Phone Developer", "Industrial Designer")));
    }
}
