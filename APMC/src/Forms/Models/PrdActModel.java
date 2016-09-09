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
public class PrdActModel
{
    String cid;
    String aid;
    String slno;
    String product;
    Date asdate;
    Double acamt;
    String acstatus;
    Date aenddate;
    Double prdwgt;
    Double qrate;
    String status;
    String pslno;

    public Double getAcamt() {
        return acamt;
    }

    public String getAcstatus() {
        return acstatus;
    }

    public Date getAenddate() {
        return aenddate;
    }

    public String getAid() {
        return aid;
    }

    public Date getAsdate() {
        return asdate;
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

    public String getPslno() {
        return pslno;
    }

    public Double getQrate() {
        return qrate;
    }

    public String getSlno() {
        return slno;
    }

    public String getStatus() {
        return status;
    }

    public PrdActModel(String cid, String aid, String slno, String product, Date asdate, Double acamt, String acstatus, Date aenddate, Double prdwgt, Double qrate, String status, String pslno) {
        this.cid = cid;
        this.aid = aid;
        this.slno = slno;
        this.product = product;
        this.asdate = asdate;
        this.acamt = acamt;
        this.acstatus = acstatus;
        this.aenddate = aenddate;
        this.prdwgt = prdwgt;
        this.qrate = qrate;
        this.status = status;
        this.pslno = pslno;
    }


}
