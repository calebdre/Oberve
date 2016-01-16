package com.observe.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.observe.Adapter;
import com.observe.R;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ProfessionalsActivity  extends AppCompatActivity {

    @Bind(R.id.boards_list)
    ListView profsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boards);
        ButterKnife.bind(this);

        profsList.setAdapter(new Adapter(this, Arrays.asList("Julia Brooks", "Dorothy Hoffman", "Carol Weaver","Marilyn Meyer","Karen Obrien", "Nicole Marshall" ,"Madison Gonzales", "Joan Bailey"), true));
    }

    @OnItemClick(R.id.boards_list)
    public void onProfessionalItemClick(){
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
