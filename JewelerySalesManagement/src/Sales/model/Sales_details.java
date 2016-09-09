/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.model;

/**
 *
 * @author Dell-PC
 */
public class Sales_details {
String customerid;
String customername;
String itemname;
int phoneno;
String Scustomerid;
String Scustomername;
String Sitemname;
int Sphoneno;

    public Sales_details(String customerid, String customername, String itemname, int phoneno, String Scustomerid, String Scustomername, String Sitemname, int Sphoneno) {
        this.customerid = customerid;
        this.customername = customername;
        this.itemname = itemname;
        this.phoneno = phoneno;
        this.Scustomerid = Scustomerid;
        this.Scustomername = Scustomername;
        this.Sitemname = Sitemname;
        this.Sphoneno = Sphoneno;
    }

    public String getScustomerid() {
        return Scustomerid;
    }

    public String getScustomername() {
        return Scustomername;
    }

    public String getSitemname() {
        return Sitemname;
    }

    public int getSphoneno() {
        return Sphoneno;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public String getItemname() {
        return itemname;
    }

    public int getPhoneno() {
        return phoneno;
    }



}
