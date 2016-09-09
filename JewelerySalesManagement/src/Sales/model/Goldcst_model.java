/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

import java.util.Date;

/**
 *
 * @author Dell-PC
 */
public class Goldcst_model
{
    String cid;
    String cname;
    String address;
    String city;
    String phno;
    String pdetails;
    String paddress;
    String pcity;
    String p_phno;
    Date trans_date;
    String img1;
    String img2;
    String idp1;
    String idp2;

    public Goldcst_model(String cid, String cname, String address, String city, String phno, String pdetails, String paddress, String pcity, String p_phno, Date trans_date, String img1, String img2, String idp1, String idp2) {
        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.city = city;
        this.phno = phno;
        this.pdetails = pdetails;
        this.paddress = paddress;
        this.pcity = pcity;
        this.p_phno = p_phno;
        this.trans_date = trans_date;
        this.img1 = img1;
        this.img2 = img2;
        this.idp1 = idp1;
        this.idp2 = idp2;
    }

    public String getAddress() {
        return address;
    }

    public String getCid() {
        return cid;
    }

    public String getCity() {
        return city;
    }

    public String getCname() {
        return cname;
    }

    public String getIdp1() {
        return idp1;
    }

    public String getIdp2() {
        return idp2;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getP_phno() {
        return p_phno;
    }

    public String getPaddress() {
        return paddress;
    }

    public String getPcity() {
        return pcity;
    }

    public String getPdetails() {
        return pdetails;
    }

    public String getPhno() {
        return phno;
    }

    public Date getTrans_date() {
        return trans_date;
    }

    public Goldcst_model(String cid, String cname, String address, String city, String phno, String pdetails, String paddress, String pcity, String p_phno, Date trans_date) {
        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.city = city;
        this.phno = phno;
        this.pdetails = pdetails;
        this.paddress = paddress;
        this.pcity = pcity;
        this.p_phno = p_phno;
        this.trans_date = trans_date;
    }
}
 