package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.List;

public interface ListOLMVPInterface {
    interface View {
        void loadOlList(List<OompaLoompa> results);

        void showError(int error);

        void showLoading(boolean showLoading);
    }

    interface Presenter {
        void getOompaLoompasList();

        void retrievedOlList(List<OompaLoompa> results);

        void onFailureResponse(int error);
    }

    interface Model {
        void getOompaLoompasList();
    }
}

