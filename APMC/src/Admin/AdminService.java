/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;


import Admin.AdminService.*;
import Admin.Database.DBConnect;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;



public class AdminService
{
    List lst=null;
    boolean flag=false;
    Connection con;
    PreparedStatement ps=null;
    Statement st=null;
    ResultSet rs=null;
    DBConnect dbc=null;

    public boolean modifyPwd(String uid,String newpwd)
    {
        try
        {
            dbc=new DBConnect();
            con=dbc.GetConnetion();
            ps=con.prepareStatement("update pass set pass=? where uname=?");
            ps.setString(1, newpwd);
            ps.setString(2, uid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "error in Admin Modify "+e);
        }
        return true;
    }
    public boolean validateLogin(String uid,String pwd)
    {
        String t1="",t2="";
        AdminModel adm=null;
        int i=0;
        try
        {
            dbc=new DBConnect();
            con=dbc.GetConnetion();
            ps=con.prepareStatement("select uname, pass from Admin where uname = ? and pass = ?");
            ps.setString(1, uid);
            ps.setString(2, pwd);

            rs=ps.executeQuery();
            while(rs.next())
            {
                adm=new AdminModel(rs.getString("uid"),rs.getString("pwd"));
                System.out.println(" "+i);
                i++;

            }
            if(i>0)
                flag=true;
            
        }catch(Exception e)
        {
            System.out.println("Password Expt :"+e);}
       // }finally{try{con.close();System.out.println("Closed..");catch(Exception e){JOptionPane.showMessageDialog(null, "Closing Error");}}
        return true;
    }
}
