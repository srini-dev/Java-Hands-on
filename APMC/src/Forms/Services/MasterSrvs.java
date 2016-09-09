/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Services;

import Admin.Database.DBConnect;
import Forms.Models.CstModel;
import Forms.Models.PrdModel;
import Forms.Models.ReasonModel;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class MasterSrvs
{
    Connection con=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean flag=false;
    List lst=null;
    ReasonModel rm=null;
    PrdModel pm=null;
    public boolean saveReason(String slno,String reason)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Reason values(?,?)");
            ps.setString(1, slno);
            ps.setString(2, reason);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Customer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdateReason(String slno,String reason)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Reason Set reason = ? where slno = ?");
            ps.setString(2, slno);
            ps.setString(1, reason);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Customer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getNextRSLNO()
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT slno FROM Reason");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("slno");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next SLno in reason"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getReasonTab()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Reason");
            rs=ps.executeQuery();
            while(rs.next())
            {
                rm=new ReasonModel(rs.getString("slno"),rs.getString("reason"));
                lst.add(rm);
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public ReasonModel getRBsno(String slno)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Reason where  slno = ?");
            ps.setString(1, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                rm=new ReasonModel(rs.getString("slno"),rs.getString("reason"));
            }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return rm;
    }
    public List getSlnocmb()
    {
      lst= new LinkedList();

        try
        {
            String cod;
            lst.add("-Select-");
            con=new DBConnect().GetConnetion();
            ps= con.prepareStatement("SELECT reason FROM Reason");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("reason");
                lst.add(cod);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Combo Reasons Name"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    //--------------------------------Product Strats -------------------------------------------------------
    public boolean saveProcuts(String slno,String code,String product)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Products values(?,?,?)");
            ps.setString(1, slno);
            ps.setString(2, code);
            ps.setString(3, product);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Products data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getNextPSLNO()
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT slno FROM Products");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("slno");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next SLno in Products"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getProductTab()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Products");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pm=new PrdModel(rs.getString("slno"),rs.getString("code"),rs.getString("product"));
                lst.add(pm);
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public PrdModel getPBsno(String slno)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Products where  slno = ?");
            ps.setString(1, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                pm=new PrdModel(rs.getString("slno"),rs.getString("code"),rs.getString("product"));
            }
        }
        catch(Exception e){System.out.println("By Products ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pm;
    }
    public PrdModel getPBicode(String code)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Products where  code = ?");
            ps.setString(1, code);
            rs=ps.executeQuery();
            while(rs.next())
            {
                pm=new PrdModel(rs.getString("slno"),rs.getString("code"),rs.getString("product"));
            }
        }
        catch(Exception e){System.out.println("By Products ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pm;
    }
    public boolean Updatproduct(String slno,String code,String product)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Products Set code = ?, product = ? where slno = ?");
            ps.setString(1, code);
            ps.setString(2, product);
            ps.setString(3, slno);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Products data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getItmcod()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT code FROM Products");
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("code");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }

}
