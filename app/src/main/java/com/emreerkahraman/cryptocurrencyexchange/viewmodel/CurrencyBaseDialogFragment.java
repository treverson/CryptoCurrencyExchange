package com.emreerkahraman.cryptocurrencyexchange.viewmodel;

import android.app.AlertDialog;
import android.app.Dialog;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;


public class CurrencyBaseDialogFragment extends DialogFragment {
    private static final  String[] BaseList={"USD","AUD", "BRL", "CAD", "CHF", "CLP", "CNY", "CZK",
            "DKK", "EUR", "GBP", "HKD", "HUF", "IDR", "ILS", "INR", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD",
            "PHP", "PKR", "PLN", "RUB", "SEK", "SGD", "THB", "TRY", "TWD", "ZAR"};

    private String selectedbase;
    public String getSelectedbase() {
        return selectedbase;
    }

    public void setSelectedbase(String selectedbase) {
        this.selectedbase = selectedbase;
    }




    public static CurrencyBaseDialogFragment newInstance(){
        CurrencyBaseDialogFragment fragment=new CurrencyBaseDialogFragment();
        return fragment;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setItems(BaseList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setSelectedbase(BaseList[which]);


            }
        }).create();

    }
     public void showDialog(){


        DialogFragment dialogFragment=CurrencyBaseDialogFragment.newInstance();
        dialogFragment.show(getFragmentManager().beginTransaction(),"dialog");
    }
}
