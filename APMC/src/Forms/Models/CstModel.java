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
public class CstModel
{
    String cid;
    Date regdat;
    String cnam;
    String caddrs;
    String ctown;
    String cphno;
    String cpic;

    public String getCaddrs() {
        return caddrs;
    }

    public String getCid() {
        return cid;
    }

    public String getCnam() {
        return cnam;
    }

    public String getCphno() {
        return cphno;
    }

    public String getCpic() {
        return cpic;
    }

    public String getCtown() {
        return ctown;
    }

    public Date getregdat() {
        return regdat;
    }

    public CstModel(String cid, Date regdat, String cnam, String caddrs, String ctown, String cphno, String cpic) {
        this.cid = cid;
        this.regdat = regdat;
        this.cnam = cnam;
        this.caddrs = caddrs;
        this.ctown = ctown;
        this.cphno = cphno;
        this.cpic = cpic;
    }



}
