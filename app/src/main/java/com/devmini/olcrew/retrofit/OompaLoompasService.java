package com.devmini.olcrew.retrofit;

import com.devmini.olcrew.modelData.APIMainResponse;
import com.devmini.olcrew.modelData.OompaLoompa;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OompaLoompasService {

    // GET list of OompaLoompas
    @GET("oompa-loompas")
    Call<APIMainResponse> getOompaLoompas(@Query("page") int pageNumber);

    // GET info from ONE OompaLoompa
    @GET("oompa-loompas/{id}")
    Call<OompaLoompa> getOompaLoompaById(@Path("id") int oompaLoompaId);
}
