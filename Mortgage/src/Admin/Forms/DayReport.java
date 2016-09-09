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


import Transaction.Services.Transervices;
import Transaction.model.Trancst_model;
import Transaction.model.Trantrs_mod;
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
import java.awt.Font;
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
      
        getDayPaymentList();
        
    }
    public void getDayPaymentList()
    {
         try{

        int i=0,j=0;
        double x=0;
        Transervices gs=new Transervices();
        Trantrs_mod trm=null;
        List lst=new LinkedList();
        Date tdy=new Date();
        SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
        String sdat=String.valueOf(Format.format(tdy));
             System.out.println("Repo "+sdat);
        lst=(List)gs.dayPayRepo(sdat);
        Object dat[][]=new Object[lst.size()+2][8];
        String col[]={"ಗ್ರಾಹಕನ ಸಂಖ್ಯೆ","TRN ID","ವಿತರಿಸಿದ ದಿನಾ೦ಕ","ಆಭರಣಗಳು","ತೂ ಕ","ಬಡ್ಡಿ ಶೆಕಡ","ವಿತರಿಸಿದ ಮೊತ್ತ","Status"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            trm=(Trantrs_mod)itm.next();
            dat[i][0]=(String)trm.getCid();
            dat[i][1]=(String)trm.getTid();
            dat[i][2]=(Date)trm.getGdate();
            dat[i][3]=(String)trm.getItem();
            dat[i][4]=(Double)trm.getWeight();
            dat[i][5]=(Double)trm.getIntrst();
            dat[i][6]=(Double)trm.getG_amt();
            dat[i][7]=(String)trm.getStatus();
            x=x+(Double)dat[i][5];
            i++;
        }
        dat[i+1][4]="ಒಟ್ಟು ಮೊತ್ತ :";
        dat[i+1][5]=x;
        DefaultTableModel dm=new DefaultTableModel(dat,col);
        trntab.setModel(dm);
        trntab.setAutoResizeMode(trntab.AUTO_RESIZE_OFF);
        trntab.getColumnModel().getColumn(0).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(1).setPreferredWidth(120);
        trntab.getColumnModel().getColumn(2).setPreferredWidth(120);
        trntab.getColumnModel().getColumn(3).setPreferredWidth(250);
        trntab.getColumnModel().getColumn(4).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(5).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(6).setPreferredWidth(170);
        trntab.getColumnModel().getColumn(7).setPreferredWidth(100);
       
      
       }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
    }
   public void donwKeyRecord()
    {
        try{
        int ro=trntab.getSelectedRow();
         String cid=trntab.getModel().getValueAt(ro+1,0).toString();
        Transervices gs=new Transervices();
       
        List lst=new LinkedList();


            Trancst_model gsm=(Trancst_model)gs.viewbycid(cid);
            Font f=new Font("Akshar Unicode",Font.BOLD,16);//font	Akshar Unicode 14 Bold


            //txt1.setText(gsm.getCid());
             mpt1.setText(gsm.getCname());
            mpt2.setText(gsm.getPhno());
            mpt4.setText(gsm.getAddress());
            String im1=gsm.getCpic();

            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));
        /*gcmod =(Sales.model.Goldcst_model)gs.viewbycid(cid);
        //getGoldTransRepo(cid);
        mpt1.setText(gcmod.getCname());
        mpt2.setText(gcmod.getPhno());
        mpt3.setText(gcmod.getCity());
        String im1=gcmod.getImg1();
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));*/
        }catch(Exception e){}
    }
    public void upKeyRecord()
    {
        try{
        int ro=trntab.getSelectedRow();
         String cid=trntab.getModel().getValueAt(ro-1,0).toString();
        Transervices gs=new Transervices();

        List lst=new LinkedList();


            Trancst_model gsm=(Trancst_model)gs.viewbycid(cid);
           // Font f=new Font("Akshar Unicode",Font.BOLD,16);//font	Akshar Unicode 14 Bold


            //txt1.setText(gsm.getCid());
             mpt1.setText(gsm.getCname());
            mpt2.setText(gsm.getPhno());
            mpt4.setText(gsm.getAddress());
            String im1=gsm.getCpic();

            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));
           
        }catch(Exception e){}
    }
    /*public void getGoldTransRepo(String cid)
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
        jLabel4 = new javax.swing.JLabel();
        mpt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mpt4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trntab = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        shot = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1100, 525));
        setMinimumSize(new java.awt.Dimension(1100, 525));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        jLabel2.setText("ಫೋನ ನಂ");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(10, 51, 61, 29);

        jLabel3.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        jLabel3.setText("ವಿಳಾಸ");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 94, 41, 29);

        mpt2.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        mpt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(mpt2);
        mpt2.setBounds(122, 48, 150, 33);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("jLabel4");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(290, 50, 100, 20);

        mpt1.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        mpt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(mpt1);
        mpt1.setBounds(122, 10, 450, 33);

        jLabel1.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        jLabel1.setText("ಗ್ರಾಹಕನ ಹೆಸರು");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 92, 29);

        mpt4.setColumns(20);
        mpt4.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        mpt4.setRows(5);
        mpt4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(mpt4);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(120, 94, 450, 90);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        trntab.setFont(new java.awt.Font("Tunga", 1, 16)); // NOI18N
        trntab.setModel(new javax.swing.table.DefaultTableModel(
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
        trntab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trntabMouseClicked(evt);
            }
        });
        trntab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trntabKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(trntab);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(228, 209, 209));

        shot.setBackground(new java.awt.Color(255, 255, 255));
        shot.setPreferredSize(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shot, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(shot, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trntabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trntabKeyPressed
       
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP)
        {
            
                upKeyRecord();
               
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN)
        {
            
            donwKeyRecord();
               
        }
    }//GEN-LAST:event_trntabKeyPressed

    private void trntabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trntabMouseClicked

      try{
        int ro=trntab.getSelectedRow();
         String cid=trntab.getModel().getValueAt(ro,0).toString();
     Transervices gs=new Transervices();

        List lst=new LinkedList();


            Trancst_model gsm=(Trancst_model)gs.viewbycid(cid);
            Font f=new Font("Akshar Unicode",Font.BOLD,16);//font	Akshar Unicode 14 Bold


            //txt1.setText(gsm.getCid());
             mpt1.setText(gsm.getCname());
            mpt2.setText(gsm.getPhno());
            mpt4.setText(gsm.getAddress());
            String im1=gsm.getCpic();

            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(268, 254, 268)));
        }catch(Exception e){}
    }//GEN-LAST:event_trntabMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mpt1;
    private javax.swing.JTextField mpt2;
    private javax.swing.JTextArea mpt4;
    private javax.swing.JLabel shot;
    private javax.swing.JTable trntab;
    // End of variables declaration//GEN-END:variables

    
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
