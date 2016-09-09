/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sales.Services;

/**
 *
 * @author Dell-PC
 */
import Admin.DataBase.DBConnect;
import java.sql.*;
import javax.swing.JOptionPane;
import Admin.DataBase.DBConnect.*;
public class SilverMessagingserv {
boolean flag=false;
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public boolean Silver_Messaging(String cust_id, String cust_name, String addre, String city, String phn_no, Double pay_ment,Double paid,Double bal,String date) {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into gold_sale values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cust_id);
            ps.setString(2, cust_name);
            ps.setString(3, addre);
            ps.setString(4, city);
            ps.setString(5, phn_no);
            ps.setDouble(6,pay_ment );
            ps.setDouble(7, paid);
            ps.setDouble(8,bal );
            ps.setString(9,date );

            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0)
            {
                flag=true;
            }
        }catch(Exception e)
        {System.out.println("00000000"+e);
        }
        finally
        {
            try{
                conn.close();
                System.out.println("close..");
            }
            catch(Exception e)
            {
                System.out.println("not closes"+e);
            }
        }

        return flag;
    }
}
