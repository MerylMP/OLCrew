package com.devmini.olcrew.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmini.olcrew.R;
import com.devmini.olcrew.activities.MainActivity;
import com.devmini.olcrew.modelData.OompaLoompa;
import com.devmini.olcrew.oompaLoompasDetail.DetailOLFragment;
import com.devmini.olcrew.oompaLoompasList.ListOLFragment;
import com.devmini.olcrew.viewHolders.OLViewHolder;

import java.util.List;

public class OLAdapter extends RecyclerView.Adapter<OLViewHolder> {

    private ListOLFragment listOLFragment;
    private List<OompaLoompa> oompaLoompasList;
    private Context context;

    public OLAdapter(Context context, List<OompaLoompa> oompaLoompasList, ListOLFragment listOLFragment) {
        this.context = context;
        this.oompaLoompasList = oompaLoompasList;
        this.listOLFragment = listOLFragment;
    }


    @NonNull
    @Override
    public OLViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View olView = LayoutInflater.from(this.context).inflate(R.layout.row_list_ol, parent, false);
        OLViewHolder olViewHolder = new OLViewHolder(olView, this.context, this);
        return olViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OLViewHolder olViewHolder, final int position) {
        olViewHolder.bindView(this.oompaLoompasList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.oompaLoompasList.size();
    }


    public void selectOompaLoompa(int selectedId) {

        if (selectedId > 0) {

            Bundle bundle = new Bundle();
            bundle.putInt("oompaSelected", selectedId);

            DetailOLFragment detailOLFragment = new DetailOLFragment();
            detailOLFragment.setArguments(bundle);
            ((MainActivity) this.listOLFragment.getActivity()).changeFragment(detailOLFragment);
        }
    }
}
