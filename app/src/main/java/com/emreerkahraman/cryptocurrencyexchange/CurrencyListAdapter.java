package com.emreerkahraman.cryptocurrencyexchange;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emreerkahraman.cryptocurrencyexchange.gson.CurrencyGson;
import com.emreerkahraman.cryptocurrencyexchange.gson.Data;

import java.util.Date;
import java.util.List;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.CurrencyListViewHolder>{
    private List<Data> mCurrencyList;

    public void setmCurrencyList(List<Data> mCurrencyList) {
        this.mCurrencyList = mCurrencyList;
    }

    class CurrencyListViewHolder  extends RecyclerView.ViewHolder{

        TextView nameTextView;
        TextView priceTextView;
        TextView symbolTextView;
        TextView changepercent1hrTextView;
        TextView changepercent1dTextView;
        TextView changepercent1wTextView;
        ImageView currencyIconImageView;
        public CurrencyListViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            priceTextView=itemView.findViewById(R.id.priceTextView);
            symbolTextView=itemView.findViewById(R.id.symbolTextview);
            changepercent1hrTextView=itemView.findViewById(R.id.percentchange1hrText);
            changepercent1dTextView=itemView.findViewById(R.id.percentchange1dText);
            changepercent1wTextView=itemView.findViewById(R.id.percentchange1wText);
            currencyIconImageView=itemView.findViewById(R.id.currencyIconImageView);
        }
    }


    @NonNull
    @Override
    public CurrencyListAdapter.CurrencyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new CurrencyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyListAdapter.CurrencyListViewHolder holder, int position) {
        Data currency=mCurrencyList.get(position);

        holder.nameTextView.setText(currency.getName());
        holder.priceTextView.setText(String.valueOf(currency.getQuotes().getBASE().getPrice()));
        holder.symbolTextView.setText(currency.getSymbol());
        holder.changepercent1hrTextView.setText(String.valueOf(currency.getQuotes().getBASE().getPercentChange1h()));
        holder.changepercent1dTextView.setText(String.valueOf(currency.getQuotes().getBASE().getPercentChange24h()));
        holder.changepercent1wTextView.setText(String.valueOf(currency.getQuotes().getBASE().getPercentChange7d()));

    }

    @Override
    public int getItemCount() {
        return mCurrencyList.size();
    }
}
