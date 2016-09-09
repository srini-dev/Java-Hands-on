/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms.Services;

import Admin.Database.DBConnect;
import Forms.Models.CstPrdSellModel;
import Forms.Models.PayModel;
import Forms.Models.PrdActModel;
import Forms.Models.PrdInvModel;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class PrdWiseSrvs
{
    Connection con=null;
    Statement st=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    boolean flag=false;
    List lst=null;
    PrdInvModel pim=null;
    PrdActModel pam= null;
    CstPrdSellModel psm=null;
    PayModel paym=null;
    //------------------------------Product Invoice Starts-----------------------------------------
    public boolean savePrsInv(String cid, String slno,String icode,String iname,String pack,Date pidate,String pstatus)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into CstPrdInv values(?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, slno);
            ps.setString(3, icode);
            ps.setString(4, iname);
            ps.setString(5, pack);
            ps.setDate(6, pidate);
            ps.setString(7, pstatus);
            ps.setString(8, "Opened");
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdInv data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean updatePrsInv(String cid, String slno,String icode,String iname,String pack,String pstatus)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update CstPrdInv Set icode = ?, iname = ?, pack = ?, pstatus = ? where cid= ? and slno = ?");
            ps.setString(1, icode);
            ps.setString(2, iname);
            ps.setString(3, pack);
            ps.setString(4, pstatus);
            ps.setString(5, cid);
            ps.setString(6, slno);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdInv data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean updatePSTS(String cid, String slno,String status)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update CstPrdInv Set status = ? where cid= ? and slno = ?");
            ps.setString(1, status);
            ps.setString(2, cid);
            ps.setString(3, slno);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdInv data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getNextPslno(String cid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT slno FROM CstPrdInv Where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("slno");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getIcodes(String cid,String status)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT icode FROM CstPrdInv Where cid= ? AND status = ?");
            ps.setString(1, cid);
            ps.setString(2, status);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("icode");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    public List getPrdInvTab()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdInv");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pim=new PrdInvModel(rs.getString("cid"),rs.getString("slno"),rs.getString("icode"),rs.getString("iname"),rs.getString("pack"),rs.getDate("pidate"),rs.getString("pstatus"),rs.getString("status"));
                lst.add(pim);
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public PrdInvModel getPrdInv()
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdInv");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pim=new PrdInvModel(rs.getString("cid"),rs.getString("slno"),rs.getString("icode"),rs.getString("iname"),rs.getString("pack"),rs.getDate("pidate"),rs.getString("pstatus"),rs.getString("status"));
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pim;
    }
    public PrdInvModel getPrdInvBic(String cid,String icode,String status)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdInv Where cid = ? AND icode = ? And status = ?");
            ps.setString(1, cid);
            ps.setString(2, icode);
            ps.setString(3, status);
            rs=ps.executeQuery();
            while(rs.next())
            {
                pim=new PrdInvModel(rs.getString("cid"),rs.getString("slno"),rs.getString("icode"),rs.getString("iname"),rs.getString("pack"),rs.getDate("pidate"),rs.getString("pstatus"),rs.getString("status"));
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,"Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pim;
    }
    //------------------------------Product Invoice ends-----------------------------------------

    //------------------------------Product Action Starts-----------------------------------------
    public boolean savePrsAct(String cid,String aid, String slno,String product,Date asdate,Double acamt,String acstatus,Date aenddate,Double prdwgt,Double qrate,String status,String pslno)
    {
        try
        {
            JOptionPane.showMessageDialog(null, "ALL DATA = "+cid+aid+slno+product+asdate+acamt+acstatus+aenddate+prdwgt+qrate+status+pslno);
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into CstPrdAction values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, aid);
            ps.setString(3, slno);
            ps.setString(4, product);
            ps.setDate(5, asdate);
            ps.setDouble(6, acamt);
            ps.setString(7, acstatus);
            ps.setDate(8, aenddate);
            ps.setDouble(9, prdwgt);
            ps.setDouble(10, qrate);
            ps.setString(11, status);
            ps.setString(12, pslno);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdInv data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdtActSTS(String cid,String aid,String status)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update CstPrdAction Set status = ? where cid = ? AND aid = ?");
            ps.setString(1, status);
            ps.setString(2, cid);
            ps.setString(3, aid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In Update CstPrdInv data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public List getNextActno(String cid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT Distinct(aid) as acid FROM CstPrdAction Where cid = ?");
            ps.setString(1, cid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("acid");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getNextAslno(String cid,String aid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT slno FROM CstPrdAction Where cid = ? AND aid = ?");
            ps.setString(1, cid);
            ps.setString(2, aid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("slno");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getAIDcmb(String cid,String status)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT Distinct(aid) as acid FROM CstPrdAction Where cid= ? AND status = ?");
            ps.setString(1, cid);
            ps.setString(2, status);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("acid");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    public List getPRDcmb(String cid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT Distinct(product) as prd FROM CstPrdSell Where cid= ? AND status = ?");
            ps.setString(1, cid);
            ps.setString(2, "NotGet");
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("prd");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error From Tid Cmb"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }

    public List getPrdActTab()
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdAction");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pam=new PrdActModel(rs.getString("cid"),rs.getString("aid"),rs.getString("slno"),rs.getString("product"),rs.getDate("asdate"),rs.getDouble("acamt"),rs.getString("acstatus"),rs.getDate("aenddat"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getString("status"),rs.getString("pslno"));
                lst.add(pam);
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return lst;
    }
    public PrdActModel getPrdAct()
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdAction");
            rs=ps.executeQuery();
            while(rs.next())
            {
                pam=new PrdActModel(rs.getString("cid"),rs.getString("aid"),rs.getString("slno"),rs.getString("product"),rs.getDate("asdate"),rs.getDouble("acamt"),rs.getString("acstatus"),rs.getDate("aenddat"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getString("status"),rs.getString("pslno"));
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pam;
    }
    
    public PrdActModel getPrdActBypno(String cid,String pslno,String slno)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdAction Where cid = ? AND pslno = ? AND slno = ?");
            ps.setString(1, cid);
            ps.setString(2, pslno);
            ps.setString(3, slno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                pam=new PrdActModel(rs.getString("cid"),rs.getString("aid"),rs.getString("slno"),rs.getString("product"),rs.getDate("asdate"),rs.getDouble("acamt"),rs.getString("acstatus"),rs.getDate("aenddat"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getString("status"),rs.getString("pslno"));
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pam;
    }
    public PrdActModel getPrdActno(String cid,String pslno)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdAction Where cid = ? AND pslno = ?");
            ps.setString(1, cid);
            ps.setString(2, pslno);
            rs=ps.executeQuery();
            while(rs.next())
            {
                pam=new PrdActModel(rs.getString("cid"),rs.getString("aid"),rs.getString("slno"),rs.getString("product"),rs.getDate("asdate"),rs.getDouble("acamt"),rs.getString("acstatus"),rs.getDate("aenddat"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getString("status"),rs.getString("pslno"));
            }
        }
        catch(Exception e){System.out.println("Reason Table"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return pam;
    }
    //------------------------------Product Action ends-----------------------------------------

    //------------------------------Product Selling Starts---------------------------------------------
    public boolean savePrsSell(String cid,String aid,String product, Date soldate,Double prdwgt,Double qrate,Double totamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into CstPrdSell values(?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, aid);
            ps.setString(3, product);
            ps.setDate(4, soldate);
            ps.setDouble(5, prdwgt);
            ps.setDouble(6, qrate);
            ps.setDouble(7, totamt);
            ps.setString(8, "NotGet");
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdSell data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public CstPrdSellModel getPrdActBP(String cid,String product,Date soldate)
    {
        try
        {
            String sts="NotGet";
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdSell where cid = ?  AND soldate = ? AND product = ? AND status = ?");
            ps.setString(1, cid);
            ps.setDate(2, soldate);
            ps.setString(3, product);
            ps.setString(4, sts);
            rs=ps.executeQuery();
            while(rs.next())
            {
                psm=new CstPrdSellModel(rs.getString("cid"),rs.getString("acid"),rs.getString("product"),rs.getDate("soldate"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getDouble("totamt"),rs.getString("status"));
            }
        }
        catch(Exception e){System.out.println("Error"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return psm;
    }
    public CstPrdSellModel getPrdActBD(String cid,Date soldate)
    {
        try
        {
            String sts="NotGet";
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdSell where cid = ? AND soldate = ? AND status = ?");
            ps.setString(1, cid);
            ps.setDate(2, soldate);
            ps.setString(3, sts);
            rs=ps.executeQuery();
            while(rs.next())
            {
                psm=new CstPrdSellModel(rs.getString("cid"),rs.getString("acid"),rs.getString("product"),rs.getDate("soldate"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getDouble("totamt"),rs.getString("status"));
            }
        }
        catch(Exception e){System.out.println("Error"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return psm;
    }
    public CstPrdSellModel getPrdSellBD(String cid,String acid)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from CstPrdSell where cid = ? AND acid = ?");
            ps.setString(1, cid);
            ps.setString(2, acid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                psm=new CstPrdSellModel(rs.getString("cid"),rs.getString("acid"),rs.getString("product"),rs.getDate("soldate"),rs.getDouble("prdwgt"),rs.getDouble("qrate"),rs.getDouble("totamt"),rs.getString("status"));
            }
        }
        catch(Exception e){System.out.println("Error"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return psm;
    }
    public List getDATEcmb(String cid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT soldate FROM CstPrdSell Where cid= ? AND status = ?");
            ps.setString(1, cid);
            ps.setString(2, "NotGet");
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=String.valueOf(rs.getDate("soldate"));
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    //---------------------------------------Payment ------------------------------------------------

    public boolean savePrdPay(String cid,String pid, Date paydate,String solddate,String product,Double prdamt,String tid,Double trnamt,Double intrest,Double wtintrst,Double dueamt,Double returnamt,String pname,Double bcamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("insert into Payment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cid);
            ps.setString(2, pid);
            ps.setDate(3, paydate);
            ps.setString(4, solddate);
            ps.setString(5, product);
            ps.setDouble(6, prdamt);
            ps.setString(7, tid);
            ps.setDouble(8, trnamt);
            ps.setDouble(9, intrest);
            ps.setDouble(10, wtintrst);
            ps.setDouble(11, dueamt);
            ps.setDouble(12, returnamt);
            ps.setString(13, pname);
            ps.setDouble(14, bcamt);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdSell data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    public boolean UpdatePrdPay(String cid,String pid, String solddate,String product,Double prdamt,String tid,Double trnamt,Double intrest,Double wtintrst,Double dueamt,Double returnamt,String pname,Double bcamt)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("Update Payment Set soldate = ?, product = ?, prdamt = ?, tid = ?, trnamt = ?, intrest = ?, wtintrst = ?, dueamt = ?, returnamt = ?, pname = ?, bcamt = ?");
            ps.setString(1, solddate);
            ps.setString(2, product);
            ps.setDouble(3, prdamt);
            ps.setString(4, tid);
            ps.setDouble(5, trnamt);
            ps.setDouble(6, intrest);
            ps.setDouble(7, wtintrst);
            ps.setDouble(8, dueamt);
            ps.setDouble(9, returnamt);
            ps.setString(10, pname);
            ps.setDouble(11, bcamt);
            ps.setString(12, cid);
            ps.setString(13, pid);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e){JOptionPane.showMessageDialog(null,"Erorr In saving CstPrdSell data "+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return flag;
    }
    
    public List NxtPslno(String cid,String tid)
    {
      lst= new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String cod;
            ps= con.prepareStatement("SELECT pid FROM Payment Where cid = ? AND tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cod=rs.getString("pid");
                lst.add(cod);
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "erorr At Next Cid"+e);}
        finally{try{con.close();System.out.println("closedone..");}catch(Exception e){JOptionPane.showMessageDialog(null,"Connection Closing Error"+e);}}
        return lst;
    }
    public List getPIDcmb(String cid,String tid)
    {
        lst=new LinkedList();
        try
        {
            con=new DBConnect().GetConnetion();
            String nam;
            lst.add("-Select-");
            ps=con.prepareStatement("SELECT pid FROM Payment Where cid = ? AND tid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                nam=rs.getString("pid");
                lst.add(nam);
            }
            return lst;
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Error"+e);}
        finally
        {try{con.close();System.out.println("close..");}catch(Exception e1){JOptionPane.showMessageDialog(null, "Error in closing from transaction  Tid cmb"+e1);}}
        return lst;
    }
    public PayModel getPayData(String cid,String tid,String pid)
    {
        try
        {
            con=new DBConnect().GetConnetion();
            ps=con.prepareStatement("select * from Payment where cid = ? AND tid = ? AND pid = ?");
            ps.setString(1, cid);
            ps.setString(2, tid);
            ps.setString(3, pid);
            rs=ps.executeQuery();
            while(rs.next())
            {
                paym=new PayModel(rs.getString("cid"),rs.getString("pid"),rs.getDate("paydate"),rs.getString("solddate"),rs.getString("product"),rs.getDouble("prdamt"),rs.getString("tid"),rs.getDouble("trnamt"),rs.getDouble("intrest"),rs.getDouble("wtintrst"),rs.getDouble("dueamt"),rs.getDouble("returnamt"),rs.getString("pname"),rs.getDouble("bcamt"));
            }
        }
        catch(Exception e){System.out.println("Error"+e);}
        finally{try{con.close();System.out.println("colse done....");}catch(Exception e){JOptionPane.showMessageDialog(null,"Table"+e);}}
        return paym;
    }
}
