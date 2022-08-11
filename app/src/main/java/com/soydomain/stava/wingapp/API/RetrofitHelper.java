package com.soydomain.stava.wingapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper{
    private static final String baseUrl = "http://10.0.2.2/wingsapp/";
    private static Retrofit retrofit;

    public static Retrofit conRetrofit(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
