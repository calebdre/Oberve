package com.observe.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.observe.R;

import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }
}
