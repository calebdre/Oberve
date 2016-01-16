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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ProfessionalsActivity  extends AppCompatActivity {

    @Bind(R.id.list)
    ListView profsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(getResources().getColor(R.color.textBg, null));

        profsList.setAdapter(new Adapter(this, Arrays.asList("Julia Brooks", "Dorothy Hoffman", "Carol Weaver","Marilyn Meyer","Karen Obrien", "Nicole Marshall" ,"Madison Gonzales", "Joan Bailey"), true));
    }

    @OnItemClick(R.id.list)
    public void onProfessionalItemClick(){
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
