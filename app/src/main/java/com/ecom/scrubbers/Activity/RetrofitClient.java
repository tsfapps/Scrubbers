package com.ecom.scrubbers.Activity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BaseUrl = "http://siguientesoftwares.in/";


    private static RetrofitClient mInstance;
    private Retrofit retrofit;


    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {

        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }


    public Api getApi() {

        return retrofit.create(Api.class);
    }

}
