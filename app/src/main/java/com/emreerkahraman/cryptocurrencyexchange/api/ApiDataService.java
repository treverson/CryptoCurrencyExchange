package com.emreerkahraman.cryptocurrencyexchange.api;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDataService {

    private Retrofit retrofit;

    private static final String BASE_URL="https://api.coinmarketcap.com/v2/";

    public Retrofit getRetrofit() {
        retrofit= new retrofit2.Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .build();
        return retrofit;
    }
}
