/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DayReport.java
 *
 * Created on Feb 28, 2015, 11:50:13 AM
 */

package Admin.Forms;

import Sales.Services.Goldservices;
import Sales.Services.Silver_Service;
import java.awt.BasicStroke;

import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//shadow imports
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
/**
 *
 * @author user
 */
public class DayReport extends javax.swing.JPanel {


      //attrib for shadow starts************************************************

    protected int strokeSize = 1;
    protected Color shadowColor = Color.black;
    protected boolean shady = true;
    protected boolean highQuality = true;
    protected Dimension arcs = new Dimension(20, 20);
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 150;
    double tax=0.0;
//attrib for shadow stops************************************************

    /** Creates new form DayReport */
    public DayReport() {
        setOpaque(false);
        initComponents();
        Date tdy=new Date();
         SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
        String sdat=String.valueOf(Format.format(tdy));
        jLabel4.setText(sdat);
        jLabel5.setText("");
        getGoldSaleRepo();
        getSilverSaleRepo();
    }
    public void getGoldSaleRepo()
    {
         try{

        int i=0,j=0;
        double x=0;
        Goldservices gs=new Goldservices();
        Sales.model.Goldtrs_mod gtmod=null;
        List lst=new LinkedList();
        Date tdy=new Date();
        SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
        String sdat=String.valueOf(Format.format(tdy));
             System.out.println("Repo "+sdat);
        lst=(List)gs.goldTransDayDetails(sdat);
        Object dat[][]=new Object[lst.size()][6];
        String col[]={"Sl No","Customer Id","TrnId","TransDate","ReturnDate","Total"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            gtmod=(Sales.model.Goldtrs_mod)itm.next();
            dat[i][0]=i+1;
            dat[i][1]=(String)gtmod.getCid();
            dat[i][2]=(String)gtmod.getTid();
            dat[i][3]=(Date)gtmod.getT_date();
            dat[i][4]=(Date)gtmod.getT_date();
            dat[i][5]=(Double)gtmod.getTotamt();
            i++;
        }
      
       DefaultTableModel dm=new DefaultTableModel(dat,col);
       GldTab.setModel(dm);
       GldTab.setAutoResizeMode(GldTab.AUTO_RESIZE_OFF);
       GldTab.getColumnModel().getColumn(0).setPreferredWidth(50);
       GldTab.getColumnModel().getColumn(1).setPreferredWidth(100);
       GldTab.getColumnModel().getColumn(2).setPreferredWidth(100);
       GldTab.getColumnModel().getColumn(3).setPreferredWidth(100);
       GldTab.getColumnModel().getColumn(4).setPreferredWidth(100);
       GldTab.getColumnModel().getColumn(5).setPreferredWidth(100);
      
       }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
    }
    public void donwKeyRecord()
    {
        try{
        int ro=GldTab.getSelectedRow();
         String cid=GldTab.getModel().getValueAt(ro+1,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
        getGoldTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));
        }catch(Exception e){}
    }
    public void upKeyRecord()
    {
        try{
        int ro=GldTab.getSelectedRow();
         String cid=GldTab.getModel().getValueAt(ro-1,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
        getGoldTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));
        }catch(Exception e){}
    }
    public void getGoldTransRepo(String cid)
    {
         try{

        int i=0,j=0;
        double x=0;
        Goldservices gs=new Goldservices();
        Sales.model.Goldtrs_mod gtmod=null;
        List lst=new LinkedList();
        Date tdy=new Date();
        
        lst=(List)gs.getGldTransTab(cid);
        Object dat[][]=new Object[lst.size()+2][7];
        String col[]={"Transaction Id","SlNo","Item","Weight","Wastage","Mkg Charge","TotalAmount"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            gtmod=(Sales.model.Goldtrs_mod)itm.next();
            
            dat[i][0]=(String)gtmod.getTid();
            dat[i][1]=(String)gtmod.getSlno();
            dat[i][2]=(String)gtmod.getPurch_item();
            dat[i][3]=(Double)gtmod.getWeight();
            dat[i][4]=(Double)gtmod.getWastage();
            dat[i][5]=(Double)gtmod.getMak_chrg();
            dat[i][6]=(Double)gtmod.getTotamt();
            i++;
        }

       DefaultTableModel dm=new DefaultTableModel(dat,col);
       detelTab.setModel(dm);
       detelTab.setAutoResizeMode(detelTab.AUTO_RESIZE_OFF);
       detelTab.getColumnModel().getColumn(0).setPreferredWidth(100);
       detelTab.getColumnModel().getColumn(1).setPreferredWidth(40);
       detelTab.getColumnModel().getColumn(2).setPreferredWidth(100);
       detelTab.getColumnModel().getColumn(3).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(4).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(5).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(6).setPreferredWidth(100);

       }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mpt2 = new javax.swing.JTextField();
        mpt3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        shot = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mpt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detelTab = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GldTab = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        SilTab = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1100, 525));
        setMinimumSize(new java.awt.Dimension(1100, 525));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tunga", 1, 12));
        jLabel2.setText("ಫೋನ ನಂ");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 51, 45, 22);

        jLabel3.setFont(new java.awt.Font("Tunga", 1, 12));
        jLabel3.setText("ಊರು");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 94, 27, 22);

        mpt2.setFont(new java.awt.Font("Tahoma", 1, 14));
        mpt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(mpt2);
        mpt2.setBounds(93, 48, 179, 21);

        mpt3.setFont(new java.awt.Font("Tahoma", 1, 14));
        mpt3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(mpt3);
        mpt3.setBounds(93, 91, 179, 21);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("jLabel4");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(37, 134, 220, 20);

        shot.setBackground(new java.awt.Color(255, 255, 255));
        shot.setPreferredSize(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shot, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(shot, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2);
        jPanel2.setBounds(292, 52, 288, 260);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("jLabel5");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(0, 290, 290, 28);

        mpt1.setFont(new java.awt.Font("Tahoma", 1, 14));
        mpt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(mpt1);
        mpt1.setBounds(90, 10, 482, 21);

        jLabel1.setFont(new java.awt.Font("Tunga", 1, 12));
        jLabel1.setText("ಗ್ರಾಹಕನ ಹೆಸರು");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 71, 22);

        detelTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(detelTab);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GldTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        GldTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GldTabMouseClicked(evt);
            }
        });
        GldTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GldTabKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(GldTab);

        SilTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        SilTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SilTabMouseClicked(evt);
            }
        });
        SilTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SilTabKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(SilTab);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("G O L D");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("S I L V E R");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GldTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GldTabKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP)
        {
             jLabel5.setText("GOld Transaction Details");
                upKeyRecord();
               
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN)
        {
             jLabel5.setText("GOld Transaction Details");
            donwKeyRecord();
               
        }
    }//GEN-LAST:event_GldTabKeyPressed

    private void SilTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SilTabKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP)
        {
             jLabel5.setText("Silver Transaction Details");
                upKeySilRecord();
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN)
        {
             jLabel5.setText("Silver Transaction Details");
                donwKeySilRecord();
        }
    }//GEN-LAST:event_SilTabKeyPressed

    private void GldTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GldTabMouseClicked

        try{
        int ro=GldTab.getSelectedRow();
         String cid=GldTab.getModel().getValueAt(ro,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
        getGoldTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(220, 200, 200)));
             jLabel5.setText("GOld Transaction Details");
        }catch(Exception e){}
    }//GEN-LAST:event_GldTabMouseClicked

    private void SilTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SilTabMouseClicked
         try{
        int ro=SilTab.getSelectedRow();
         String cid=SilTab.getModel().getValueAt(ro,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
         getSilverTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(220, 200, 200)));
             jLabel5.setText("Silver Transaction Details");
        }catch(Exception e){}
    }//GEN-LAST:event_SilTabMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GldTab;
    private javax.swing.JTable SilTab;
    private javax.swing.JTable detelTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField mpt1;
    private javax.swing.JTextField mpt2;
    private javax.swing.JTextField mpt3;
    private javax.swing.JLabel shot;
    // End of variables declaration//GEN-END:variables

    //Silver Report details
    public void getSilverSaleRepo()
    {
         try{

        int i=0,j=0;
        double x=0;
        Silver_Service ss=new Silver_Service();
        Sales.model.Silvertrs_mod stmod=null;
        List lst=new LinkedList();
        Date tdy=new Date();
        SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
        String sdat=String.valueOf(Format.format(tdy));
         System.out.println("Repo "+sdat);
        lst=(List)ss.silverTransDayDetails(sdat);
        Object dat[][]=new Object[lst.size()][6];
        String col[]={"Sl No","Customer Id","TrnId","TransDate","ReturnDate","Total"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            stmod=(Sales.model.Silvertrs_mod)itm.next();
            dat[i][0]=i+1;
            dat[i][1]=(String)stmod.getCid();
            dat[i][2]=(String)stmod.getTid();
            dat[i][3]=(Date)stmod.getT_date();
            dat[i][4]=(Date)stmod.getT_date();
            dat[i][5]=(Double)stmod.getTotamt();
            i++;
        }

       DefaultTableModel dm=new DefaultTableModel(dat,col);
       SilTab.setModel(dm);
       SilTab.setAutoResizeMode(SilTab.AUTO_RESIZE_OFF);
       SilTab.getColumnModel().getColumn(0).setPreferredWidth(50);
       SilTab.getColumnModel().getColumn(1).setPreferredWidth(100);
       SilTab.getColumnModel().getColumn(2).setPreferredWidth(100);
       SilTab.getColumnModel().getColumn(3).setPreferredWidth(100);
       SilTab.getColumnModel().getColumn(4).setPreferredWidth(100);
       SilTab.getColumnModel().getColumn(5).setPreferredWidth(100);

       }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
    }
    public void donwKeySilRecord()
    {
        try{
        int ro=SilTab.getSelectedRow();
         String cid=SilTab.getModel().getValueAt(ro+1,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
         getSilverTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(220, 200, 200)));
        }catch(Exception e){}
    }
    public void upKeySilRecord()
    {
        try{
        int ro=SilTab.getSelectedRow();
         String cid=SilTab.getModel().getValueAt(ro-1,1).toString();
        Goldservices gs=new Goldservices();
        Sales.model.Goldcst_model gcmod=null;
        List lst=new LinkedList();
        gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
         getSilverTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(220, 200, 200)));
        }catch(Exception e){}
    }
    public void getSilverTransRepo(String cid)
    {
        try{

        int i=0,j=0;
        double x=0;
        Silver_Service ss=new Silver_Service();
        Sales.model.Silvertrs_mod stmod=null;
        List lst=new LinkedList();

        
        lst=(List)ss.silverTransDetails(cid);
        if(lst!=null)
        {
         Object dat[][]=new Object[lst.size()+2][6];
        String col[]={"Transaction Id","SlNo","Item","Weight","Mkg Charge","TotalAmount"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            stmod=(Sales.model.Silvertrs_mod)itm.next();
              dat[i][0]=(String)stmod.getTid();
            dat[i][1]=(String)stmod.getSlno();
            dat[i][2]=(String)stmod.getPurch_item();
            dat[i][3]=(Double)stmod.getWeight();
            dat[i][4]=(Double)stmod.getMak_chrg();
            dat[i][5]=(Double)stmod.getTotamt();
            
            i++;
        }

       DefaultTableModel dm=new DefaultTableModel(dat,col);
       detelTab.setModel(dm);
       detelTab.setAutoResizeMode(detelTab.AUTO_RESIZE_OFF);
       detelTab.getColumnModel().getColumn(0).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(1).setPreferredWidth(50);
       detelTab.getColumnModel().getColumn(2).setPreferredWidth(100);
       detelTab.getColumnModel().getColumn(3).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(4).setPreferredWidth(70);
       detelTab.getColumnModel().getColumn(5).setPreferredWidth(70);
            }
       }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
   }
//fun for creating shadow Starts**************************************************************
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(),
	shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
    //fun for creating shadow Stops**************************************************************

}
