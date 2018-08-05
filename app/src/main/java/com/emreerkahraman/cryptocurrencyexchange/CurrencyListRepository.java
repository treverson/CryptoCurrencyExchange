package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.emreerkahraman.cryptocurrencyexchange.api.ApiDataService;
import com.emreerkahraman.cryptocurrencyexchange.api.CoinMarketApiService;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyListRepository  {



    public LiveData<Currency> getCurrency(String mBase){
        return getCurrencyList(mBase);
    }


    private LiveData<Currency> getCurrencyList(String mBase){

        final MutableLiveData<Currency> data=new MutableLiveData<>();

        ApiDataService apiDataService=new ApiDataService();

        CoinMarketApiService apiService=apiDataService.getRetrofit().create(CoinMarketApiService.class);

        Call<Currency> call=apiService.getTicker(mBase,20,"id","array");

        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {

                data.postValue(response.body());

            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

                Log.i("FAİL",":/");

            }

        });

        return data;

    }

}
