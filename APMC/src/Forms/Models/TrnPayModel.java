/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Models;

import java.util.Date;

/**
 *
 * @author user
 */
public class TrnPayModel
{
    String cid;
    String tid;
    Date tdate;
    double totamt;
    double balamt;
    double paidamt;
    String status;

    public String getStatus() {
        return status;
    }

    public double getBalamt() {
        return balamt;
    }

    public String getCid() {
        return cid;
    }

    public double getPaidamt() {
        return paidamt;
    }

    public Date getTdate() {
        return tdate;
    }

    public String getTid() {
        return tid;
    }

    public double getTotamt() {
        return totamt;
    }

    public TrnPayModel(String cid, String tid, Date tdate, double totamt, double balamt, double paidamt,String status) {
        this.cid = cid;
        this.tid = tid;
        this.tdate = tdate;
        this.totamt = totamt;
        this.balamt = balamt;
        this.paidamt = paidamt;
        this.status = status;
    }

}
