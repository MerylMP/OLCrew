package com.devmini.olcrew.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.devmini.olcrew.R;
import com.devmini.olcrew.oompaLoompasDetail.DetailOLFragment;
import com.devmini.olcrew.oompaLoompasList.ListOLFragment;

public class MainActivity extends AppCompatActivity {

    private ListOLFragment listOLFragment = null;
    private DetailOLFragment detailOLFragment = null;

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private View filter;
    private View cleanFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.main_filter_Toolbar);
        setSupportActionBar(toolbar);

        this.toolbarTitle = findViewById(R.id.main_titleLabel);
        this.filter = findViewById(R.id.main_filterButton);
        this.cleanFilters = findViewById(R.id.main_cleanFilterButton);

        this.listOLFragment = new ListOLFragment();
        this.detailOLFragment = new DetailOLFragment();
        changeFragment(listOLFragment);
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.list_container, fragment).addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }

    public void showFilterButton() {
        this.cleanFilters.setVisibility(View.GONE);
        this.filter.setVisibility(View.VISIBLE);
    }

    public void showCleanFiltersButton() {
        this.cleanFilters.setVisibility(View.VISIBLE);
        this.filter.setVisibility(View.GONE);
    }

    public void removeToolbarButtons() {
        this.cleanFilters.setVisibility(View.GONE);
        this.filter.setVisibility(View.GONE);
    }

    public void setToolbarMessage(String message) {
        this.toolbarTitle.setText(message);
    }
}
