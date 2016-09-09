package com.vachana.com.vtsmartjewels.printlibs.bean;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class LineItem {

    @SerializedName("item")
    private String item;

    @SerializedName("qty")
    private int qty;

    @SerializedName("rate")
    private double rate;

    @SerializedName("total")
    private double total;

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

//    public Items[] getItems() {
//        return items;
//    }
//    public void setItems(Items[] items) {
//        this.items = items;
//    }

    public void fromString(String sJson) {
        Gson g = new Gson();
        LineItem li = g.fromJson(sJson, LineItem.class);
        setItem(li.getItem());
        setQty(li.getQty());
        setRate(li.getRate());
        setTotal(li.getTotal());
    }

    public String toString() {
        Gson g = new Gson();
        String s = g.toJson(this);
        return s;
    }
}
