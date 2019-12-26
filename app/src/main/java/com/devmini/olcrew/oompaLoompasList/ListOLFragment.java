package com.devmini.olcrew.oompaLoompasList;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devmini.olcrew.R;
import com.devmini.olcrew.activities.MainActivity;
import com.devmini.olcrew.adapters.OLAdapter;
import com.devmini.olcrew.adapters.PaginationScrollListener;
import com.devmini.olcrew.modelData.OompaLoompa;
import com.devmini.olcrew.utils.RowCardDecorator;

import java.util.ArrayList;
import java.util.List;


public class ListOLFragment extends Fragment implements ListOLMVPInterface.View {

    private List<OompaLoompa> oompaLoompasFinalList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OLAdapter olAdapter;
    private ListOLMVPInterface.Presenter presenter;
    private FrameLayout loadingLayout;

    private static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private boolean isLoading = false;
    private boolean isLastPage = false;


    public ListOLFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new ListOLFragmentPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_ol, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Toolbar
        setToolbarMessage();
        ((MainActivity) getActivity()).showFilterButton();
        ((MainActivity) getActivity()).setFilterAction(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });

        // Loading layout
        this.loadingLayout = view.findViewById(R.id.main_spinnerLoader);

        // RecyclerView
        this.recyclerView = view.findViewById(R.id.main_listOL);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.recyclerView.addItemDecoration(new RowCardDecorator());

        this.olAdapter = new OLAdapter(getContext(), oompaLoompasFinalList, this);
        this.recyclerView.setAdapter(olAdapter);


        this.recyclerView.addOnScrollListener(new PaginationScrollListener() {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                presenter.getOompaLoompasList(currentPage);
            }

            @Override
            protected boolean isLoading() {
                return isLoading;
            }

            @Override
            protected boolean isLastPage() {
                return isLastPage;
            }
        });


        this.presenter.getOompaLoompasList(currentPage);
    }


    @Override
    public void loadOlList(List<OompaLoompa> results) {
        this.oompaLoompasFinalList.addAll(results);
        this.olAdapter.notifyDataSetChanged();
    }

    @Override
    public void isLastPageListed(boolean isLastPageListed) {
        this.isLastPage = isLastPageListed;
    }

    @Override
    public void isLoadingInfo(boolean isLoadingInfo) {
        this.isLoading = isLoadingInfo;
    }

    @Override
    public void showError(int error) {
        // TODO improve layout
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean showLoading) {
        if (showLoading) {
            this.loadingLayout.setVisibility(View.VISIBLE);
        } else {
            this.loadingLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void loadFilteredList(List<OompaLoompa> olFiltered) {
        this.oompaLoompasFinalList.clear();
        this.oompaLoompasFinalList.addAll(olFiltered);
        this.olAdapter.notifyDataSetChanged();
    }

    private void setToolbarMessage() {
        String message = getString(R.string.directory);
        ((MainActivity) getActivity()).setToolbarMessage(message);
    }

    private void showFilterDialog() {

        List<String> genderFilter = new ArrayList<>();
        List<String> professionsFilter = new ArrayList<>();
        genderFilter.add("F");
        professionsFilter.add("Developer");

        this.presenter.filterOompaLoompas(genderFilter, professionsFilter);
    }
}
