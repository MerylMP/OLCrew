package com.devmini.olcrew.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devmini.olcrew.R;
import com.devmini.olcrew.adapters.OLAdapter;
import com.devmini.olcrew.modelData.OompaLoompa;
import com.devmini.olcrew.utils.RowCardDecorator;

import java.util.ArrayList;
import java.util.List;

public class ListOLFragment extends Fragment {

    private List<OompaLoompa> oompaLoompasList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OLAdapter olAdapter;


    public ListOLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_ol, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.main_listOL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new RowCardDecorator());

        // TODO delete this fake data after api call
        OompaLoompa ol1 = new OompaLoompa();
        ol1.setImage("https://via.placeholder.com/50/FFFF00/000000?Text=WebsiteBuilders.com");
        ol1.setFirst_name("nombre1");
        ol1.setLast_name("apellido1");
        ol1.setProfession("profesion1");
        ol1.setEmail("email1");
        OompaLoompa ol2 = new OompaLoompa();
        ol2.setImage("");
        ol2.setFirst_name("nombre2");
        ol2.setLast_name("apellido2");
        ol2.setProfession("profesion2");
        ol2.setEmail("email2");
        oompaLoompasList.add(ol1);
        oompaLoompasList.add(ol2);

        olAdapter = new OLAdapter(getContext(), oompaLoompasList);
        recyclerView.setAdapter(olAdapter);
    }
}
