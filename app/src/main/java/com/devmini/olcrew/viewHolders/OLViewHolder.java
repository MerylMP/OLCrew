package com.devmini.olcrew.viewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.devmini.olcrew.R;
import com.devmini.olcrew.adapters.OLAdapter;
import com.devmini.olcrew.modelData.OompaLoompa;

public class OLViewHolder extends RecyclerView.ViewHolder {

    private OLAdapter adapter;
    private Context context;
    private ImageView image;
    private TextView firstName;
    private TextView lastName;
    private TextView profession;
    private TextView email;


    public OLViewHolder(@NonNull View itemView, Context context, OLAdapter adapter) {
        super(itemView);
        this.context = context;
        this.adapter = adapter;

        image = itemView.findViewById(R.id.rowListOL_image);
        firstName = itemView.findViewById(R.id.rowListOL_firstName);
        lastName = itemView.findViewById(R.id.rowListOL_lastName);
        profession = itemView.findViewById(R.id.rowListOL_profession);
        email = itemView.findViewById(R.id.rowListOL_email);
    }

    public void bindView(final OompaLoompa oompaLoompa) {

        if (oompaLoompa.getImage().isEmpty()) {
            Glide.with(this.context)
                    .load(R.drawable.olplaceholder)
                    .centerCrop()
                    .placeholder(R.drawable.olplaceholder)
                    .into(image);
        } else {
            Glide.with(this.context)
                    .load(oompaLoompa.getImage())
                    .centerCrop()
                    .placeholder(R.drawable.olplaceholder)
                    .into(image);
        }

        firstName.setText(oompaLoompa.getFirst_name());
        lastName.setText(oompaLoompa.getLast_name());
        profession.setText(oompaLoompa.getProfession());
        email.setText(oompaLoompa.getEmail());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = oompaLoompa.getId();
                adapter.selectOompaLoompa(selectedId);
            }
        });
    }
}
