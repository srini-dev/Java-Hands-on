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
public class Trancst_model
{
    String cid;
    String cname;
    String address;
    String phno;
    String cpic;
    String vid;
    String vdetails;
    String vaddress;
    String v_phno;
    String vpic;
    double totamt;

    public Trancst_model(String cid, String cname, String address, String phno, String cpic, String vid, String vdetails, String vaddress, String v_phno, String vpic, double totamt) {
        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.phno = phno;
        this.cpic = cpic;
        this.vid = vid;
        this.vdetails = vdetails;
        this.vaddress = vaddress;
        this.v_phno = v_phno;
        this.vpic = vpic;
        this.totamt = totamt;
    }

    public double getTotamt() {
        return totamt;
    }

    public String getAddress() {
        return address;
    }

    public String getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getCpic() {
        return cpic;
    }

    public String getPhno() {
        return phno;
    }

    public String getV_phno() {
        return v_phno;
    }

    public String getVaddress() {
        return vaddress;
    }

    public String getVdetails() {
        return vdetails;
    }

    public String getVid() {
        return vid;
    }

    public String getVpic() {
        return vpic;
    }

    
}
 