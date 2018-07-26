
package com.emreerkahraman.cryptocurrencyexchange.gson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyGson {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
