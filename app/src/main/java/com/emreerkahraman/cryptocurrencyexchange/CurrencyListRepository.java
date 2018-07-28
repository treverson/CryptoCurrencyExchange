package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;


import com.emreerkahraman.cryptocurrencyexchange.api.ApiDataService;
import com.emreerkahraman.cryptocurrencyexchange.api.CoinMarketApiService;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import com.emreerkahraman.cryptocurrencyexchange.viewmodel.CurrencyListViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListRepository  {
    private ApiDataService apiDataService;
    private CoinMarketApiService apiService;
    private Call<Currency> call;

    private LiveData<Currency>  currencyLiveData;

    public LiveData<Currency> getCurrencyLiveData() {
        return currencyLiveData;
    }
    public CurrencyListRepository(){
        currencyLiveData=getCurrencyList();
    }






    public LiveData<Currency> getCurrencyList(){
        final MutableLiveData<Currency> data=new MutableLiveData<>();
        apiDataService=new ApiDataService();
        apiService=apiDataService.getRetrofit().create(CoinMarketApiService.class);

        call=apiService.getTicker("TRY",20,"id","array");
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                data.setValue(response.body());



            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

                Log.i("FAİL",":/");

            }
        });
        return data;

    }








}
