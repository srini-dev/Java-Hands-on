/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.model;

import java.util.Date;

/**
 *
 * @author user
 */
public class Trantrs_mod
{
    String cid;
    String tid;
    Date gdate;
    String item;
    Double weight;
    Double intrst;
    Double g_amt;
    Date rdate;
    Double ramt;
    String status;
    Date rtndat;

    public String getStatus() {
        return status;
    }

    public String getCid() {
        return cid;
    }

    public Double getG_amt() {
        return g_amt;
    }

    public Date getGdate() {
        return gdate;
    }
     public Date getRtndat() {
        return rtndat;
    }

    public Double getIntrst() {
        return intrst;
    }

    public String getItem() {
        return item;
    }

    public Double getRamt() {
        return ramt;
    }

    public Date getRdate() {
        return rdate;
    }

    public String getTid() {
        return tid;
    }

    public Double getWeight() {
        return weight;
    }

    public Trantrs_mod(String cid, String tid, Date gdate, String item, Double weight, Double intrst, Double g_amt, Date rdate, Double ramt,String status,Date rtndat) {
        this.cid = cid;
        this.tid = tid;
        this.gdate = gdate;
        this.item = item;
        this.weight = weight;
        this.intrst = intrst;
        this.g_amt = g_amt;
        this.rdate = rdate;
        this.ramt = ramt;
        this.status=status;
        this.rtndat=rtndat;
    }
    
}
