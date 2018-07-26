package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;


import com.emreerkahraman.cryptocurrencyexchange.gson.Currency;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListRepository  {
    private ApiDataService apiDataService;
    private CoinMarketApiService apiService;
    private Call<Currency> call;



    public LiveData<Currency> getCurrencyList(final String mBase, Integer mLimit, String mSort, String mStructure){
        final MutableLiveData<Currency> data=new MutableLiveData<>();
        apiDataService=new ApiDataService();
        apiService=apiDataService.getRetrofit().create(CoinMarketApiService.class);

        call=apiService.getTicker(mBase,mLimit,mSort,mStructure);
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {


                Currency currency=response.body();
                data.postValue(currency);
                for (int i=0;i<currency.getData().size();i++){
                    Log.i("DATAS" ,currency.getData().get(i).getName()+" price :"+currency.getData().get(i).getQuotes().getBASE().getPrice());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

                Log.i("FAİL",":/");

            }
        });
        return data;

    }



}
