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
public class PayModel
{
    String cid;
    String pid;
    Date paydate;
    String solddate;
    String product;
    Double prdamt;
    String tid;
    Double trnamt;
    Double intrest;
    Double wtintrst;
    Double dueamt;
    Double returnamt;
    String pname;
    Double bcamt;

    public Double getBcamt() {
        return bcamt;
    }

    public String getCid() {
        return cid;
    }

    public Double getDueamt() {
        return dueamt;
    }

    public Double getIntrest() {
        return intrest;
    }

    public Date getPaydate() {
        return paydate;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public Double getPrdamt() {
        return prdamt;
    }

    public String getProduct() {
        return product;
    }

    public Double getReturnamt() {
        return returnamt;
    }

    public String getSolddate() {
        return solddate;
    }

    public String getTid() {
        return tid;
    }

    public Double getTrnamt() {
        return trnamt;
    }

    public Double getWtintrst() {
        return wtintrst;
    }

    public PayModel(String cid, String pid, Date paydate, String solddate, String product, Double prdamt, String tid, Double trnamt, Double intrest, Double wtintrst, Double dueamt, Double returnamt, String pname, Double bcamt) {
        this.cid = cid;
        this.pid = pid;
        this.paydate = paydate;
        this.solddate = solddate;
        this.product = product;
        this.prdamt = prdamt;
        this.tid = tid;
        this.trnamt = trnamt;
        this.intrest = intrest;
        this.wtintrst = wtintrst;
        this.dueamt = dueamt;
        this.returnamt = returnamt;
        this.pname = pname;
        this.bcamt = bcamt;
    }

}
