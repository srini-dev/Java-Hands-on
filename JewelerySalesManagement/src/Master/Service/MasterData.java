/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Master.Service;
import Admin.DataBase.DBConnect;
import Master.Model.BankMod;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MasterData {


   Connection con=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean flag=false;
    List lst=null;
    BankMod bnk=null;
    public boolean saveBank(String Bname, String Bbranch)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Bank values(?,?)");
            ps.setString(1, Bname);
            ps.setString(2, Bbranch);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }
        catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("BankSave Expt :"+e);}
            System.out.println("BankSave Expt :"+e);
        }
        finally
        {
            try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"-----"+e);}
        }
        return flag;
    }

    //All Combobox code starts

public List getAllBankNames()
    {


        String pl;
        List lst=new LinkedList();
        lst.add("Select");
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select bank_name from Bank");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pl=rs.getString("bank");
                lst.add(pl);
            }
        }catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("BankSave Expt :"+e);}
            System.out.println("BankSave Expt :"+e);
        }
        finally
        {
            try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"-----"+e);}
        }
        return lst;
    }

public List getAllBankBranchs()
    {


        String pl;
        List lst=new LinkedList();
        lst.add("Select");
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select branch from Bank");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pl=rs.getString("branch");
                lst.add(pl);
            }
        }catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("BankSave Expt :"+e);}
            System.out.println("BankSave Expt :"+e);
        }
        finally
        {
            try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"-----"+e);}
        }
        return lst;
    }
    public List getBankTab()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Bank");
            rs=ps.executeQuery();
            while(rs.next())
            {
                bnk=new BankMod(rs.getString("bank_name"),rs.getString("branch"));
                lst.add(bnk);
            }
        }
        catch(Exception e){System.out.println("Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public BankMod viewbycode(String bank)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps= con.prepareStatement("select * from Bank where bank_name = ?");
            ps.setString(1, bank);
            rs=ps.executeQuery();
            while(rs.next())
            {
                bnk=new BankMod(rs.getString("bank_name"),rs.getString("branch"));
            }
        }
        catch(Exception e){System.out.println(e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return bnk;
    }
    public boolean DELBank(String Bname)
    {


        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("DELETE  from Bank where bank_name = ?");
            ps.setString(1, Bname);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }
        catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("BankSave Expt :"+e);}
            System.out.println("BankSave Expt :"+e);
        }
        finally
        {
            try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"-----"+e);}
        }
        return flag;
    }
    public boolean SetTargt(Double amt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            String code ="1";
            ps=con.prepareStatement("Update Target Set amount = ? where code = ?");
            ps.setDouble(1, amt);
            ps.setString(2, code);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }
        catch(Exception e)
        {
            try{con.close();}catch(Exception e1)
            {System.out.println("BankSave Expt :"+e);}
            System.out.println("BankSave Expt :"+e);
        }
        finally
        {
            try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"-----"+e);}
        }
        return flag;
    }
  
}

