/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.Services;

/**
 *
 * @author Dell-PC
 */
import Admin.DataBase.DBConnect;
import Transaction.model.Tranpay_mod;
import Transaction.model.Trancst_model;
import Transaction.model.Trantrs_mod;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
public class Transervices
{
    boolean flag=false;
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    List lst=null;
    Transaction.model.Trancst_model gsm=null;
    Trantrs_mod gtm=null;
    Tranpay_mod paym=null;
    public boolean savecst(String cid, String cname, String address, String phno,String cpic,String vid, String vdetails, String vaddress, String v_phno,String vpic) {
        try
        {
            Double a=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into Customer values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, cname);
            ps.setString(3, address);
            ps.setString(4, phno);
            ps.setString(5, cpic);
            ps.setString(6, vid);
            ps.setString(7, vdetails);
            ps.setString(8, vaddress);
            ps.setString(9, v_phno);
            ps.setString(10, vpic);
            ps.setDouble(11, a);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean Updatecst(String cid, String cname, String address, String phno,String cpic,String vid, String vdetails, String vaddress, String v_phno,String vpic) {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Update Customer SET cname = ?, address = ?, ph_no = ?, cpic = ?, vitid = ?, v_name = ?, v_address = ?, v_phno = ?, vpic = ? where c_id = ?");
            ps.setString(1, cname);
            ps.setString(2, address);
            ps.setString(3, phno);
            ps.setString(4, cpic);
            ps.setString(5, vid);
            ps.setString(6, vdetails);
            ps.setString(7, vaddress);
            ps.setString(8, v_phno);
            ps.setString(9, vpic);
            ps.setString(10, cid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }//String cid,String tid,Date gdate, String item, Double weight, Double intrst, Double g_amt,Date rdate,Double ramt                                                                                                                                                                                //mak_chrg tax totamt
    public boolean Trnsave(String cid,String tid,Date gdate, String item, Double weight, Double intrst, Double g_amt,Date rtnDat)
    {
        try
        {
            Double d=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into Transaction values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setDate(3, gdate);
            ps.setString(4, item);
            ps.setDouble(5, weight);
            ps.setDouble(6, intrst);
            ps.setDouble(7, g_amt);
            ps.setDate(8, null);
            ps.setDouble(9, d);
            ps.setString(10, "Opened");
            ps.setDate(11, rtnDat);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean AllTrnUpdate(String cid,String tid,Date gdate, String item, Double weight, Double intrst, Double g_amt,Date rtnDat)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Update Transaction SET gdat = ?,item = ?, weight = ?, interest = ?, given_amt = ?, status = ?,rtndat=? where cid = ? AND trnsid = ?");
            ps.setDate(1, gdate);
            ps.setString(2, item);
            ps.setDouble(3, weight);
            ps.setDouble(4, intrst);
            ps.setDouble(5, g_amt);
            ps.setString(6, "Opened");
              ps.setDate(7, rtnDat);
            ps.setString(8, cid);
            ps.setString(9, tid);

            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
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
        {System.out.println("Next ID or Admno :"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public List getNxtVid()
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT vitid FROM Customer");
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("vitid");
                lst.add(cod);
            }
        }catch(Exception e)
        {System.out.println("Next ID or Admno :"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
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
        }catch(Exception e){System.out.println("Gold item code :"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e1){System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public List getcustNam()
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT cname FROM Customer order by cname");
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("cname");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){System.out.println("Gold item code :"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e1){System.out.println("Gold item code Expt :"+e1);}}
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
            ps=conn.prepareStatement("SELECT cname FROM Customer order by cname asc");
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("cname");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){System.out.println("Gold item code :"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e1){System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public Trancst_model viewbycid(String id)
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
                gsm=new Trancst_model(rs.getString("c_id"),rs.getString("cname"),rs.getString("address"),rs.getString("ph_no"),rs.getString("cpic"),rs.getString("vitid"),rs.getString("v_name"),rs.getString("v_address"),rs.getString("v_phno"),rs.getString("vpic"),rs.getDouble("totamt"));
            }
            return gsm;
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gsm;
    }

    public Trancst_model viewbyName(String nam)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT * FROM Customer where cname = ?");
            ps.setString(1, nam);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gsm=new Trancst_model(rs.getString("c_id"),rs.getString("cname"),rs.getString("address"),rs.getString("ph_no"),rs.getString("cpic"),rs.getString("vitid"),rs.getString("v_name"),rs.getString("v_address"),rs.getString("v_phno"),rs.getString("vpic"),rs.getDouble("totamt"));
            }
            return gsm;
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gsm;
    }
    public Trantrs_mod viewbyc_id(String id)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Transaction where  cid = ?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Trantrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("gdat"),rs.getString("item"),rs.getDouble("weight"),rs.getDouble("interest"),rs.getDouble("given_amt"),rs.getDate("rdate"),rs.getDouble("rec_amt"),rs.getString("status"),rs.getDate("rtnDat"));
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "---"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gtm;
    }
    public List GenTRtab(String id)
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Transaction where  cid = ?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Trantrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("gdat"),rs.getString("item"),rs.getDouble("weight"),rs.getDouble("interest"),rs.getDouble("given_amt"),rs.getDate("rdate"),rs.getDouble("rec_amt"),rs.getString("status"),rs.getDate("rtnDat"));
                lst.add(gtm);
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "---"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return lst;
    }
    public List dayPayRepo(String dt)
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Transaction where  rtndat=? and rec_amt=?");
            ps.setString(1, dt);
            ps.setDouble(2, 0);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Trantrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("gdat"),rs.getString("item"),rs.getDouble("weight"),rs.getDouble("interest"),rs.getDouble("given_amt"),rs.getDate("rdate"),rs.getDouble("rec_amt"),rs.getString("status"),rs.getDate("rtnDat"));
                lst.add(gtm);
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "---"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return lst;
    }
    public Trantrs_mod getAllItmfromTab(String id,String tid)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Transaction where  cid = ? and trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                gtm=new Trantrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("gdat"),rs.getString("item"),rs.getDouble("weight"),rs.getDouble("interest"),rs.getDouble("given_amt"),rs.getDate("rdate"),rs.getDouble("rec_amt"),rs.getString("status"),rs.getDate("rtnDat"));
            }
            return gtm;
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,""+e+"  From Table search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return gtm;
    }
    public List getNxtTid(String cid)
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT trnsid  FROM Transaction where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("trnsid");
                lst.add(cod);
            }
        }catch(Exception e){System.out.println("Next ID or Admno :"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public List getNxtPid(String cid,String tid)
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT pid  FROM Payment where cid = ? AND tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("pid");
                lst.add(cod);
            }
        }catch(Exception e){System.out.println("Next ID or Admno :"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public boolean UpdateTrn(String cid,String tid,Date rdate,Double r_amt)
    {
        try
        {
            String p="Closed";
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Update Transaction Set rdate = ?, rec_amt = ?, status = ? where cid = ? And trnsid = ?");
            ps.setDate(1, rdate);
            ps.setDouble(2, r_amt);
            ps.setString(3, p);
            ps.setString(4, cid);
            ps.setString(5, tid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean DelTrn(String cid,String tid)
    {
        try
        {
            Double d=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Delete From Transaction where cid = ? And trnsid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public List getTid(String cid)
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=conn.prepareStatement("SELECT trnsid FROM Transaction where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("trnsid");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){System.out.println("Gold item code :"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e1){System.out.println("Gold item code Expt :"+e1);}}
        return lst;
    }
    public boolean updatecst(String cid, double tot) {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("update Customer set totamt = ? where c_id = ?");
            ps.setDouble(1, tot);
            ps.setString(2, cid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public List GenPaytab(String cid,String tid)
    {
        lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Payment where  cid = ? And tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                paym=new Tranpay_mod(rs.getString("cid"),rs.getString("tid"),rs.getString("pid"),rs.getDouble("totamt"),rs.getDouble("pamt"),rs.getString("payee"),rs.getDate("pdate"));
                lst.add(paym);
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "---"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return lst;
    }
    public Tranpay_mod GenPayDATA(String cid,String tid,String pid)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from Payment where  cid = ? And tid = ? AND pid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, pid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                paym=new Tranpay_mod(rs.getString("cid"),rs.getString("tid"),rs.getString("pid"),rs.getDouble("totamt"),rs.getDouble("pamt"),rs.getString("payee"),rs.getDate("pdate"));
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "---"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return paym;
    }

    public boolean Savepay(String cid,String tid,String pid,Double totamt,Double pamt,String payee,Date pdat)
    {
        try
        {
            Double d=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into Payment values(?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, pid);
            ps.setDouble(4, totamt);
            ps.setDouble(5, pamt);
            ps.setString(6, payee);
            ps.setDate(7, pdat);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean UpdatePay(String cid,String tid,String pid,Double totamt,Double pamt,String payee,Date pdat)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("Update Payment set totamt = ?, pamt = ?, payee = ?, pdate = ? Where cid = ? AND tid = ? AND pid = ?");
            ps.setDouble(1, totamt);
            ps.setDouble(2, pamt);
            ps.setString(3, payee);
            ps.setDate(4, pdat);
            ps.setString(5, cid);
            ps.setString(6, tid);
            ps.setString(7, pid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean UpdateTrs(String cid,String tid,Date pdat,Double pamt)
    {
        try
        {
            Double d=0.0;
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into Payment values(?,?,?,?,?,?,?)");
            ps.setDouble(5, pamt);
            ps.setDate(7, pdat);
            ps.setString(1, cid);
            ps.setString(2, tid);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0){flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally{try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
}