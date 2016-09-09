/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

/**
 *
 * @author user
 */
public class CstAmt_mod {
    String cid;
    String tid;
    Double tot;
    Double bal;

    public Double getBal() {
        return bal;
    }

    public String getCid() {
        return cid;
    }

    public String getTid() {
        return tid;
    }

    public Double getTot() {
        return tot;
    }

    public CstAmt_mod(String cid, String tid, Double tot, Double bal) {
        this.cid = cid;
        this.tid = tid;
        this.tot = tot;
        this.bal = bal;
    }

}
