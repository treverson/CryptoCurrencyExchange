package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import com.emreerkahraman.cryptocurrencyexchange.viewmodel.CurrencyListViewModel;


public class CurrencyListFragment extends Fragment  implements LifecycleOwner{


    private DividerItemDecoration dividerItemDecoration;
    private CurrencyListViewModel currencyListViewModel;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CurrencyListAdapter currencyListAdapter;

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
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);






        recyclerView.setAdapter(currencyListAdapter);





        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        currencyListViewModel=ViewModelProviders.of(this).get(CurrencyListViewModel.class);
        currencyListViewModel.getmCurrencyLiveData().observe(this, new Observer<Currency>() {
            @Override
            public void onChanged(@Nullable Currency currency) {
                recyclerView.setAdapter(new CurrencyListAdapter(currency));
            }
        });





    }




}
