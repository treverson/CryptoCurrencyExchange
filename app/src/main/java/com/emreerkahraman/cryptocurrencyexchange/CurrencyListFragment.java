package com.emreerkahraman.cryptocurrencyexchange;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import com.emreerkahraman.cryptocurrencyexchange.viewmodel.CurrencyBaseDialogFragment;
import com.emreerkahraman.cryptocurrencyexchange.viewmodel.CurrencyListViewModel;


public class CurrencyListFragment extends Fragment  implements LifecycleOwner{


    private DividerItemDecoration dividerItemDecoration;
    private CurrencyListViewModel currencyListViewModel;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CurrencyListAdapter currencyListAdapter;
    private ImageView imageView;
    private Toolbar toolbar;
    private CurrencyBaseDialogFragment currencyBaseDialogFragment;

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
        imageView=view.findViewById(R.id.currencyIconImageView);
        recyclerView.setHasFixedSize(true);
        toolbar=view.findViewById(R.id.my_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);





        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);







        recyclerView.setAdapter(currencyListAdapter);





        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.currencymame: {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                CurrencyBaseDialogFragment dialogFragment = new CurrencyBaseDialogFragment();
                dialogFragment.show(ft, "dialog");
                item.setTitle(dialogFragment.getSelectedbase());





            }

        }
        return super.onOptionsItemSelected(item);
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
