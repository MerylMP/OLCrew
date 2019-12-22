package com.devmini.olcrew.oompaLoompasList;

import android.util.Log;

import com.devmini.olcrew.modelData.APIMainResponse;
import com.devmini.olcrew.retrofit.OompaLoompasAPI;
import com.devmini.olcrew.retrofit.OompaLoompasClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOLFragmentModel implements ListOLMVPInterface.Model {

    private ListOLMVPInterface.Presenter presenter;
    private static final int PAGENUMBER = 1;
    private OompaLoompasAPI oompaLoompasAPI;


    public ListOLFragmentModel(ListOLMVPInterface.Presenter presenter) {
        this.presenter = presenter;
        oompaLoompasAPI = OompaLoompasClient.getAPI();
    }

    @Override
    public void getOompaLoompasList() {
        Call<APIMainResponse> call = oompaLoompasAPI.getOompaLoompas(PAGENUMBER);
        call.enqueue(new Callback<APIMainResponse>() {
            @Override
            public void onResponse(Call<APIMainResponse> call, Response<APIMainResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("OompaLoompas_list", "Unsuccessful response. Code: " + response.code());
                    presenter.onFailureResponse("Error al recuperar la información");
                    return;
                }

                APIMainResponse apiMainResponse = response.body();
                presenter.retrievedOlList(apiMainResponse.getResults());
            }

            @Override
            public void onFailure(Call<APIMainResponse> call, Throwable t) {
                Log.d("OompaLoompas_list", "Response failed. " + t.getMessage());
                presenter.onFailureResponse("Error en la conexión con el servidor");
            }
        });
    }
}
