package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.emreerkahraman.cryptocurrencyexchange.gson.CurrencyGson;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListRepository  {
    private ApiDataService apiDataService;
    private CoinMarketApiService apiService;
    private Call<CurrencyGson> call;



    public LiveData<CurrencyGson> getCurrencyList(final String mBase, Integer mLimit, String mSort, String mStructure){
        final MutableLiveData<CurrencyGson> data=new MutableLiveData<>();
        apiDataService=new ApiDataService();
        apiService=apiDataService.getRetrofit().create(CoinMarketApiService.class);

        call=apiService.getTicker(mBase,mLimit,mSort,mStructure);
        call.enqueue(new Callback<CurrencyGson>() {
            @Override
            public void onResponse(Call<CurrencyGson> call, Response<CurrencyGson> response) {


                CurrencyGson currencyGson=response.body();
                data.postValue(currencyGson);
                for (int i=0;i<currencyGson.getData().size();i++){
                    Log.i("DATAS" ,currencyGson.getData().get(i).getName()+" price :"+currencyGson.getData().get(i).getQuotes().getBASE().getPrice());
                }
            }

            @Override
            public void onFailure(Call<CurrencyGson> call, Throwable t) {

                Log.i("FAİL",":/");

            }
        });
        return data;

    }



}
