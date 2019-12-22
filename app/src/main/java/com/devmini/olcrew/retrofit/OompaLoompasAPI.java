package com.devmini.olcrew.retrofit;

import com.devmini.olcrew.modelData.APIMainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OompaLoompasAPI {

    // GET list of OompaLoompas
    @GET("oompa-loompas")
    Call<APIMainResponse> getOompaLoompas(@Query("page") int pageNumber);

}
