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
public class CstPrdSellModel
{
   String cid;
   String acid;
   String product;
   Date soldate;
   Double prdwgt;
   Double qrate;
   Double totamt;
   String status;

    public String getAcid() {
        return acid;
    }

    public String getCid() {
        return cid;
    }

    public Double getPrdwgt() {
        return prdwgt;
    }

    public String getProduct() {
        return product;
    }

    public Double getQrate() {
        return qrate;
    }

    public Date getSoldate() {
        return soldate;
    }

    public String getStatus() {
        return status;
    }

    public Double getTotamt() {
        return totamt;
    }

    public CstPrdSellModel(String cid, String acid, String product, Date soldate, Double prdwgt, Double qrate, Double totamt, String status) {
        this.cid = cid;
        this.acid = acid;
        this.product = product;
        this.soldate = soldate;
        this.prdwgt = prdwgt;
        this.qrate = qrate;
        this.totamt = totamt;
        this.status = status;
    }
}
