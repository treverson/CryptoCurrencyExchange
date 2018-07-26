package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emreerkahraman.cryptocurrencyexchange.gson.Currency;


import java.util.List;


public class CurrencyListFragment extends Fragment  implements LifecycleOwner{


    private RecyclerView recyclerView;
    private CurrencyListAdapter currencyListAdapter;
    private CurrencyListViewModel mViewModel;

    public static CurrencyListFragment newInstance() {
        return new CurrencyListFragment();
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_currency_list,container,false);
        recyclerView=view.findViewById(R.id.recyclerview);

        recyclerView.setAdapter(currencyListAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(CurrencyListViewModel.class);
        mViewModel.getCurrencyGsonLiveData().observe(this, new Observer<Currency>() {
            @Override
            public void onChanged(@Nullable Currency currency) {
                currencyListAdapter.setmCurrencyList(currency.getData());
            }
        });


    }




}
