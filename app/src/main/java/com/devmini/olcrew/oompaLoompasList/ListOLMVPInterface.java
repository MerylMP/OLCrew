package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.List;

public interface ListOLMVPInterface {
    interface View {
        void loadOlList(List<OompaLoompa> results);

        void showLoading(boolean showLoading);

        void isLastPageListed(boolean isLastPageListed);

        void isLoadingInfo(boolean isLoadingInfo);

        void showError(int error);
    }

    interface Presenter {
        void getOompaLoompasList(int page);

        void retrievedOlList(List<OompaLoompa> results);

        void retrieveTotalPages(int totalPages);

        void onFailureResponse(int error);
    }

    interface Model {
        void getOompaLoompasList(int page);
    }
}

