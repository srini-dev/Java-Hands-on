/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Master.Model;

import Master.*;

/**
 *
 * @author shri
 */
public class BankMod {
    String BankName;
    String BankBranch;

    public BankMod(String BankName, String BankBranch) {
        this.BankName = BankName;
        this.BankBranch = BankBranch;
    }

    public String getBankBranch() {
        return BankBranch;
    }

    public String getBankName() {
        return BankName;
    }

}
