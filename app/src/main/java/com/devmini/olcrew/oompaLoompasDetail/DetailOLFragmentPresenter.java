package com.devmini.olcrew.oompaLoompasDetail;

import com.devmini.olcrew.modelData.OompaLoompa;

public class DetailOLFragmentPresenter implements DetailOLMVPInterface.Presenter {

    private DetailOLMVPInterface.Model model;
    private DetailOLMVPInterface.View view;


    public DetailOLFragmentPresenter(DetailOLMVPInterface.View view) {
        this.view = view;
        this.model = new DetailOLFragmentModel(this);
    }

    @Override
    public void getOompaLoompaById(int oompaID) {
        this.model.getOompaLoompasById(oompaID);
    }

    @Override
    public void retrievedOLById(OompaLoompa oompaLoompa) {
        this.view.loadOompaLoompa(oompaLoompa);
    }

    @Override
    public void onFailureResponse(String error) {
        this.view.showError(error);
    }
}
