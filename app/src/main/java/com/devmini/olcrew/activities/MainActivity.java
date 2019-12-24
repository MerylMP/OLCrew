package com.devmini.olcrew.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.devmini.olcrew.R;
import com.devmini.olcrew.oompaLoompasDetail.DetailOLFragment;
import com.devmini.olcrew.oompaLoompasList.ListOLFragment;

public class MainActivity extends AppCompatActivity {

    private ListOLFragment listOLFragment = null;
    private DetailOLFragment detailOLFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOLFragment = new ListOLFragment();
        detailOLFragment = new DetailOLFragment();
        changeFragment(listOLFragment);
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.list_container, fragment).addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }
}
