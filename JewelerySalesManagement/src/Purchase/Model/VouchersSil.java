/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Purchase.Model;

//vouchers(s,s,s,s,s,s,s,s,s,d,s,d,d,d,d,s,s)
//vno,kst ,cst,tinno,pnam,snam,mft,phon,dat,rate,itm,wt,irat,tax,tot,nar,typ
public class VouchersSil {

    String vno;
    String kst ;
    String cst;
    String tinno;
    String pnam;
    String snam;
    String mft;
    String phon;
    String dat;
    double rate;
    String itm;
    double wt;
    double irat;
    double tax;
    double tot;
    String nar;
    String typ;

    public VouchersSil(String vno, String kst, String cst, String tinno, String pnam, String snam, String mft, String phon, String dat, double rate, String itm, double wt, double irat, double tax, double tot, String nar, String typ) {
        this.vno = vno;
        this.kst = kst;
        this.cst = cst;
        this.tinno = tinno;
        this.pnam = pnam;
        this.snam = snam;
        this.mft = mft;
        this.phon = phon;
        this.dat = dat;
        this.rate = rate;
        this.itm = itm;
        this.wt = wt;
        this.irat = irat;
        this.tax = tax;
        this.tot = tot;
        this.nar = nar;
        this.typ = typ;
    }
    public VouchersSil(String vno, String dat, double tot,String typ) {
        this.vno = vno;
        this.dat = dat;
        this.tot = tot;
        this.typ = typ;
    }

    public String getCst() {
        return cst;
    }

    public String getDat() {
        return dat;
    }

    public double getIrat() {
        return irat;
    }

    public String getItm() {
        return itm;
    }

    public String getKst() {
        return kst;
    }

    public String getMft() {
        return mft;
    }

    public String getNar() {
        return nar;
    }

    public String getPhon() {
        return phon;
    }

    public String getPnam() {
        return pnam;
    }

    public double getRate() {
        return rate;
    }

    public String getSnam() {
        return snam;
    }

    public double getTax() {
        return tax;
    }

    public String getTinno() {
        return tinno;
    }

    public double getTot() {
        return tot;
    }

    public String getTyp() {
        return typ;
    }

    public String getVno() {
        return vno;
    }

    public double getWt() {
        return wt;
    }
}
