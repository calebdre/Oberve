package com.observe.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.observe.R;

import org.w3c.dom.Text;

import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        TextView personsName = (TextView) findViewById(R.id.personsName);
        personsName.getText().toString();
        TextView following = (TextView) findViewById(R.id.followingAmount);
        following.getText().toString();
        TextView followers = (TextView) findViewById(R.id.followersAmount);
        followers.getText().toString();

        


    }
}
