package com.devmini.olcrew.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmini.olcrew.R;
import com.devmini.olcrew.modelData.OompaLoompa;
import com.devmini.olcrew.viewHolders.OLViewHolder;

import java.util.List;

public class OLAdapter extends RecyclerView.Adapter<OLViewHolder> {

    private List<OompaLoompa> oompaLoompasList;
    private Context context;

    public OLAdapter(Context context, List<OompaLoompa> oompaLoompasList) {
        this.context = context;
        this.oompaLoompasList = oompaLoompasList;
    }


    @NonNull
    @Override
    public OLViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View olView = LayoutInflater.from(this.context).inflate(R.layout.row_list_ol, parent, false);
        OLViewHolder olViewHolder = new OLViewHolder(olView, this.context);
        return olViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OLViewHolder olViewHolder, int position) {
        olViewHolder.bindView(oompaLoompasList.get(position));
    }

    @Override
    public int getItemCount() {
        return oompaLoompasList.size();
    }
}
