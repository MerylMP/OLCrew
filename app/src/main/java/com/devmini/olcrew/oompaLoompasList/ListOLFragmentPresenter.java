package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.List;

public class ListOLFragmentPresenter implements ListOLMVPInterface.Presenter {

    private ListOLMVPInterface.Model model;
    private ListOLMVPInterface.View view;
    private int currentPage = 0;
    private int totalPages = 1;


    public ListOLFragmentPresenter(ListOLMVPInterface.View view) {
        this.model = new ListOLFragmentModel(this);
        this.view = view;
    }

    @Override
    public void getOompaLoompasList(int page) {
        if (this.currentPage != page) {
            this.currentPage = page;
            this.view.showLoading(true);
            this.model.getOompaLoompasList(page);
        } else {
            this.view.showLoading(false);
        }
    }

    @Override
    public void retrievedOlList(List<OompaLoompa> results) {

        if (this.currentPage == this.totalPages) {
            this.view.isLastPageListed(true);
        }

        this.view.loadOlList(results);
        this.view.isLoadingInfo(false);
        this.view.showLoading(false);
        this.view.showNoInfoMessage(false);
    }

    @Override
    public void retrieveTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public void onFailureResponse(int error) {
        this.view.showLoading(false);
        this.view.showNoInfoMessage(true);
        this.view.showError(error);
    }
}
