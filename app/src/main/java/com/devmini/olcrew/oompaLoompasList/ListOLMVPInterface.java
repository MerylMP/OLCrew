package com.devmini.olcrew.oompaLoompasList;

import com.devmini.olcrew.modelData.OompaLoompa;

import java.util.List;

public interface ListOLMVPInterface {
    interface View {
        void loadOlList(List<OompaLoompa> results);

        void showError(String error);
    }

    interface Presenter {
        void getOompaLoompasList();

        void retrievedOlList(List<OompaLoompa> results);

        void onFailureResponse(String error);
    }

    interface Model {
        void getOompaLoompasList();
    }
}

