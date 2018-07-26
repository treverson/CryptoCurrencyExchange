package com.emreerkahraman.cryptocurrencyexchange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Curreny {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("website_slug")
    @Expose
    private String websiteSlug;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("circulating_supply")
    @Expose
    private Double circulatingSupply;
    @SerializedName("total_supply")
    @Expose
    private Double totalSupply;
    @SerializedName("max_supply")
    @Expose
    private Object maxSupply;
    @SerializedName("quotes")
    @Expose
    private Quotes quotes;
    @SerializedName("last_updated")
    @Expose
    private Integer lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWebsiteSlug() {
        return websiteSlug;
    }

    public void setWebsiteSlug(String websiteSlug) {
        this.websiteSlug = websiteSlug;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Object getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Object maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    class EUR {

        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("volume_24h")
        @Expose
        private Double volume24h;
        @SerializedName("market_cap")
        @Expose
        private Double marketCap;
        @SerializedName("percent_change_1h")
        @Expose
        private Double percentChange1h;
        @SerializedName("percent_change_24h")
        @Expose
        private Double percentChange24h;
        @SerializedName("percent_change_7d")
        @Expose
        private Double percentChange7d;

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getVolume24h() {
            return volume24h;
        }

        public void setVolume24h(Double volume24h) {
            this.volume24h = volume24h;
        }

        public Double getMarketCap() {
            return marketCap;
        }

        public void setMarketCap(Double marketCap) {
            this.marketCap = marketCap;
        }

        public Double getPercentChange1h() {
            return percentChange1h;
        }

        public void setPercentChange1h(Double percentChange1h) {
            this.percentChange1h = percentChange1h;
        }

        public Double getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(Double percentChange24h) {
            this.percentChange24h = percentChange24h;
        }

        public Double getPercentChange7d() {
            return percentChange7d;
        }

        public void setPercentChange7d(Double percentChange7d) {
            this.percentChange7d = percentChange7d;
        }

    }

    class Example {

        @SerializedName("data")
        @Expose
        private List<Curreny> data = null;
        @SerializedName("metadata")
        @Expose
        private Metadata metadata;

        public List<Curreny> getData() {
            return data;
        }

        public void setData(List<Curreny> data) {
            this.data = data;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }


    }

    class Metadata {

        @SerializedName("timestamp")
        @Expose
        private Integer timestamp;
        @SerializedName("num_cryptocurrencies")
        @Expose
        private Integer numCryptocurrencies;
        @SerializedName("error")
        @Expose
        private Object error;

        public Integer getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Integer timestamp) {
            this.timestamp = timestamp;
        }

        public Integer getNumCryptocurrencies() {
            return numCryptocurrencies;
        }

        public void setNumCryptocurrencies(Integer numCryptocurrencies) {
            this.numCryptocurrencies = numCryptocurrencies;
        }

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }
    }

    class Quotes {

        @SerializedName("USD")
        @Expose
        private USD uSD;
        @SerializedName("EUR")
        @Expose
        private EUR eUR;

        public USD getUSD() {
            return uSD;
        }

        public void setUSD(USD uSD) {
            this.uSD = uSD;
        }

        public EUR getEUR() {
            return eUR;
        }

        public void setEUR(EUR eUR) {
            this.eUR = eUR;
        }

    }

    class USD {

        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("volume_24h")
        @Expose
        private Double volume24h;
        @SerializedName("market_cap")
        @Expose
        private Double marketCap;
        @SerializedName("percent_change_1h")
        @Expose
        private Double percentChange1h;
        @SerializedName("percent_change_24h")
        @Expose
        private Double percentChange24h;
        @SerializedName("percent_change_7d")
        @Expose
        private Double percentChange7d;

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getVolume24h() {
            return volume24h;
        }

        public void setVolume24h(Double volume24h) {
            this.volume24h = volume24h;
        }

        public Double getMarketCap() {
            return marketCap;
        }

        public void setMarketCap(Double marketCap) {
            this.marketCap = marketCap;
        }

        public Double getPercentChange1h() {
            return percentChange1h;
        }

        public void setPercentChange1h(Double percentChange1h) {
            this.percentChange1h = percentChange1h;
        }

        public Double getPercentChange24h() {
            return percentChange24h;
        }

        public void setPercentChange24h(Double percentChange24h) {
            this.percentChange24h = percentChange24h;
        }

        public Double getPercentChange7d() {
            return percentChange7d;
        }

        public void setPercentChange7d(Double percentChange7d) {
            this.percentChange7d = percentChange7d;
        }
    }

}