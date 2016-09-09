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
import Sales.model.CstAmt_mod;
import Sales.model.Goldpay_mod;
import Sales.model.Goldcst_model;
import Sales.model.Goldtrs_mod;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
public class Goldservices
{
    boolean flag=false;
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    List lst=null;
    Sales.model.Goldcst_model gsm=null;
    Sales.model.Goldpay_mod gtn=null;
    Goldtrs_mod gtm=null;
    CstAmt_mod gam = null;
    public boolean goldsalesave(String cid, String cname, String address, String city, String phno, String pdetails, String paddress, String pcity, String p_phno,Date trans_date,String img1,String img2,String idp1,String idp2) {
        try
        {
            Double a=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, cname);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, phno);
            ps.setString(6, pdetails);
            ps.setString(7, paddress);
            ps.setString(8, pcity);
            ps.setString(9, p_phno);
            ps.setDate(10, trans_date);
            ps.setString(11, img1);
            ps.setString(12, img2);
            ps.setString(13, idp1);
            ps.setString(14, idp2);
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
    public boolean goldsaleUpdate(String cid, String cname, String address, String city, String phno, String pdetails, String paddress, String pcity, String p_phno,Date trans_date,String img1,String img2,String idp1,String idp2) {
        try
        {
            Double a=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Update Customer set cname = ?, address = ?, city = ?, ph_no = ?, p_details = ?, p_address = ?, p_city = ?, p_phno = ?, tras_dat = ?, img1 = ?, img2 = ?, idp1 = ?, idp2 = ? where c_id = ?");
            ps.setString(1, cname);
            ps.setString(2, address);
            ps.setString(3, city);
            ps.setString(4, phno);
            ps.setString(5, pdetails);
            ps.setString(6, paddress);
            ps.setString(7, pcity);
            ps.setString(8, p_phno);
            ps.setDate(9, trans_date);
            ps.setString(10, img1);
            ps.setString(11, img2);
            ps.setString(12, idp1);
            ps.setString(13, idp2);
            ps.setString(14, cid);
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
    }  //mak_chrg tax totamt
    public boolean billsave(String cid,String tid,String sln,Date t_date, String purch_item, Double goldrate, Double weight, Double wastage, Double mak_chrg, Double tax,Double totamt,double tot_wt,Date r_date) {
        try
        {
            
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into goldsale_payment values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, sln);
            ps.setDate(4, t_date);
            ps.setString(5, purch_item);
            ps.setDouble(6, goldrate);
            ps.setDouble(7, weight);
            ps.setDouble(8, wastage);
            ps.setDouble(9, mak_chrg);
            ps.setDouble(10, tax);
            ps.setDouble(11, totamt);
            ps.setDouble(12, tot_wt);
            ps.setDate(13, r_date);
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
    public boolean billUpdate(String cid,String tid,String sln,Date t_date, String purch_item, Double goldrate, Double weight, Double wastage, Double mak_chrg, Double tax,Double totamt,double tot_wt,Date r_date) {
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("update goldsale_payment set t_date=?, p_item=?,  g_rate=?, weight=?,  wastage=?,  making_chrg=?,  tax=?, tot_amt=?, tot_wt=?, rtndat=? where cid=?  and trnsid=? and slno=?");
            
            ps.setDate(1, t_date);
            ps.setString(2, purch_item);
            ps.setDouble(3, goldrate);
            ps.setDouble(4, weight);
            ps.setDouble(5, wastage);
            ps.setDouble(6, mak_chrg);
            ps.setDouble(7, tax);
            ps.setDouble(8, totamt);
            ps.setDouble(9, tot_wt);
             ps.setDate(10, r_date);

            ps.setString(11, cid);
            ps.setString(12, tid);
            ps.setString(13, sln);
            
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
    public List getNxtcid()
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT c_id FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
                {
                cod=rs.getString("c_id");
                lst.add(cod);
            }

        }catch(Exception e)
        {
            System.out.println("Next ID or Admno :"+e);
        }
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public List getgspTab(String id,String tid)
    {
        lst=new LinkedList();
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM goldsale_payment where  cid = ? AND trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Goldtrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("wastage"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtndat"));
                lst.add(gtm);
            }
        }catch(Exception e)
        {System.out.println("student data"+e);}
        finally
        {
            try
            {
                conn.close();
                System.out.println("colse done....");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lst;
    }

    public List getcustid()
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT c_id FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
                {
                nam=rs.getString("c_id");
                lst.add(nam);
            }
            return lst;

        }catch(Exception e)
        {System.out.println("Gold item code :"+e);}
        finally
        {
            try
            {conn.close();System.out.println("close..");}
            catch(Exception e1)
            {System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public List getNames()
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT cname FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
                {
                nam=rs.getString("cname");
                lst.add(nam);
            }
            return lst;

        }catch(Exception e)
        {System.out.println("Gold item code :"+e);}
        finally
        {
            try
            {conn.close();System.out.println("close..");}
            catch(Exception e1)
            {System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public Goldcst_model viewbycid(String id)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT * FROM Customer where c_id = ?");
            ps.setString(1, id);
            System.out.println("  .."+id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gsm=new Goldcst_model(rs.getString("c_id"),rs.getString("cname"),rs.getString("address"),rs.getString("city"),rs.getString("ph_no"),rs.getString("p_details"),rs.getString("p_address"),rs.getString("p_city"),rs.getString("p_phno"),rs.getDate("tras_dat"),rs.getString("img1"),rs.getString("img2"),rs.getString("idp1"),rs.getString("idp2"));
            }
            return gsm;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gsm;
    }
    public Goldcst_model viewbyName(String cname)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT * FROM Customer where cname = ?");
            ps.setString(1, cname);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gsm=new Goldcst_model(rs.getString("c_id"),rs.getString("cname"),rs.getString("address"),rs.getString("city"),rs.getString("ph_no"),rs.getString("p_details"),rs.getString("p_address"),rs.getString("p_city"),rs.getString("p_phno"),rs.getDate("tras_dat"),rs.getString("img1"),rs.getString("img2"),rs.getString("idp1"),rs.getString("idp2"));
            }
            return gsm;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gsm;
    }
    public Goldtrs_mod viewbyc_id(String id)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from goldsale_payment where  cid = ?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Goldtrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("wastage"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtndat"));
            }
        }
        catch(Exception e){}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gtm;
    }
    public Goldtrs_mod getAllItmfromTab(String id,String tid,String slno)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from goldsale_payment where  cid = ? and trnsid = ? And slno = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            ps.setString(3, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Goldtrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("wastage"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtndat"));
            }
            return gtm;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gtm;
    }

    public boolean messagesave(String id, String name, String message,String dat)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into messagedata values(?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, message);
            ps.setString(4, dat);
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

    public boolean updateAMTdata(String cid,String tid, Double tot, Double bal) {
        try
        {
            conn=new DBConnect().GetConnetion();
            System.out.println("  "+tot+"  "+bal+"  "+cid);
            ps=conn.prepareStatement("UPDATE GTrans_data SET total_amt = ?, bal_amt = ? WHERE cust_id= ? And trans_id = ?");
            ps.setDouble(1,tot);
            ps.setDouble(2, bal);
            ps.setString(3,cid);
            ps.setString(4,tid);
            int n=ps.executeUpdate();
            if(n!=0)
            {
                flag=true;
            }
            return flag;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"update"+e);
        }
        finally
        {
            try{
                conn.close();
                System.out.println("colse done....");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
      return flag;
    }

    public boolean savepayment(String cid,String tid, Date tdat, Double na, Double ba, int pid, Double pamt, Date paydate)
    {
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into gold_trans values(?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setDate(3, (Date) tdat);
            ps.setDouble(4, na);
            ps.setDouble(5, ba);
            ps.setInt(6, pid);
            ps.setDouble(7, pamt);
            ps.setDate(8, paydate);
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
    public List getNxtpid(String id,String tid)
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT cid FROM gold_trans where cid=? and trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
                {
                cod=rs.getString("cid");
                lst.add(cod);
            }

        }catch(Exception e)
        {
            System.out.println("Next ID or Admno :"+e);
        }
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public List getpayTab(String id, String tid)
    {
        lst=new LinkedList();
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM gold_trans where cid = ? AND trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            System.out.println("execute..");
            while(rs.next())
            {
                gtn=new Goldpay_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("t_dat"),rs.getDouble("net_amt"),rs.getDouble("bal"),rs.getInt("pid"),rs.getDouble("paid_amt"),rs.getDate("paid_date"));
                lst.add(gtn);
            }
        }catch(Exception e)
        {System.out.println("student data"+e);}
        finally
        {
            try
            {
                conn.close();
                System.out.println("colse done....");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lst;
    }
    public List getPlace()
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT distinct(city) as ct FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
                {
                nam=rs.getString("ct");
                lst.add(nam);
            }
            return lst;

        }catch(Exception e)
        {System.out.println("Gold item code :"+e);}
        finally
        {
            try
            {conn.close();System.out.println("close..");}
            catch(Exception e1)
            {System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public List getTid(String cid)
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT distinct(trnsid) as tid FROM goldsale_payment where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
                {
                nam=rs.getString("tid");
                lst.add(nam);
            }
            return lst;

        }catch(Exception e)
        {System.out.println("Gold item code :"+e);}
        finally
        {
            try
            {conn.close();System.out.println("close..");}
            catch(Exception e1)
            {System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public CstAmt_mod getamt(String cid,String tid)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT * FROM GTrans_data where cust_id =? And trans_id = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gam=new CstAmt_mod(rs.getString("cust_id"),rs.getString("trans_id"),rs.getDouble("total_amt"),rs.getDouble("bal_amt"));
            }
            return gam;
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gam;
    }
    public List getNxtTid(String cid)
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT distinct(trnsid) as tid FROM goldsale_payment where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
                {
                cod=rs.getString("tid");
                lst.add(cod);
            }

        }catch(Exception e)
        {
            System.out.println("Next ID or Admno :"+e);
        }
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public boolean Transsave(String cid, String tid)
    {
        try
        {
            Double d=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into GTrans_data values(?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setDouble(3, d);
            ps.setDouble(4, d);
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
    public List getCount(String cid,String tid)
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT slno  FROM goldsale_payment where cid = ? And trnsid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
                {
                cod=rs.getString("slno");
                lst.add(cod);
            }

        }catch(Exception e)
        {
            System.out.println("Next ID or Admno :"+e);
        }
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public boolean TransDel(String cid, String tid, String sln)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Delete from goldsale_payment where cid = ? And trnsid = ? And slno = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, sln);
            int no=ps.executeUpdate();
            if(no>0)
            {
                flag=true;
            }
        }catch(Exception e)
        {JOptionPane.showMessageDialog(null, "Delete Failed"+e);
        }
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }

    //Day Report Data
    //Gold
    public List goldTransDayDetails(String rdat)
    {
        lst=new LinkedList();
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM goldsale_payment where rtnDat = ? order by cid asc");
            ps.setString(1, rdat);

            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Goldtrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("wastage"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtndat"));
                lst.add(gtm);
            }
        }catch(Exception e)
        {System.out.println("student data"+e);}
        finally
        {
            try
            {
                conn.close();
                System.out.println("colse done....");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lst;
    }
    public List getGldTransTab(String id)
    {
         lst=new LinkedList();
        try
        {

            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM goldsale_payment where  cid = ?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Goldtrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("wastage"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtndat"));
                lst.add(gtm);
            }
        }catch(Exception e)
        {System.out.println("student data"+e);}
        finally
        {
            try
            {
                conn.close();
                System.out.println("colse done....");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lst;
    }
   
    


}