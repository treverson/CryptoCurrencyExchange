package com.emreerkahraman.cryptocurrencyexchange;

import com.emreerkahraman.cryptocurrencyexchange.gson.Currency;


import okhttp3.ResponseBody;
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
