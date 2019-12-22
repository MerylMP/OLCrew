package com.devmini.olcrew.oompaLoompasDetail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.devmini.olcrew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailOLFragment extends Fragment {

    private ImageView imageView;
    private TextView firstName;
    private TextView lastName;
    private TextView profession;
    private TextView email;
    private TextView age;
    private TextView height;
    private TextView gender;
    private TextView country;
    private TextView color;
    private TextView food;
    private TextView description;


    public DetailOLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_ol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.detailsView_image);
        firstName = view.findViewById(R.id.detailsView_firstName);
        lastName = view.findViewById(R.id.detailsView_lastName);
        profession = view.findViewById(R.id.detailsView_profession);
        email = view.findViewById(R.id.detailsView_email);
        age = view.findViewById(R.id.detailsView_age);
        height = view.findViewById(R.id.detailsView_height);
        gender = view.findViewById(R.id.detailsView_gender);
        country = view.findViewById(R.id.detailsView_country);
        color = view.findViewById(R.id.detailsView_color);
        food = view.findViewById(R.id.detailsView_food);
        description = view.findViewById(R.id.detailsView_description);
    }
}
