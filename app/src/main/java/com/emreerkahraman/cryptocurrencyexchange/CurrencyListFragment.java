package com.emreerkahraman.cryptocurrencyexchange;

import android.app.AlertDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.Toolbar;

import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import com.emreerkahraman.cryptocurrencyexchange.viewmodel.CurrencyListViewModel;


public class CurrencyListFragment extends Fragment  implements LifecycleOwner{

    private static final String[] BaseList={"USD","AUD", "BRL", "CAD", "CHF", "CLP", "CNY", "CZK",
            "DKK", "EUR", "GBP", "HKD", "HUF", "IDR", "ILS", "INR", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD",
            "PHP", "PKR", "PLN", "RUB", "SEK", "SGD", "THB", "TRY", "TWD", "ZAR"};

    private CurrencyListViewModel currencyListViewModel;

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private CurrencyListAdapter currencyListAdapter;

    private Toolbar toolbar;


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

        toolbar=view.findViewById(R.id.my_toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();

        activity.setSupportActionBar(toolbar);

        //activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setHasOptionsMenu(true);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation()));

        recyclerView.setHasFixedSize(true);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.currencymame:{
               AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
               builder.setTitle("Choose Base");
               builder.setItems(BaseList, (dialog, which) -> {
                   String mBase = BaseList[which];
                   item.setTitle(mBase);
                   currencyListViewModel.setCurrencyBase(mBase);

  });

                AlertDialog alert = builder.create();

                alert.show();

                break;
            }
        }

            return super.onOptionsItemSelected(item);
        }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        currencyListAdapter = new CurrencyListAdapter();

        recyclerView.setAdapter(currencyListAdapter);

        currencyListViewModel = ViewModelProviders.of(this).get(CurrencyListViewModel.class);

        currencyListViewModel.setCurrencyBase("TRY");

        currencyListViewModel.mCurrencyData.observe(this, currency -> currencyListAdapter.setCurrencyList(currency));





    }




}
