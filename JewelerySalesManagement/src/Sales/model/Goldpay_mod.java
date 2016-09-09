/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

import java.sql.Date;

/**
 *
 * @author Dell-PC
 */
public class Goldpay_mod
{
    String cid;
    String tid;
    Date tdat;
    Double na;
    Double ba;
    int pid;
    Double pamt;
    Date paydate;

    public Double getBa() {
        return ba;
    }

    public String getCid() {
        return cid;
    }

    public Double getNa() {
        return na;
    }

    public Double getPamt() {
        return pamt;
    }

    public Date getPaydate() {
        return paydate;
    }

    public int getPid() {
        return pid;
    }

    public Date getTdat() {
        return tdat;
    }

    public String getTid() {
        return tid;
    }

    public Goldpay_mod(String cid, String tid, Date tdat, Double na, Double ba, int pid, Double pamt, Date paydate) {
        this.cid = cid;
        this.tid = tid;
        this.tdat = tdat;
        this.na = na;
        this.ba = ba;
        this.pid = pid;
        this.pamt = pamt;
        this.paydate = paydate;
    }
}
