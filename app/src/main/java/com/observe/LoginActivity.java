package com.observe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {
        EditText userName = (EditText) findViewById(R.id.username);
        EditText passWord = (EditText) findViewById(R.id.password);

        Log.i("Login information: ", "Username: " + userName.getText().toString()
                        +"\n" + "Password: " + passWord.getText().toString());

        Toast.makeText(LoginActivity.this, "Logging in . . .", Toast.LENGTH_SHORT).show();
    }

    public void onClickSignUp(View view) {
        Intent intent = new Intent(this, signup_activity.class);
        startActivity(intent);
    }
}
