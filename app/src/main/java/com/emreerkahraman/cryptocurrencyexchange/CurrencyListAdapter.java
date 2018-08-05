package com.emreerkahraman.cryptocurrencyexchange;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emreerkahraman.cryptocurrencyexchange.databinding.RecyclerviewItemBinding;
import com.emreerkahraman.cryptocurrencyexchange.model.Currency;
import com.emreerkahraman.cryptocurrencyexchange.model.Data;


import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.CurrencyListViewHolder> {


    private Context mContext;
    private List<Data> mCurrencyList;

    public void setCurrencyList(Currency currency)
    {
        this.mCurrencyList=currency.getData();
        notifyDataSetChanged();
    }





    static class CurrencyListViewHolder extends RecyclerView.ViewHolder {


        private RecyclerviewItemBinding binding;

        private CurrencyListViewHolder(RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        private void bind(Data data) {
            binding.setData(data);
            binding.executePendingBindings();
        }
    }


    @NonNull
    @Override
    public CurrencyListAdapter.CurrencyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerviewItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.recyclerview_item, parent, false);
        return new CurrencyListViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyListAdapter.CurrencyListViewHolder holder, int position) {
        Data currency = mCurrencyList.get(position);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        holder.bind(currency);
        holder.binding.priceTextView.setText(String.valueOf(df.format(currency.getQuotes().getBASE().getPrice())));
        holder.binding.percentchange1hrText.setTextColor(getColor(currency.getQuotes().getBASE().getPercentChange1h()));
        holder.binding.percentchange1dText.setTextColor(getColor(currency.getQuotes().getBASE().getPercentChange24h()));
        holder.binding.percentchange1wText.setTextColor(getColor(currency.getQuotes().getBASE().getPercentChange7d()));



    }

    @Override
    public int getItemCount () {
        if (mCurrencyList!=null){
            return mCurrencyList.size();
        }
        return 0;

    }
    private int getColor(Double d){
        if (d==null){
            return Color.parseColor("#F44336");
        }
        else{
            if (d>0){
                return Color.parseColor("#4CAF50");
            }
        }
        return Color.RED;
    }
}