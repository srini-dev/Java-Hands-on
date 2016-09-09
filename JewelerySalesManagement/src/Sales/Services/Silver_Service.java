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
import Sales.model.Silvercst_model;
import Sales.model.Silverpay_mod;
import Sales.model.Silvertrs_mod;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;
public class Silver_Service
{
    boolean flag=false;
    Connection conn=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    List lst=null;
    Silvertrs_mod stm=null;
    Silvercst_model ssm=null;
    Silverpay_mod spm=null;
    CstAmt_mod cam=null;
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
            if(no>0){flag=true;}
        }catch(Exception e)
        {System.out.println("00000000"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }                                                                                                                                                                                                 //mak_chrg tax totamt
    public boolean billsave(String cid,String tid,String sln,Date t_date, String purch_item, Double silrate, Double weight, Double mak_chrg, Double tax,Double totamt,Double tot_wt,Date rtnDat) {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into silversale_payment values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, sln);
            ps.setDate(4, t_date);
            ps.setString(5, purch_item);
            ps.setDouble(6, silrate);
            ps.setDouble(7, weight);
            ps.setDouble(8, mak_chrg);
            ps.setDouble(9, tax);
            ps.setDouble(10, totamt);
            ps.setDouble(11, tot_wt);
            ps.setDate(12, rtnDat);
            int no=ps.executeUpdate();
            System.out.print("exceute");
            if(no>0)
            {flag=true;}
        }catch(Exception e)
        {System.out.println("00000000"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public boolean billUpdate(String cid,String tid,String sln,Date t_date, String purch_item, Double silrate, Double weight, Double mak_chrg, Double tax,Double totamt,Double tot_wt,Date rtnDat) {
        try
        {
            conn=DBConnect.GetConnetion();
            ps=conn.prepareStatement("UPDATE silversale_payment SET t_date = ?, p_item = ?,  s_rate = ?, weight = ?,  making_chrg = ?,  tax = ?, tot_amt = ?, tot_wt = ?, rtnDat = ? where cid = ?  AND trnsid = ? AND slno = ?");
            System.out.println("123"+cid+"  "+tid+"  "+sln);
            ps.setDate(1, t_date);
            ps.setString(2, purch_item);
            ps.setDouble(3, silrate);
            ps.setDouble(4, weight);
            ps.setDouble(5, mak_chrg);
            ps.setDouble(6, tax);
            ps.setDouble(7, totamt);
            ps.setDouble(8, tot_wt);
            ps.setDate(9, rtnDat);
            ps.setString(10, cid);
            ps.setString(11, tid);
            ps.setString(12, sln);
            
            int no=ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Done "+no);
            if(no>0)
            {flag=true; System.out.print("exceute");}
        }catch(Exception e)
        {System.out.println("00000000"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
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
        }catch(Exception e){System.out.println("Next ID or Admno :"+e);}
        finally{try{conn.close();System.out.println("close...");}catch(Exception e1){System.out.println("........."+e1);}}
        return lst;
    }
    public List getgspTab(String id,String tid)
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM silversale_payment where  cid = ? AND trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                stm=new Silvertrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("s_rate"),rs.getDouble("weight"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtnDat"));
                lst.add(stm);
            }
        }catch(Exception e){System.out.println("Silver"+e);}
        finally
        {try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
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
        {System.out.println("Silver item code :"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e1){System.out.println("Silver item code Expt :"+e1);}}
        return lst;
    }
    public Silvercst_model viewbycid(String id)
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
                ssm=new Silvercst_model(rs.getString("c_id"),rs.getString("cname"),rs.getString("address"),rs.getString("city"),rs.getString("ph_no"),rs.getString("p_details"),rs.getString("p_address"),rs.getString("p_city"),rs.getString("p_phno"),rs.getDate("tras_dat"),rs.getString("img1"),rs.getString("img2"),rs.getString("idp1"),rs.getString("idp2"));
            }
            return ssm;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return ssm;
    }
    public Silvertrs_mod viewbyc_id(String id)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from silversale_payment where  cid = ?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                stm=new Silvertrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("g_rate"),rs.getDouble("weight"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtnDat"));
            }
        }
        catch(Exception e){}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return stm;
    }
    public Silvertrs_mod getAllItmfromTab(String id,String tid,String slno)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("select * from silversale_payment where  cid = ? and trnsid = ? And slno = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            ps.setString(3, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                stm=new Silvertrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("s_rate"),rs.getDouble("weight"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtnDat"));
            }
            return stm;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return stm;
    }


    public boolean updateAMTdata(String cid,String tid, Double tot, Double bal) {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("UPDATE STrans_data SET total_amt = ?, bal_amt = ? WHERE cust_id= ? And trans_id = ?");
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
        {JOptionPane.showMessageDialog(null,"update"+e);}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return flag;
    }

    public boolean savepayment(String cid,String tid, Date tdat, Double na, Double ba, int pid, Double pamt, Date paydate)
    {
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("insert into silver_trans values(?,?,?,?,?,?,?,?)");
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
            {flag=true;}
        }catch(Exception e){System.out.println("00000000"+e);}
        finally
        {try{conn.close();System.out.println("close..");}catch(Exception e){System.out.println("not closes"+e);}}
        return flag;
    }
    public List getNxtpid(String id,String tid)
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT cid FROM silver_trans where cid=? and trnsid = ?");
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
            ps=conn.prepareStatement("SELECT * FROM silver_trans where cid = ? AND trnsid = ?");
            ps.setString(1, id);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            System.out.println("execute..");
            while(rs.next())
            {
                spm=new Silverpay_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getDate("t_dat"),rs.getDouble("net_amt"),rs.getDouble("bal"),rs.getInt("pid"),rs.getDouble("paid_amt"),rs.getDate("paid_date"));
                lst.add(spm);
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
            ps=conn.prepareStatement("SELECT distinct(trnsid) as tid FROM silversale_payment where cid = ?");
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
            CstAmt_mod cam=null;
            conn=new DBConnect().GetConnetion();
            ps= conn.prepareStatement("SELECT * FROM STrans_data where cust_id =? And trans_id = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            System.out.println("Till......");
            rs=ps.executeQuery();
            System.out.println("Till......");
            while(rs.next())
            {
                cam=new CstAmt_mod(rs.getString("cust_id"),rs.getString("trans_id"),rs.getDouble("total_amt"),rs.getDouble("bal_amt"));
                
            }
            System.out.println(cam.getBal());
            return cam;
        }
        catch(Exception e){try{conn.close();}catch(Exception e1){}JOptionPane.showMessageDialog(null,""+e+"   search failed");}
        finally{try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return cam;
    }
    public List getNxtTid(String cid)
    {

      lst= new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            String cod;
            ps= conn.prepareStatement("SELECT distinct(trnsid) as tid  FROM silversale_payment where cid = ?");
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
            ps=conn.prepareStatement("insert into STrans_data values(?,?,?,?)");
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
            ps= conn.prepareStatement("SELECT slno  FROM silversale_payment where cid = ? And trnsid = ?");
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
            ps=conn.prepareStatement("Delete from silversale_payment where cid = ? And trnsid = ? And slno = ?");
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

    //Main page details

    public List silverTransDayDetails(String rdat)
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM silversale_payment where  t_date = ? order by cid asc");
            ps.setString(1, rdat);
            
            rs=ps.executeQuery();
            while(rs.next())
            {
                stm=new Silvertrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("s_rate"),rs.getDouble("weight"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtnDat"));
                lst.add(stm);
            }
        }catch(Exception e){System.out.println("Silver"+e);}
        finally
        {try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return lst;
    }
    public List silverTransDetails(String cid)
    {
        lst=new LinkedList();
        try
        {
            conn=new DBConnect().GetConnetion();
            ps=conn.prepareStatement("SELECT * FROM silversale_payment where  cid = ? ");
            ps.setString(1, cid);

            rs=ps.executeQuery();
            while(rs.next())
            {
                stm=new Silvertrs_mod(rs.getString("cid"),rs.getString("trnsid"),rs.getString("slno"),rs.getDate("t_date"),rs.getString("p_item"),rs.getDouble("s_rate"),rs.getDouble("weight"),rs.getDouble("making_chrg"),rs.getDouble("tax"),rs.getDouble("tot_amt"),rs.getDate("rtnDat"));
                lst.add(stm);
            }
        }catch(Exception e){System.out.println("Silver"+e);}
        finally
        {try{conn.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null, e);}}
        return lst;
    }

}