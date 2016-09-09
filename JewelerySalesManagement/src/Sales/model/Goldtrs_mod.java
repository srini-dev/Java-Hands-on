/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

import java.util.Date;

/**
 *
 * @author user
 */
public class Goldtrs_mod {
    String cid;
    String tid;
    String slno;

    public String getSlno() {
        return slno;
    }
    Date t_date;
    String purch_item;
    Double goldrate;
    Double weight;
    Double wastage;
    Double mak_chrg;
    Double tax;
    Double totamt;
    Date rtnDat;


    public String getCid() {
        return cid;
    }

    public Double getGoldrate() {
        return goldrate;
    }

    public Double getMak_chrg() {
        return mak_chrg;
    }

    public String getPurch_item() {
        return purch_item;
    }

    public Date getT_date() {
        return t_date;
    }

    public Date getRtnDat() {
        return rtnDat;
    }
    public Double getTax() {
        return tax;
    }

    public String getTid() {
        return tid;
    }

    public Double getTotamt() {
        return totamt;
    }

    public Double getWastage() {
        return wastage;
    }

    public Double getWeight() {
        return weight;
    }
    //("cid")("trnsid")("t_date")("p_item")("g_rate"),("weight")("wastage")("making_chrg")("tax")("tot_amt"));

    public Goldtrs_mod(String cid, String tid,String slno,Date t_date, String purch_item, Double goldrate, Double weight, Double wastage, Double mak_chrg, Double tax, Double totamt,Date rtnDat) {
        this.cid = cid;
        this.tid = tid;
        this.slno = slno;
        this.t_date = t_date;
        this.purch_item = purch_item;
        this.goldrate = goldrate;
        this.weight = weight;
        this.wastage = wastage;
        this.mak_chrg = mak_chrg;
        this.tax = tax;
        this.totamt = totamt;
        this.rtnDat=rtnDat;
    }

}
