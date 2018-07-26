package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.emreerkahraman.cryptocurrencyexchange.gson.CurrencyGson;

import java.util.List;

public class CurrencyListViewModel extends ViewModel {

    private  LiveData<CurrencyGson> currencyGsonLiveData;
    private CurrencyListRepository currencyListRepository=new CurrencyListRepository();

    public LiveData<CurrencyGson> getCurrencyGsonLiveData() {
        if (currencyGsonLiveData==null){
            currencyGsonLiveData=currencyListRepository.getCurrencyList("TRY",6,"id","array");
        }
        return currencyGsonLiveData;
    }
}
