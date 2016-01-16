package com.observe;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.play_btn) View playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.play_btn)
    public void onPlayButtonClick(View v){
        TransitionDrawable transition = (TransitionDrawable) v.getBackground();
        transition.startTransition(1000);
    }

    public void onClickLogin(View view) {
        EditText userName = (EditText) findViewById(R.id.username);
        EditText passWord = (EditText) findViewById(R.id.password);

        Log.i("Login information: ", "Username: " + userName.getText().toString()
                        +"\n" + "Password: " + passWord.getText().toString());

        Toast.makeText(LoginActivity.this, "Logging in . . .", Toast.LENGTH_SHORT).show();
    }
}
