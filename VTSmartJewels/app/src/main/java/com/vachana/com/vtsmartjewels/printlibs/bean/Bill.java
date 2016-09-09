package com.vachana.com.vtsmartjewels.printlibs.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Bill {

    @SerializedName("print_size")
    private int printSize;

    @SerializedName("header1")
    private String header1;

    @SerializedName("header2")
    private String header2;

    @SerializedName("header3")
    private String header3;

    @SerializedName("footer")
    private String footer;

    @SerializedName("total")
    private double total;

    @SerializedName("tax")
    private String tax;

    @SerializedName("line_items")
    private LineItem lineItems[];

    public Bill() {
        printSize = 48;
    }

    public int getPrintSize() {
        return printSize;
    }

    public void setPrintSize(int printSize) {
        this.printSize = printSize;
    }

    public String getHeader1() {
        return header1;
    }
    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getHeader2() {
        return header2;
    }
    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getHeader3() {
        return header3;
    }
    public void setHeader3(String header3) {
        this.header3 = header3;
    }

    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public String getTax() {
        return tax;
    }
    public void setTax(String tax) {
        this.tax = tax;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }
    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
    public void fromString(String sJson) {
        Gson g = new Gson();
        Bill b = g.fromJson(sJson, Bill.class);
        setHeader1(b.getHeader1());
        setHeader2(b.getHeader2());
        setHeader3(b.getHeader3());
        setFooter(b.getFooter());
        setLineItems(b.getLineItems());
        setTotal(b.getTotal());
        setTax(b.getTax());
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }

}
