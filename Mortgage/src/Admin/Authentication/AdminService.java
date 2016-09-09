/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin.Authentication;
import java.util.*;
import java.sql.*;



public class AdminService
{
    List lst=null;
    boolean flag=false;
    Connection con;
    PreparedStatement ps=null;
    Statement st=null;
    ResultSet rs=null;
    //DBConnect dbc=null;

    public boolean modifyPwd(String uid,String newpwd)
    {
        /*dbc=new DBConnect();
        try
        {
            con=dbc.getConnet();
            ps=con.prepareStatement("update password set pwd=? where uid=?");
            ps.setString(1, newpwd);
            ps.setString(2, uid);
            
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("Password Expt :"+e);}
            System.out.println("Password Expt :"+e);
        }*/
        return true;
    }
    public boolean validateLogin(String uid,String pwd)
    {
      /*  dbc=new DBConnect();
        String t1="",t2="";
        PWD p=null;
        int i=0;
        try
        {
            con=dbc.getConnet();
            ps=con.prepareStatement("select uid,pwd from password where uid=? and pwd=?");
            ps.setString(1, uid);
            ps.setString(2, pwd);

            rs=ps.executeQuery();
            while(rs.next())
            {
                p=new PWD(rs.getString("uid"),rs.getString("pwd"));
                System.out.println(" "+i);
                i++;

            }
            if(i>0)
                flag=true;
            
        }catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("Password Expt :"+e);}
            System.out.println("Password Expt :"+e);
        }*/
        return true;
    }
}
