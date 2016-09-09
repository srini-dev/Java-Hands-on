/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Services;
import Admin.Database.DBConnect;
import Forms.Models.CstModel;
import Forms.Models.TrnModel;
import Forms.Models.TrnPayModel;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class TranSrvs
{
    Connection con=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean flag=false;
    List lst=null;
    CstModel cstm=null;
    TrnModel trm=null;
    TrnPayModel tpm=null;
    public boolean saveTrn(String cid,String tid,String slno,Date tdat, String reason,Double amt,Double totamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Transaction values(?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, slno);
            ps.setDate(4, tdat);
            ps.setString(5, reason);
            ps.setDouble(6, amt);
            ps.setDouble(7, totamt);
            ps.setString(8, "Opened");
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Transaction data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdateTrn(String cid,String tid,String slno, String reason,Double amt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Transaction Set reason = ?, amt = ? Where cid = ? AND tid = ? AND slno = ?");
            ps.setString(1, reason);
            ps.setDouble(2, amt);
            ps.setString(3, cid);
            ps.setString(4, tid);
            ps.setString(5, slno);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving Transaction data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getNextTId(String cid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT Distinct(tid) as td FROM Transaction Where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("td");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getNextTSlno(String cid,String tid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT slno FROM Transaction Where cid = ? And tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("slno");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next SLNO"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List gettid(String cid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT Distinct(tid) as td FROM Transaction Where cid= ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("td");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    public List Getslno(String cid,String tid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT slno FROM Transaction Where cid = ? AND tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("slno");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    public TrnModel getTData(String cid,String tid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Transaction where  cid = ? AND tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                trm=new TrnModel(rs.getString("cid"),rs.getString("tid"),rs.getString("slno"),rs.getDate("tdat"),rs.getString("reason"),rs.getDouble("amt"),rs.getDouble("totamt"),rs.getString("status"));
            }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return trm;
    }
    public List getTTPrd(String cid)
    {
        lst=new LinkedList();
        try
        {
            String sts="Opened";
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstTrnPay where  cid = ? AND status = ?");
            ps.setString(1, cid);
            ps.setString(2, sts);
            rs=ps.executeQuery();
            while(rs.next())
            {
                tpm=new TrnPayModel(rs.getString("cid"),rs.getString("tid"),rs.getDate("tdate"),rs.getDouble("totamt"),rs.getDouble("balamt"),rs.getDouble("paidamt"),rs.getString("status"));
                lst.add(tpm);
            }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public TrnModel TDataBySLNO(String cid,String tid,String slno)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Transaction where  cid = ? AND tid = ? AND slno = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                trm=new TrnModel(rs.getString("cid"),rs.getString("tid"),rs.getString("slno"),rs.getDate("tdat"),rs.getString("reason"),rs.getDouble("amt"),rs.getDouble("totamt"),rs.getString("status"));
           }
        }
        catch(Exception e){System.out.println("By Customer ID"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return trm;
    }
    public boolean UpdateAMT(String cid,String tid,Double totamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Transaction Set totamt = ? where cid = ? AND tid = ?");
            ps.setDouble(1, totamt);
            ps.setString(2, cid);
            ps.setString(3, tid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Updating Transaction TOTAMT data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdateSTS(String cid,String tid,String status)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Transaction Set status = ? where cid = ? AND tid = ?");
            ps.setString(1, status);
            ps.setString(2, cid);
            ps.setString(3, tid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Updating Transaction TOTAMT data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdateTPSTS(String cid,String tid,String status,Double balamt,Double paidamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update CstTrnPay Set status = ? where cid = ? AND tid = ?");
            ps.setString(1, status);
            ps.setString(2, cid);
            ps.setString(3, tid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Updating Transaction TOTAMT data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdateCPS(String cid,String product,Date soldate)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update CstPrdSell Set status = ? where cid = ? AND product = ? AND soldate = ?");
            ps.setString(1, "Get");
            ps.setString(2, cid);
            ps.setString(3, product);
            ps.setDate(4, soldate);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Updating Transaction TOTAMT data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
}
