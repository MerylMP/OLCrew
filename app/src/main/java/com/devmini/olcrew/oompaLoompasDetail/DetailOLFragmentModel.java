package com.devmini.olcrew.oompaLoompasDetail;

import android.util.Log;

import com.devmini.olcrew.R;
import com.devmini.olcrew.modelData.OompaLoompa;
import com.devmini.olcrew.retrofit.OompaLoompasAPI;
import com.devmini.olcrew.retrofit.OompaLoompasClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailOLFragmentModel implements DetailOLMVPInterface.Model {

    private DetailOLMVPInterface.Presenter presenter;
    private OompaLoompasAPI oompaLoompasAPI;


    public DetailOLFragmentModel(DetailOLMVPInterface.Presenter presenter) {
        this.presenter = presenter;
        this.oompaLoompasAPI = OompaLoompasClient.getAPI();
    }


    @Override
    public void getOompaLoompasById(int oompaID) {

        Call<OompaLoompa> call = this.oompaLoompasAPI.getOompaLoompaById(oompaID);
        call.enqueue(new Callback<OompaLoompa>() {
            @Override
            public void onResponse(Call<OompaLoompa> call, Response<OompaLoompa> response) {
                if (!response.isSuccessful()) {
                    Log.d("OompaLoompa_details", "Unsuccesful response. Code: " + response.code());
                    presenter.onFailureResponse(R.string.error_unsuccessfulResponse);
                    return;
                }

                OompaLoompa oompaLoompa = response.body();
                presenter.retrievedOLById(oompaLoompa);
            }

            @Override
            public void onFailure(Call<OompaLoompa> call, Throwable t) {
                Log.d("OompaLoompa_details", "Response failed. " + t.getMessage());
                presenter.onFailureResponse(R.string.error_failureResponse);
            }
        });
    }
}
