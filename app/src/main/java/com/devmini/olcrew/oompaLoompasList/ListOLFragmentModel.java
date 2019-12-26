package com.devmini.olcrew.oompaLoompasList;

import android.util.Log;

import com.devmini.olcrew.R;
import com.devmini.olcrew.modelData.APIMainResponse;
import com.devmini.olcrew.retrofit.OompaLoompasAPI;
import com.devmini.olcrew.retrofit.OompaLoompasService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOLFragmentModel implements ListOLMVPInterface.Model {

    private ListOLMVPInterface.Presenter presenter;
    private OompaLoompasService oompaLoompasService;


    public ListOLFragmentModel(ListOLMVPInterface.Presenter presenter) {
        this.presenter = presenter;
        this.oompaLoompasService = OompaLoompasAPI.getClient();
    }

    @Override
    public void getOompaLoompasList(int page) {
        Call<APIMainResponse> call = this.oompaLoompasService.getOompaLoompas(page);
        call.enqueue(new Callback<APIMainResponse>() {
            @Override
            public void onResponse(Call<APIMainResponse> call, Response<APIMainResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("OompaLoompas_list", "Unsuccessful response. Code: " + response.code());
                    presenter.onFailureResponse(R.string.error_unsuccessfulResponse);
                    return;
                }

                APIMainResponse apiMainResponse = response.body();
                presenter.retrievedOlList(apiMainResponse.getResults());
            }

            @Override
            public void onFailure(Call<APIMainResponse> call, Throwable t) {
                Log.d("OompaLoompas_list", "Response failed. " + t.getMessage());
                presenter.onFailureResponse(R.string.error_failureResponse);
            }
        });
    }
}
