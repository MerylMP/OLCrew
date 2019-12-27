package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.ArrayList;
import java.util.List;

public class ListOLFragmentPresenter implements ListOLMVPInterface.Presenter {

    private ListOLMVPInterface.Model model;
    private ListOLMVPInterface.View view;
    private int currentPage = 0;
    private int totalPages = 1;
    private List<String> genderSelectionList = new ArrayList<>();
    private List<String> professionSelectionList = new ArrayList<>();
    private List<OompaLoompa> olResultsList = new ArrayList<>();
    private List<OompaLoompa> olFiltered = new ArrayList<>();
    private boolean isFilterActive = false;

    private List<String> genderFilter = new ArrayList<>();
    private List<String> professionsFilter = new ArrayList<>();


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

        generateFilterLists(results);

        this.olResultsList.addAll(results);
        this.view.isLoadingInfo(false);
        this.view.showLoading(false);
        this.view.showNoInfoMessage(false);


        if (isFilterActive) {
            applyFilters(this.genderFilter, this.professionsFilter);

        } else {
            this.view.loadOlList(results);
        }
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

    @Override
    public void filterOompaLoompas(List<String> genderFilter, List<String> professionsFilter) {

        this.genderFilter.clear();
        this.genderFilter.addAll(genderFilter);
        this.professionsFilter.clear();
        this.professionsFilter.addAll(professionsFilter);
        applyFilters(this.genderFilter, this.professionsFilter);
    }


    private void generateFilterLists(List<OompaLoompa> results) {
        for (OompaLoompa oompaLoompa : results) {
            if (!genderSelectionList.contains(oompaLoompa.getGender())) {
                genderSelectionList.add(oompaLoompa.getGender());
            }

            if (!professionSelectionList.contains(oompaLoompa.getProfession())) {
                professionSelectionList.add(oompaLoompa.getProfession());
            }
        }
    }


    private void applyFilters(List<String> genderFilter, List<String> professionsFilter) {
        this.olFiltered.clear();

        if (genderFilter.isEmpty() && professionsFilter.isEmpty()) {
            removeFilters();

        } else {

            if (!genderFilter.isEmpty() && professionsFilter.isEmpty()) {
                this.olFiltered.addAll(filterOLByGender(genderFilter));
            }

            if (!professionsFilter.isEmpty() && genderFilter.isEmpty()) {
                this.olFiltered.addAll(filterOLByProfession(professionsFilter));
            }

            if (!genderFilter.isEmpty() && !professionsFilter.isEmpty()) {
                List<OompaLoompa> firstFilterList = new ArrayList<>();
                firstFilterList.addAll(filterOLByGender(genderFilter));

                for (OompaLoompa oompaLoompa : firstFilterList) {
                    if (professionsFilter.contains(oompaLoompa.getProfession())) {
                        this.olFiltered.add(oompaLoompa);
                    }
                }
            }

            this.isFilterActive = true;
            this.view.loadFilteredList(olFiltered);
            this.view.showCleanFiltersButton();
        }
    }


    private List<OompaLoompa> filterOLByGender(List<String> genderFilter) {

        List<OompaLoompa> tempGenderList = new ArrayList<>();

        for (OompaLoompa oompaLoompa : this.olResultsList) {
            if (genderFilter.contains(oompaLoompa.getGender())) {
                tempGenderList.add(oompaLoompa);
            }
        }

        return tempGenderList;
    }

    private List<OompaLoompa> filterOLByProfession(List<String> professionsFilter) {

        List<OompaLoompa> tempProfessionList = new ArrayList<>();
        for (OompaLoompa oompaLoompa : this.olResultsList) {
            if (professionsFilter.contains(oompaLoompa.getProfession())) {
                tempProfessionList.add(oompaLoompa);
            }
        }

        return tempProfessionList;
    }

    @Override
    public List<String> getGenderSelectionList() {
        return this.genderSelectionList;
    }

    @Override
    public List<String> getProfessionSelectionList() {
        return this.professionSelectionList;
    }

    @Override
    public void removeFilters() {
        this.isFilterActive = false;
        this.view.cleanOLList();
        this.view.showFilterButton();
        this.view.loadOlList(this.olResultsList);
    }
}
