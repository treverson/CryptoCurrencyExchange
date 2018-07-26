package com.emreerkahraman.cryptocurrencyexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CurrencyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,CurrencyListFragment.newInstance())
                .commitNow();
    }
}
