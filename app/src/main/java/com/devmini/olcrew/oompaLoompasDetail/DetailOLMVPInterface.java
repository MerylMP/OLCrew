package com.devmini.olcrew.oompaLoompasDetail;

import com.devmini.olcrew.modelData.OompaLoompa;

public interface DetailOLMVPInterface {

    interface View {
        void loadOompaLoompa(OompaLoompa oompaLoompa);

        void showError(int error);
    }

    interface Presenter {
        void getOompaLoompaById(int oompaID);

        void retrievedOLById(OompaLoompa oompaLoompa);

        void onFailureResponse(int error);
    }

    interface Model {
        void getOompaLoompasById(int oompaID);
    }
}
