/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Models;

/**
 *
 * @author user
 */
public class PrdModel
{
    String slno;
    String code;
    String product;

    public String getCode() {
        return code;
    }

    public String getProduct() {
        return product;
    }

    public String getSlno() {
        return slno;
    }

    public PrdModel(String slno, String code, String product) {
        this.slno = slno;
        this.code = code;
        this.product = product;
    }

}
