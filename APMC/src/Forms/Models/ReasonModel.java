/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Models;

/**
 *
 * @author user
 */
public class ReasonModel
{
    String slno;
    String reason;

    public String getReason() {
        return reason;
    }

    public String getSlno() {
        return slno;
    }

    public ReasonModel(String slno, String reason) {
        this.slno = slno;
        this.reason = reason;
    }

}
