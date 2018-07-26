package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.emreerkahraman.cryptocurrencyexchange.gson.Currency;

import java.util.List;

public class CurrencyListViewModel extends ViewModel {

    private  LiveData<Currency> currencyLiveData;
    private CurrencyListRepository currencyListRepository=new CurrencyListRepository();

    public LiveData<Currency> getCurrencyGsonLiveData() {
        if (currencyLiveData==null){
            currencyLiveData=currencyListRepository.getCurrencyList("TRY",6,"id","array");
        }
        return currencyLiveData;
    }
}
