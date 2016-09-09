/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

/**
 *
 * @author user
 */
public class AdminModel
{
    String uname;
    String pass;

    public String getPass() {
        return pass;
    }

    public String getUname() {
        return uname;
    }

    public AdminModel(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }
}
