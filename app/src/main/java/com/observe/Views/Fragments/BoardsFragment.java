package com.observe.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.observe.Adapter;
import com.observe.R;
import com.observe.Views.ProfessionsActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class BoardsFragment extends Fragment {
    @Bind(R.id.list) ListView boardsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list, container, false);
        ButterKnife.bind(this, view);
        List<String> values = Arrays.asList("Doctor", "Lawyer", "Engineer", "Sports Star", "Entertainer", "Movie Personnel");
        boardsList.setAdapter(new Adapter(getContext(), values));
        return view;
    }

    @OnItemClick(R.id.list)
    public void onBoardItemClick(){
        startActivity(new Intent(getActivity(), ProfessionsActivity.class));
    }
}