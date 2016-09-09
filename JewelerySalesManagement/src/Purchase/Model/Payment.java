/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Purchase.Model;

/**
 *
 * @author user
 */

//vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn,typ

public class Payment {

    String vno;
    String pid;
    double vamt;
    String vdat;
    double vbal;
    String pmod;

    
    double pamt;
    String pdat;
    String byt;
    String lno;
    String actno;
    String acthldr;
    String bnam;
    String bbrch;
    String bprsn;
    String vtyp;

    public Payment(double vamt, double vbal) {
        this.vamt = vamt;
        this.vbal = vbal;
    }
    public Payment(String vno, String pid, double vamt, String vdat, double vbal, String pmod, double pamt, String pdat, String byt, String lno, String actno, String acthldr, String bnam, String bbrch, String bprsn,String vtyp) {
        this.vno = vno;
        this.pid = pid;
        this.vamt = vamt;
        this.vdat = vdat;
        this.vbal = vbal;
        this.pmod = pmod;
        this.pamt = pamt;
        this.pdat = pdat;
        this.byt = byt;
        this.lno = lno;
        this.actno = actno;
        this.acthldr = acthldr;
        this.bnam = bnam;
        this.bbrch = bbrch;
        this.bprsn = bprsn;
        this.vtyp=vtyp;
    }
    public Payment(String vno, String pid, double vamt, String vdat, double vbal, String pmod, double pamt, String pdat, String byt, String lno, String actno, String acthldr, String bnam, String bbrch, String bprsn) {
        this.vno = vno;
        this.pid = pid;
        this.vamt = vamt;
        this.vdat = vdat;
        this.vbal = vbal;
        this.pmod = pmod;
        this.pamt = pamt;
        this.pdat = pdat;
        this.byt = byt;
        this.lno = lno;
        this.actno = actno;
        this.acthldr = acthldr;
        this.bnam = bnam;
        this.bbrch = bbrch;
        this.bprsn = bprsn;

    }

    public String getActhldr() {
        return acthldr;
    }

    public String getActno() {
        return actno;
    }

    public String getBbrch() {
        return bbrch;
    }

    public String getBnam() {
        return bnam;
    }

    public String getBprsn() {
        return bprsn;
    }

    public String getByt() {
        return byt;
    }

    public String getLno() {
        return lno;
    }

    public double getPamt() {
        return pamt;
    }

    public String getPdat() {
        return pdat;
    }

    public String getPid() {
        return pid;
    }

    public String getPmod() {
        return pmod;
    }

    public double getVamt() {
        return vamt;
    }

    public double getVbal() {
        return vbal;
    }

    public String getVdat() {
        return vdat;
    }

    public String getVno() {
        return vno;
    }
}
