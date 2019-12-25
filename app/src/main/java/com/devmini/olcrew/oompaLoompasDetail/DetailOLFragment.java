package com.devmini.olcrew.oompaLoompasDetail;


import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.devmini.olcrew.R;
import com.devmini.olcrew.modelData.OompaLoompa;

public class DetailOLFragment extends Fragment implements DetailOLMVPInterface.View {

    private DetailOLMVPInterface.Presenter presenter;
    private int oompaLoompaId;
    private OompaLoompa oompaLoompa;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        oompaLoompaId = bundle.getInt("oompaSelected");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_ol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new DetailOLFragmentPresenter(this);

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

        this.presenter.getOompaLoompaById(oompaLoompaId);
    }

    @Override
    public void loadOompaLoompa(OompaLoompa oompaLoompa) {

        this.oompaLoompa = oompaLoompa;

        this.firstName.setText(this.oompaLoompa.getFirst_name());
        this.lastName.setText(this.oompaLoompa.getLast_name());
        this.profession.setText(this.oompaLoompa.getProfession());
        this.email.setText(this.oompaLoompa.getEmail());
        this.age.setText(String.format("%s", this.oompaLoompa.getAge()));
        this.height.setText(String.format("%s", this.oompaLoompa.getHeight()));
        this.gender.setText(this.oompaLoompa.getGender());
        this.country.setText(this.oompaLoompa.getCountry());
        this.color.setText(this.oompaLoompa.getFavorite().getColor());
        this.food.setText(this.oompaLoompa.getFavorite().getFood());

        // Formatting description
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.description.setText(Html.fromHtml(oompaLoompa.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            this.description.setText(Html.fromHtml(oompaLoompa.getDescription()));
        }

        // Setting ImageView
        if (oompaLoompa.getImage().isEmpty()) {
            Glide.with(this)
                    .load(R.drawable.olplaceholder)
                    .centerCrop()
                    .placeholder(R.drawable.olplaceholder)
                    .into(this.imageView);
        } else {
            Glide.with(this)
                    .load(oompaLoompa.getImage())
                    .centerCrop()
                    .placeholder(R.drawable.olplaceholder)
                    .into(this.imageView);
        }
    }

    @Override
    public void showError(String error) {
        // TODO improve layout
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
