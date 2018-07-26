package com.emreerkahraman.cryptocurrencyexchange;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.emreerkahraman.cryptocurrencyexchange.gson.Currency;

import java.util.List;

public class CurrencyListViewModel extends ViewModel {

    private  LiveData<Currency> currencyLiveData=new MutableLiveData<>();
    private CurrencyListRepository currencyListRepository=new CurrencyListRepository();



    public LiveData<Currency> getCurrencyGsonLiveData() {
        if (currencyLiveData==null){
            currencyLiveData=currencyListRepository.getCurrencyList("TRY",6,"id","array");
        }
        return currencyLiveData;
    }
}
