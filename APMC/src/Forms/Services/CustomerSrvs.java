/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Services;
import Admin.Database.DBConnect;
import Forms.Models.CstModel;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class CustomerSrvs
{
    Connection con=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean flag=false;
    List lst=null;
    CstModel cstm=null;
    public boolean savecst(String cid,Date regdat, String cnam,String caddrs,String ctown,String cphno,String cpic)
    {
        try
        {   
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setDate(2, regdat);
            ps.setString(3, cnam);
            ps.setString(4, caddrs);
            ps.setString(5, ctown);
            ps.setString(6, cphno);
            ps.setString(7, cpic);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Customer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean saveSubcst(String cid, String cidname)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into SubCst values(?,?)");
            ps.setString(1, cid);
            ps.setString(2, cidname);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving SubCustomer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdtSubcst(String cid, String cidname)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update SubCst Set cidname = ? Where cid = ?");
            ps.setString(2, cid);
            ps.setString(1, cidname);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In Updateing SubCustomer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean Updatecst(String cid, String cnam,String caddrs,String ctown,String cphno,String cpic)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Customer Set cnam = ?, caddrs = ?, ctown = ?, cphno = ?, cpic = ? Where cid = ?");
            ps.setString(1, cnam);
            ps.setString(2, caddrs);
            ps.setString(3, ctown);
            ps.setString(4, cphno);
            ps.setString(5, cpic);
            ps.setString(6, cid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In Update Customer data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getcstTab()
    {
        lst=new LinkedList();
        try
        {

            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Customer");
            rs=ps.executeQuery();
            while(rs.next())
            {   
                cstm=new CstModel(rs.getString("cid"),rs.getDate("regdat"),rs.getString("cnam"),rs.getString("caddrs"),rs.getString("ctown"),rs.getString("cphno"),rs.getString("cpic"));
                lst.add(cstm);
            }
        }
        catch(Exception e){System.out.println("Customer Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public CstModel getcstBid(String cid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Customer where  cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cstm=new CstModel(rs.getString("cid"),rs.getDate("regdat"),rs.getString("cnam"),rs.getString("caddrs"),rs.getString("ctown"),rs.getString("cphno"),rs.getString("cpic"));
            }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return cstm;
    }
    public CstModel getcstBNAme(String cnam)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Customer where  cnam = ?");
            ps.setString(1, cnam);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cstm=new CstModel(rs.getString("cid"),rs.getDate("regdat"),rs.getString("cnam"),rs.getString("caddrs"),rs.getString("ctown"),rs.getString("cphno"),rs.getString("cpic"));
            }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return cstm;
    }
    public CstModel getcstBname(String cnam)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Customer where  cnam = ?");
            ps.setString(1, cnam);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cstm=new CstModel(rs.getString("cid"),rs.getDate("regdat"),rs.getString("cnam"),rs.getString("caddrs"),rs.getString("ctown"),rs.getString("cphno"),rs.getString("cpic"));
            }
        }
        catch(Exception e){System.out.println("By Customer Name"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return cstm;
    }
    public List getCIDcmb()
    {
      lst= new LinkedList();

        try
        {
            String cod;
            lst.add("-Select-");
            con=new DBConnect().GetConnetion();
            ps= con.prepareStatement("SELECT cid FROM Customer order by cid asc");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("cid");
                lst.add(cod);
            }

        }catch(Exception e)
        {JOptionPane.showMessageDialog(null, "erorr At Combo Customer ID"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getCnamcmb()
    {
      lst= new LinkedList();

        try
        {
            String cod;
            lst.add("-Select-");
            con=new DBConnect().GetConnetion();
            ps= con.prepareStatement("SELECT cnam FROM Customer order by cnam asc");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("cnam");
                lst.add(cod);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Combo Customer Name"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getPlacecmb()
    {
      lst= new LinkedList();

        try
        {
            String cod;
            lst.add("-Select-");
            con=new DBConnect().GetConnetion();
            ps= con.prepareStatement("SELECT Distinct(ctown) as place FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("place");
                lst.add(cod);
            }

        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Combo Customer Name"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getNextCId()
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT cid FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("cid");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
}
