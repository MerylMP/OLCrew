package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.List;

public class ListOLFragmentPresenter implements ListOLMVPInterface.Presenter {

    private ListOLMVPInterface.Model model;
    private ListOLMVPInterface.View view;


    public ListOLFragmentPresenter(ListOLMVPInterface.View view) {
        this.model = new ListOLFragmentModel(this);
        this.view = view;
    }

    @Override
    public void getOompaLoompasList() {
        this.model.getOompaLoompasList();
    }

    @Override
    public void retrievedOlList(List<OompaLoompa> results) {
        this.view.loadOlList(results);
    }

    @Override
    public void onFailureResponse(String error) {
        this.view.showError(error);
    }
}
