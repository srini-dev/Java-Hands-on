/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Purchase.Serices;
import Admin.DataBase.DBConnect;
import Purchase.Model.Payment;
import Purchase.Model.Vouchers;
import java.util.*;
import java.sql.*;

public class PurchaseServices {


   List lst=null;
    boolean flag=false;
    Connection con;
    PreparedStatement ps=null;
    Statement st=null;
    ResultSet rs=null;
    DBConnect dbc=null;
    //vouchers(s,s,s,s,s,s,s,s,s,d,s,d,d,d,d,s,s)
    //vno,kst ,cst,tinno,pnam,snam,mft,phon,dat,rate,itm,wt,irat,tax,tot,nar,typ
    public boolean saveGVouchers(String vno, String kst, String cst, String tinno, String pnam, String snam, String mft, String phon, String dat, double rate, String itm, double wt, double irat, double tax, double tot, String nar, String typ)
    {
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            ps=con.prepareStatement("insert into vouchers values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vno);
            ps.setString(2,kst);
            ps.setString(3 ,cst);
            ps.setString(4,tinno);
            ps.setString(5,pnam);
            ps.setString(6,snam);
            ps.setString(7,mft);
            ps.setString(8,phon);
            ps.setString(9,dat);
            ps.setDouble(10,rate);
            ps.setString(11,itm);
            ps.setDouble(12,wt);
            ps.setDouble(13,irat);
            ps.setDouble(14,tax);
            ps.setDouble(15,tot);
            ps.setString(16,nar);
            ps.setString(17,typ);
            


            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            System.out.println("Vouchers Expt :"+e);
        }
        finally{try{con.close();}catch(Exception e1){}}
        return flag;
    }

    public boolean ModGVouchers(String vno, double rate, String itm, double wt, double irat, double tax, double tot, String nar, String typ)
    {
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            ps=con.prepareStatement("update vouchers set rate=?, itm=?, wt=?, irat=?, tax=?,tot=?, nar=? where vno=? and typ=?");
            
            ps.setDouble(1,rate);
            ps.setString(2,itm);
            ps.setDouble(3,wt);
            ps.setDouble(4,irat);
            ps.setDouble(5,tax);
            ps.setDouble(6,tot);
            ps.setString(7,nar);
            ps.setString(8,vno);
            ps.setString(9,typ);
            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            System.out.println("Vouchers Expt :"+e);
        }
        finally{try{con.close();}catch(Exception e1){}}
        return flag;
    }
    public List getTabPurItms(String vn,String typ)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            Vouchers vc=null;
        try
        {
            con=dbc.GetConnetion();
                //vouchers(s,s,s,s,s,s,s,s,s,d,s,d,d,d,d,s,s)
                //vno,kst ,cst,tinno,pnam,snam,mft,phon,dat,rate,itm,wt,irat,tax,tot,nar,typ
                ps=con.prepareStatement("select * from vouchers where vno=? and typ=? ");
                ps.setString(1,vn);
                ps.setString(2,typ);
                rs=ps.executeQuery();

                while(rs.next())
                {
                //,wstg,mkgchrg,tot,dist,gtot
                    vc=new Vouchers(rs.getString("vno"),rs.getString("kst"),rs.getString("cst"),rs.getString("tinno"),rs.getString("pnam"),rs.getString("snam"),rs.getString("mft"),rs.getString("phon"),String.valueOf(rs.getDate("dat")),rs.getDouble("rate"),rs.getString("itm"),rs.getDouble("wt"),rs.getDouble("irat"),rs.getDouble("tax"),rs.getDouble("tot"),rs.getString("nar"),rs.getString("typ"));
                    lst.add(vc);
                    System.out.println("PPPPPPPPPPPPPPPPP"+vc.getItm());

                }

        }
          catch (SQLException se) {System.out.println("Vouchers Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return lst;

    }
    public Vouchers getPurItmsFromTab(String vn,String item,double tot)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            Vouchers vc=null;
        try
        {
            con=dbc.GetConnetion();
                //vouchers(s,s,s,s,s,s,s,s,s,d,s,d,d,d,d,s,s)
                //vno,kst ,cst,tinno,pnam,snam,mft,phon,dat,rate,itm,wt,irat,tax,tot,nar,typ
                ps=con.prepareStatement("select * from vouchers where vno=? and itm=? and irat=? ");
                ps.setString(1,vn);
                ps.setString(2,item);
                ps.setDouble(3,tot);
                rs=ps.executeQuery();

                while(rs.next())
                {
                //,wstg,mkgchrg,tot,dist,gtot
                    vc=new Vouchers(rs.getString("vno"),rs.getString("kst"),rs.getString("cst"),rs.getString("tinno"),rs.getString("pnam"),rs.getString("snam"),rs.getString("mft"),rs.getString("phon"),String.valueOf(rs.getDate("dat")),rs.getDouble("rate"),rs.getString("itm"),rs.getDouble("wt"),rs.getDouble("irat"),rs.getDouble("tax"),rs.getDouble("tot"),rs.getString("nar"),rs.getString("typ"));
                    


                }

        }
          catch (SQLException se) {System.out.println("Vouchers Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return vc;

    }

    //*******************************************Payment Transaction*********************************************


    public boolean savePByCash(String vno, String pid, double vamt, String vdat, double vbal, String pmod, double pamt, String pdat,String bprsn,String vtyp)
    {
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            ps=con.prepareStatement("insert into paymentB values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,vno);
                ps.setString(2,pid);
                ps.setDouble(3,vamt);
                ps.setString(4,vdat);
                ps.setDouble(5,vbal);
                ps.setString(6,pmod);
                ps.setDouble(7,pamt);
                ps.setString(8,pdat);
                ps.setString(9,null);
                ps.setString(10,null);
                ps.setString(11,null);
                ps.setString(12,null);
                ps.setString(13,null);
                ps.setString(14,null);
                ps.setString(15,bprsn);
                ps.setString(16,vtyp);



            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            System.out.println("Payment save by cash Expt :"+e);
        }
        finally{try{con.close();}catch(Exception e1){}}
        return flag;
    }
    public boolean savePByBank(String vno, String pid, double vamt, String vdat, double vbal, String pmod, double pamt, String pdat,String byt, String lno, String actno, String acthldr, String bnam, String bbrch,String vtyp)
    {
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            ps=con.prepareStatement("insert into paymentB values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,vno);
                ps.setString(2,pid);
                ps.setDouble(3,vamt);
                ps.setString(4,vdat);
                ps.setDouble(5,vbal);
                ps.setString(6,pmod);
                ps.setDouble(7,pamt);
                ps.setString(8,pdat);
                ps.setString(9,byt);
                ps.setString(10,lno);
                ps.setString(11,actno);
                ps.setString(12,acthldr);
                ps.setString(13,bnam);
                ps.setString(14,bbrch);
                ps.setString(15,null);
                ps.setString(16,vtyp);



            int n=ps.executeUpdate();
            if(n>0)
            {flag = true;}
        }catch(Exception e)
        {
            System.out.println("Payment save by Bank Expt :"+e);
        }
        finally{try{con.close();}catch(Exception e1){}}
        return flag;
    }
    public boolean modPbyCash(String vno, String pid,  double vbal, String pmod, double pamt, String pdat,  String bprsn,String typ)
    {
        dbc=new DBConnect();
        boolean b=false;
        try
        {
            con=dbc.GetConnetion();

                ps=con.prepareStatement("update paymentB set vbal=?, pmod=?, pamt=?,pdat=?,bprsn=?  where vno=? and vtyp=? and pid=?");
                ps.setDouble(1,vbal);
                ps.setString(2,pmod);
                ps.setDouble(3,pamt);
                ps.setString(4,pdat);
                ps.setString(5,bprsn);
                ps.setString(6,vno);
                ps.setString(7,typ);
                ps.setString(8,pid);
                int n=ps.executeUpdate();
                if(n>0)
                    b=true;
                else
                    b=false;

        }
          catch (SQLException se) {System.out.println("PAYMENT BY cash mod data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return b;
    }
    public boolean modPbyBank(String vno, String pid,  double vbal, String pmod, double pamt, String pdat,  String byt,String lno, String actno, String acthldr, String bnam , String bbrch, String typ)
    {
        dbc=new DBConnect();
        boolean b=false;
        try
        {
            con=dbc.GetConnetion();

                ps=con.prepareStatement("update paymentB set vbal=?, pmod=?, pamt=?,pdat=?,byt=?,lno=?,actno=?,acthldr=?,bnam=?,bbrch=?  where vno=? and vtyp=? and pid=?");
                ps.setDouble(1,vbal);
                ps.setString(2,pmod);
                ps.setDouble(3,pamt);
                ps.setString(4,pdat);
                ps.setString(5,byt);
                ps.setString(6,lno);
                ps.setString(7,actno);
                ps.setString(8,acthldr);
                ps.setString(9,bnam);
                ps.setString(10,bbrch);
                ps.setString(11,vno);
                ps.setString(12,typ);
                ps.setString(13,pid);
                int n=ps.executeUpdate();
                if(n>0)
                    b=true;
                else
                    b=false;

        }
          catch (SQLException se) {System.out.println("PAYMENT BY cash mod data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return b;
    }
    public List searchVNinPayment(String vn,String typ)
    {
        String vno;
        dbc=new DBConnect();
        List lst=new LinkedList();
        try
        {
            con=dbc.GetConnetion();

                ps=con.prepareStatement("select vno from paymentB where vno=? and vtyp=? ");
                ps.setString(1,vn);
                ps.setString(2,typ);
                rs=ps.executeQuery();

                while(rs.next())
                {
                    vno=rs.getString("vno");
                    lst.add(vno);
                }
                System.out.println("Size....."+lst.size());
        }
          catch (SQLException se) {System.out.println("Vouchers Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return lst;
    }
    public List getVcBal(String vn,String typ)
    {
        double vno=0;
        dbc=new DBConnect();
        List lst=new LinkedList();
        try
        {
            con=dbc.GetConnetion();

                ps=con.prepareStatement("select vamt, vbal from paymentB where vno=? and vtyp=? and pid=? ");
                ps.setString(1,vn);
                ps.setString(2,typ);
                ps.setString(3,"1");
                rs=ps.executeQuery();

                while(rs.next())
                {
                    Payment pm=new Payment(rs.getDouble("vamt"),rs.getDouble("vbal"));
                    lst.add(pm);
                }
                System.out.println("Size....."+lst.size());
        }
          catch (SQLException se) {System.out.println("Vouchers Balance data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return lst;
    }
    public boolean saveVNinPayment(String vn,String vdat,double vnet,String typ)
    {
        String vno;
        boolean b=false;
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            //(vno,vamt,vdat,vbal,vtyp)
                ps=con.prepareStatement("insert into  paymentB values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                ps.setString(1,vn);
                ps.setString(2,vn);
                ps.setDouble(3,vnet);
                ps.setString(4,vdat);
                ps.setDouble(5,vnet);
                ps.setString(6," ");
                ps.setDouble(7,vnet);
                ps.setString(8,vdat);
                ps.setString(9," ");
                ps.setString(10," ");
                ps.setString(11," ");
                ps.setString(12," ");
                ps.setString(13," ");
                ps.setString(14," ");
                ps.setString(15," ");
                ps.setString(16,typ);
                int n=ps.executeUpdate();
                
                if(n>0)
                    b=true;
                else
                    b=false;
        }
          catch (SQLException se) {System.out.println("Payment first save"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return b;
    }

        public boolean modVNinPayment(String vn,String typ,String vdat,double vnet)
    {
        String vno;
        boolean b=false;
        try
        {
            con=dbc.GetConnetion();

                ps=con.prepareStatement("update paymentB set vdat=?,  vamt=?,vbal=?  where vno=? and vtyp=? ");
                ps.setString(1,vdat);
                ps.setDouble(2,vnet);
                ps.setDouble(3,vnet);
                ps.setString(4,vn);
                ps.setString(5,typ);
                int n=ps.executeUpdate();
                if(n>0)
                    b=true;
                else
                    b=false;

        }
          catch (SQLException se) {System.out.println("Vouchers Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
        return b;
    }

    public List getPayItms(String vn,String typ)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            Payment pm=null;
        try
        {
            con=dbc.GetConnetion();
                ps=con.prepareStatement("select * from paymentB where vno=? and vtyp=? ");
                ps.setString(1,vn);
                ps.setString(2,typ);
                rs=ps.executeQuery();

                while(rs.next())
                {
                //vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn,typ
                    pm=new Payment(rs.getString("vno"),rs.getString("pid"),rs.getDouble("vamt"),String.valueOf(rs.getDate("vdat")),rs.getDouble("vbal"),rs.getString("pmod"),rs.getDouble("pamt"),rs.getString("pdat"),rs.getString("byt"),rs.getString("lno"),rs.getString("actno"),rs.getString("acthldr"),rs.getString("bnam"),rs.getString("bbrch"),rs.getString("bprsn"));
                    lst.add(pm);
                }

        }
          catch (SQLException se) {System.out.println("Payement items Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return lst;

    }
    public Payment getPayItmsFromTab(String vn,String pid)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            Payment pm=null;
        try
        {
            con=dbc.GetConnetion();
                ps=con.prepareStatement("select * from paymentB where vno=? and pid=? ");
                ps.setString(1,vn);
                ps.setString(2,pid);
                rs=ps.executeQuery();

                while(rs.next())
                {
                //vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn,typ
                    pm=new Payment(rs.getString("vno"),rs.getString("pid"),rs.getDouble("vamt"),String.valueOf(rs.getDate("vdat")),rs.getDouble("vbal"),rs.getString("pmod"),rs.getDouble("pamt"),String.valueOf(rs.getDate("pdat")),rs.getString("byt"),rs.getString("lno"),rs.getString("actno"),rs.getString("acthldr"),rs.getString("bnam"),rs.getString("bbrch"),rs.getString("bprsn"));
                    
                }

        }
          catch (SQLException se) {System.out.println("Payement items Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return pm;

    }
    public List getNextPId(String vn,String type)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            String  p=null;
        try
        {
            con=dbc.GetConnetion();
                
                //vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn
                ps=con.prepareStatement("select vno  from paymentB where vno=?");
                ps.setString(1,vn);
                

                rs=ps.executeQuery();

                while(rs.next())
                {
                     p=rs.getString("vno");
                    lst.add(p);
                }

        }
          catch (SQLException se) {System.out.println("Vouchers Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return lst;

    }
    public List getPayTab(String vn,String typ)
    {

            dbc=new DBConnect();
            lst=new LinkedList();
            Payment pm=null;
        try
        {
            con=dbc.GetConnetion();
                
                //vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn
                ps=con.prepareStatement("select * from paymentB where vno=? and vtyp=? ");
                ps.setString(1,vn);
                ps.setString(2,typ);
                rs=ps.executeQuery();

                while(rs.next())
                {
                                                                    //vno,pid,vamt,vdat,vbal,pmod,pamt,pdat,byt,lno,actno,acthldr,bnam,bbrch,bprsn,typ
                    pm=new Payment(rs.getString("vno"),rs.getString("pid"),rs.getDouble("vamt"),String.valueOf(rs.getDate("vdat")),rs.getDouble("vbal"),rs.getString("pmod"),rs.getDouble("pamt"),String.valueOf(rs.getDate("pdat")),rs.getString("byt"),rs.getString("lno"),rs.getString("actno"),rs.getString("acthldr"),rs.getString("bnam"),rs.getString("bbrch"),rs.getString("bprsn"),rs.getString("vtyp"));
                    lst.add(pm);


                }

        }
          catch (SQLException se) {System.out.println("Payment Tab data"+se);}
            finally{try{con.close();}catch(Exception e1){}}
          return lst;

    }

    //****************************************************Payment Transaction stops here**********************************************
    //Voucher Details List Strats
    //Combo Related
    public List getVouchers()
    {

        lst=new LinkedList();
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            st=con.createStatement();
            String nam;
            lst.add("Select");
            rs=st.executeQuery("select vno from vouchers");
            while(rs.next())
                //dlid,dlnam,dlfrm
                {
                nam=rs.getString("vno");
                lst.add(nam);
            }

        }catch(Exception e)
        {
            System.out.println("Voucher No :"+e);
            return lst;
        }
        finally{try{con.close();}catch(Exception e1)
            {System.out.println("Voucher No Expt :"+e1);}}
        return lst;
    }
    public List getVItems()
    {

        lst=new LinkedList();
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            st=con.createStatement();
            String nam;
            lst.add("Select");
            rs=st.executeQuery("select itm from vouchers");
            while(rs.next())
                //dlid,dlnam,dlfrm
                {
                nam=rs.getString("itm");
                lst.add(nam);
            }

        }catch(Exception e)
        {
            System.out.println("Voucher Items :"+e);
            return lst;
        }
        finally{try{con.close();}catch(Exception e1)
            {System.out.println("Voucher ItemsExpt :"+e1);}}
        return lst;
    }
    public List getVCustomers()
    {

        lst=new LinkedList();
        dbc=new DBConnect();
        try
        {
            con=dbc.GetConnetion();
            st=con.createStatement();
            String nam;
            lst.add("Select");
            rs=st.executeQuery("select pnam from vouchers");
            while(rs.next())
                //dlid,dlnam,dlfrm
                {
                nam=rs.getString("pnam");
                lst.add(nam);
            }

        }catch(Exception e)
        {
            System.out.println("Voucher Party name :"+e);
            return lst;
        }
        finally{try{con.close();}catch(Exception e1)
            {System.out.println("Voucher Party Name Expt :"+e1);}}
        return lst;
    }
    //Vouchers Details List Finished

}

