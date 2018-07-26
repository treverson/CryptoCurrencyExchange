package com.emreerkahraman.cryptocurrencyexchange.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.emreerkahraman.cryptocurrencyexchange.CurrencyListRepository;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;

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
