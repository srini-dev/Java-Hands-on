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
public class PrdInvModel
{
    String cid;
    String slno;
    String icode;
    String iname;
    String pack;
    Date pidate;
    String pstatus;
    String status;

    public String getCid() {
        return cid;
    }

    public String getIcode() {
        return icode;
    }

    public String getIname() {
        return iname;
    }

    public String getPack() {
        return pack;
    }

    public Date getPidate() {
        return pidate;
    }

    public String getPstatus() {
        return pstatus;
    }

    public String getSlno() {
        return slno;
    }

    public String getStatus() {
        return status;
    }

    public PrdInvModel(String cid, String slno, String icode, String iname, String pack, Date pidate, String pstatus, String status) {
        this.cid = cid;
        this.slno = slno;
        this.icode = icode;
        this.iname = iname;
        this.pack = pack;
        this.pidate = pidate;
        this.pstatus = pstatus;
        this.status = status;
    }

}
