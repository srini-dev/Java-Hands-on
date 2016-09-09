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
public class TrnModel
{
    String cid;
    String tid;
    String slno;
    Date tdat;
    String reason;
    Double amt;
    Double totamt;
    String status;

    public String getStatus() {
        return status;
    }
    public Double getAmt() {
        return amt;
    }

    public String getCid() {
        return cid;
    }

    public String getReason() {
        return reason;
    }

    public String getSlno() {
        return slno;
    }

    public Date getTdat() {
        return tdat;
    }

    public String getTid() {
        return tid;
    }

    public Double getTotamt() {
        return totamt;
    }

    public TrnModel(String cid, String tid, String slno, Date tdat, String reason, Double amt, Double totamt,String status) {
        this.cid = cid;
        this.tid = tid;
        this.slno = slno;
        this.tdat = tdat;
        this.reason = reason;
        this.amt = amt;
        this.totamt = totamt;
        this.status=status;
    }
}
