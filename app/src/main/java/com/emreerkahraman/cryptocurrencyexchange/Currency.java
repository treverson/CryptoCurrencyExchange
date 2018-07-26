package com.emreerkahraman.cryptocurrencyexchange;

public class Currency {
    private String mSymbol;
    private String mName;
    private Double mPrice;
    private Double mPercentChange1hr;
    private Double mPercentChange1d;
    private Double mPercentChange1w;

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String mSymbol) {
        this.mSymbol = mSymbol;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double mPrice) {
        this.mPrice = mPrice;
    }

    public Double getPercentChange1hr() {
        return mPercentChange1hr;
    }

    public void setPercentChange1hr(Double mPercentChange1hr) {
        this.mPercentChange1hr = mPercentChange1hr;
    }

    public Double getPercentChange1d() {
        return mPercentChange1d;
    }

    public void setPercentChange1d(Double mPercentChange1d) {
        this.mPercentChange1d = mPercentChange1d;
    }

    public Double getPercentChange1w() {
        return mPercentChange1w;
    }

    public void setPercentChange1w(Double mPercentChange1w) {
        this.mPercentChange1w = mPercentChange1w;
    }

    public Currency(String mSymbol, String mName, Double mPrice, Double mPercentChange1hr, Double mPercentChange1d, Double mPercentChange1w) {
        this.mSymbol = mSymbol;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mPercentChange1hr = mPercentChange1hr;
        this.mPercentChange1d = mPercentChange1d;
        this.mPercentChange1w = mPercentChange1w;
    }
}
