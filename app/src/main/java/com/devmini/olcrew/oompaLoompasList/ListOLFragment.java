package com.devmini.olcrew.oompaLoompasList;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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


public class ListOLFragment extends Fragment implements ListOLMVPInterface.View {

    private List<OompaLoompa> oompaLoompasFinalList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OLAdapter olAdapter;
    private ListOLMVPInterface.Presenter presenter;


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

        presenter = new ListOLFragmentPresenter(this);

        // RecyclerView
        recyclerView = view.findViewById(R.id.main_listOL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new RowCardDecorator());

        olAdapter = new OLAdapter(getContext(), oompaLoompasFinalList);
        recyclerView.setAdapter(olAdapter);

        presenter.getOompaLoompasList();
    }


    @Override
    public void loadOlList(List<OompaLoompa> results) {
        this.oompaLoompasFinalList.addAll(results);
        olAdapter.notifyDataSetChanged();
    }


    @Override
    public void showError(String error) {
        // TODO improve layout
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
