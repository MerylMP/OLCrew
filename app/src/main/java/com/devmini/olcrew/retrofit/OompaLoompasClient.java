package com.devmini.olcrew.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OompaLoompasClient {

    private static Retrofit retrofit = null;


    public static OompaLoompasAPI getAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(OompaLoompasAPI.class);
    }
}
