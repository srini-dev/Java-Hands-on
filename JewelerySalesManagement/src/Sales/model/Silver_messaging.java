/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

/**
 *
 * @author Dell-PC
 */
public class Silver_messaging {
    String cust_id;
    String cust_name;
    String addre;
    String city;
    String phn_no;
    Double pay_ment;
    Double paid;
    Double bal;
    String date;

    public Silver_messaging(String cust_id, String cust_name, String addre, String city, String phn_no, Double pay_ment, Double paid, Double bal, String date) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.addre = addre;
        this.city = city;
        this.phn_no = phn_no;
        this.pay_ment = pay_ment;
        this.paid = paid;
        this.bal = bal;
        this.date = date;
    }

    public String getAddre() {
        return addre;
    }

    public Double getBal() {
        return bal;
    }

    public String getCity() {
        return city;
    }

    public String getCust_id() {
        return cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public String getDate() {
        return date;
    }

    public Double getPaid() {
        return paid;
    }

    public Double getPay_ment() {
        return pay_ment;
    }

    public String getPhn_no() {
        return phn_no;
    }

}
