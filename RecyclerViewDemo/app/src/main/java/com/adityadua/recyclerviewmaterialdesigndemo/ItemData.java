package com.adityadua.recyclerviewmaterialdesigndemo;

/**
 * Created by AdityaDua on 13/11/17.
 */

public class ItemData {

    String name;
    String features;
    int url;

    public ItemData(String name,String features, int url) {
        this.name = name;
        this.features = features;
        this.url = url;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
