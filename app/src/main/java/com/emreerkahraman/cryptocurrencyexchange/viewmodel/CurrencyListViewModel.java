package com.emreerkahraman.cryptocurrencyexchange.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.emreerkahraman.cryptocurrencyexchange.CurrencyListRepository;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;

public class CurrencyListViewModel extends ViewModel {

   private CurrencyListRepository repository;

   private final MutableLiveData<String> currencyBase =new MutableLiveData<>();

   public final LiveData <Currency> mCurrencyData = Transformations.switchMap(currencyBase,(mBase)-> repository.getCurrency(mBase));

   public CurrencyListViewModel(){
       repository=new CurrencyListRepository();

   }

   public void setCurrencyBase(String mBase){
       currencyBase.setValue(mBase);
   }





}
