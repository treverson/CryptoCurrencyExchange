package com.emreerkahraman.cryptocurrencyexchange.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.emreerkahraman.cryptocurrencyexchange.CurrencyListRepository;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;

public class CurrencyListViewModel extends ViewModel {

    private CurrencyListRepository currencyListRepository;
    private LiveData<Currency> mCurrencyLiveData;


    public LiveData<Currency> getmCurrencyLiveData() {
        return mCurrencyLiveData;
    }



    public CurrencyListViewModel(){
        currencyListRepository=new CurrencyListRepository();
        mCurrencyLiveData=currencyListRepository.getCurrencyLiveData();
    }



}
