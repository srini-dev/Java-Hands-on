/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.model;

import java.util.Date;

/**
 *
 * @author Dell-PC
 */
public class Tranpay_mod
{
    String cid;
    String tid;
    String pid;
    double totamt;
    double pamt;
    String payee;
    Date pdate;

    public String getCid() {
        return cid;
    }

    public double getPamt() {
        return pamt;
    }

    public String getPayee() {
        return payee;
    }

    public Date getPdate() {
        return pdate;
    }

    public String getPid() {
        return pid;
    }

    public String getTid() {
        return tid;
    }

    public double getTotamt() {
        return totamt;
    }

    public Tranpay_mod(String cid, String tid, String pid, double totamt, double pamt, String payee, Date pdate) {
        this.cid = cid;
        this.tid = tid;
        this.pid = pid;
        this.totamt = totamt;
        this.pamt = pamt;
        this.payee = payee;
        this.pdate = pdate;
    }

}
