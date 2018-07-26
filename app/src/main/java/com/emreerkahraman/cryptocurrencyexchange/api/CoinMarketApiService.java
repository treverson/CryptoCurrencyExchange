package com.emreerkahraman.cryptocurrencyexchange.api;

import com.emreerkahraman.cryptocurrencyexchange.model.Currency;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinMarketApiService {
    @GET("ticker")
    Call<Currency> getTicker(@Query("convert") String mBase,
                             @Query("limit")Integer mLimit,
                             @Query("sort")String mSort,
                             @Query("structure")String mStructure);


}
