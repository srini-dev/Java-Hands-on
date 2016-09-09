/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gold_sale1.java
 *
 * Created on 28 Dec, 2014, 7:01:26 PM
 */

package Transaction;

//camera imports
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
//camera Imports


import Admin.Forms.MyFont;
import Transaction.Reports.TranRep;
import Transaction.Services.Transervices;
import Transaction.model.Trancst_model;
import Transaction.model.Tranpay_mod;
import Transaction.model.Trantrs_mod;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.LinkedList;
import org.exolab.castor.types.Month;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;

import org.jdesktop.swingx.autocomplete.*;

/**
 *
 * @author Dell-PC
 */
public class Transaction extends javax.swing.JPanel   {
    Transervices gs=new Transervices();
    boolean takeShot=false;
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
    //t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,tt12,tt13,tt14,tt15,tt16,tt17,tt18,tt19,t20
    String t1,t2,t3,t4,t5,t6,t7,t8,img1="",img2="";
    String c1,c2,c3,c4,c5,c6,c7;
    Double cc3,cc4,cc5;
    String b1,b2,b3,b4,b5;
    Double bb2,bb3,bb4;
    int phot1=0,phot2=0;
    String trnd;
    String slno;
    String m1,m2,m3,m4,m5,m6;
    Double mm4,mm5;
   // java.util.Date dt=null;
    /** Creates new form Gold_sale1 */
    public Transaction() throws IOException {
        //super("?????");
        initComponents();
        MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Tunga",Font.BOLD,16));
        onloadrun();
        this.setOpaque(false);
    }
    public void onloadrun() throws IOException
    {
        autoupload();
        comboCustIDs();//font	Baraha Kan 16 Bold
        comboCustNames();
        comboCustNames2();
        clear();
        tr2.setDate(new java.util.Date());
        trr2.setDate(new java.util.Date());
       // tr7.setDate(new java.util.Date());
       // dt=new java.util.Date(tr7.getDate().getTime());
        tsave.setEnabled(false);
        tnew.setEnabled(false);
        tdel.setEnabled(false);
        tupdate.setEnabled(false);
        tr8.setEditable(false);
        cupdatebtn.setEnabled(false);
        pupdate.setEnabled(false);
        printbtn.setEnabled(false);
    }



    public void autoupload() throws IOException
    {
        File fp=new File("src\\Transaction\\personal.png");
        ImageIcon ipr= new ImageIcon(fp.getPath());
        BufferedImage myPic = ImageIO.read(fp.getAbsoluteFile());
        shot.setIcon(new ImageIcon(myPic.getScaledInstance(118, 118, 100)));
        shot2.setIcon(new ImageIcon(myPic.getScaledInstance(118, 118, 100)));
        img1=fp.getAbsolutePath();
        img2=fp.getAbsolutePath();
    }
    public void comboCustNames()
    {
        try
        {
        int i=0;
        List lst=null;
        gs=new Transervices();
        lst=(List)gs.getcustNam();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        AutoCompleteDecorator.decorate(this.cmbNam);
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel(cods));
        cmbNam.setMaximumRowCount(6);
        cmbNam.setFocusable(true);
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel(cods));
        cmbNam.setMaximumRowCount(6);
        cmbNam.setFocusable(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
     public void comboCustNames2()
    {
        try
        {
        int i=0;
        List lst=null;
        gs=new Transervices();
        lst=(List)gs.getcustNam();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        AutoCompleteDecorator.decorate(this.cmbNam2);
        cmbNam2.setModel(new javax.swing.DefaultComboBoxModel(cods));
        cmbNam2.setMaximumRowCount(6);
        cmbNam2.setFocusable(true);
        cmbNam2.setModel(new javax.swing.DefaultComboBoxModel(cods));
        cmbNam2.setMaximumRowCount(6);
        cmbNam2.setFocusable(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
    public void comboCustIDs()
    {
        try
        {
        int i=0;
        List lst=null;
        gs=new Transervices();
        lst=(List)gs.getcustid();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        idcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
        idcmb.setMaximumRowCount(6);
        idcmb.setFocusable(true);
        idcmb1.setModel(new javax.swing.DefaultComboBoxModel(cods));
        idcmb1.setMaximumRowCount(6);
        idcmb1.setFocusable(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
    public void comboTIDs()
    {
        try
        {
        int i=0;
        List lst=null;
        String cstid = (String) idcmb1.getSelectedItem();
        gs=new Transervices();
        lst=(List)gs.getTid(cstid);
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        tidcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
        tidcmb.setMaximumRowCount(6);
        tidcmb.setFocusable(true); 
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabcust = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        gct3 = new javax.swing.JScrollPane();
        txt3 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        txt1 = new javax.swing.JLabel();
        idcmb = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        photo = new javax.swing.JPanel();
        shot = new javax.swing.JLabel();
        gct6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cmbNam = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        gct10 = new javax.swing.JScrollPane();
        txt7 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txt5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        photo1 = new javax.swing.JPanel();
        shot2 = new javax.swing.JLabel();
        start2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        newbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trntab = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tr6 = new javax.swing.JTextField();
        tr4 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tr9 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        gct7 = new javax.swing.JScrollPane();
        tr3 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        tr2 = new com.toedter.calendar.JDateChooser();
        tr5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tr1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tr8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tr7 = new com.toedter.calendar.JDateChooser();
        trr2 = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        tnew = new javax.swing.JButton();
        tupdate = new javax.swing.JButton();
        tsave = new javax.swing.JButton();
        tdel = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tamt = new javax.swing.JTextField();
        cupdatebtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        desk = new javax.swing.JDesktopPane();
        closebtn1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        idcmb1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        photo2 = new javax.swing.JPanel();
        shot1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pc1 = new javax.swing.JLabel();
        pc2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        tidcmb = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pt3 = new com.toedter.calendar.JDateChooser();
        pt1 = new javax.swing.JLabel();
        pt2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pc3 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        pc4 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cmbNam2 = new javax.swing.JComboBox();
        newbtn1 = new javax.swing.JButton();
        savebtn1 = new javax.swing.JButton();
        printbtn1 = new javax.swing.JButton();
        clearbtn1 = new javax.swing.JButton();
        closebtn2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ptab = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        p3 = new com.toedter.calendar.JDateChooser();
        p1 = new javax.swing.JLabel();
        p4 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        p2 = new javax.swing.JTextField();
        pupdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        tabcust.setBackground(new java.awt.Color(255, 204, 204));
        tabcust.setFont(new java.awt.Font("Tunga", 1, 18));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1formKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel2.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel2.setText("ಗ್ರಾಹಕ ನ೦ :");

        jLabel3.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel3.setText("ವಿಳಾಸ :");

        jLabel5.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel5.setText("ಮೊಬೈಲ್ ನ೦ :");

        txt4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        txt4.setText(" ");
        txt4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt4KeyPressed(evt);
            }
        });

        gct3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct3KeyPressed(evt);
            }
        });

        txt3.setColumns(20);
        txt3.setFont(new java.awt.Font("Tunga", 1, 14));
        txt3.setRows(5);
        txt3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt3KeyPressed(evt);
            }
        });
        gct3.setViewportView(txt3);

        jLabel15.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel15.setText("ಹೆಸರು :");

        txt2.setFont(new java.awt.Font("Tunga", 1, 14));
        txt2.setText(" ");
        txt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });
        txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt2KeyPressed(evt);
            }
        });

        txt1.setBackground(new java.awt.Color(255, 255, 255));
        txt1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        txt1.setText("-------");
        txt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt1.setOpaque(true);

        idcmb.setFont(new java.awt.Font("Times New Roman", 1, 14));
        idcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcmbActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(null);

        photo.setBackground(new java.awt.Color(204, 204, 204));
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                photoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout photoLayout = new javax.swing.GroupLayout(photo);
        photo.setLayout(photoLayout);
        photoLayout.setHorizontalGroup(
            photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        photoLayout.setVerticalGroup(
            photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        jPanel9.add(photo);
        photo.setBounds(10, 20, 120, 120);

        gct6.setFont(new java.awt.Font("Times New Roman", 1, 12));
        gct6.setText("Capture");
        gct6.setBorder(null);
        gct6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct6ActionPerformed(evt);
            }
        });
        gct6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct6KeyPressed(evt);
            }
        });
        jPanel9.add(gct6);
        gct6.setBounds(40, 150, 62, 15);

        jLabel17.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel17.setText("ಭಾವಚಿತ್ರ");
        jPanel9.add(jLabel17);
        jLabel17.setBounds(40, 0, 54, 20);

        cmbNam.setFont(new java.awt.Font("Tunga", 1, 14));
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(idcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gct3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(cmbNam, 0, 218, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(gct3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );

        jPanel13.setBackground(new java.awt.Color(255, 204, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel20.setText("ಸಾಕ್ಷಿ ಹೆಸರು:");

        txt6.setFont(new java.awt.Font("Tunga", 1, 14));
        txt6.setText(" ");
        txt6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });
        txt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt6KeyPressed(evt);
            }
        });

        txt8.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        txt8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt8ActionPerformed(evt);
            }
        });
        txt8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt8KeyPressed(evt);
            }
        });

        gct10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct10KeyPressed(evt);
            }
        });

        txt7.setColumns(20);
        txt7.setFont(new java.awt.Font("Tunga", 1, 14));
        txt7.setRows(5);
        txt7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt7KeyPressed(evt);
            }
        });
        gct10.setViewportView(txt7);

        jLabel4.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel4.setText("ಸಾಕ್ಷಿ ಕ್ರ ಸ೦ಖ್ಯೆ :");

        txt5.setBackground(new java.awt.Color(255, 255, 255));
        txt5.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        txt5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt5.setOpaque(true);

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setLayout(null);

        photo1.setBackground(new java.awt.Color(204, 204, 204));
        photo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                photo1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout photo1Layout = new javax.swing.GroupLayout(photo1);
        photo1.setLayout(photo1Layout);
        photo1Layout.setHorizontalGroup(
            photo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
        photo1Layout.setVerticalGroup(
            photo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        jPanel14.add(photo1);
        photo1.setBounds(10, 20, 120, 120);

        start2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        start2.setText("Capture");
        start2.setBorder(null);
        start2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start2ActionPerformed(evt);
            }
        });
        start2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                start2KeyPressed(evt);
            }
        });
        jPanel14.add(start2);
        start2.setBounds(30, 150, 73, 15);

        jLabel21.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel21.setText("ಭಾವಚಿತ್ರ");
        jPanel14.add(jLabel21);
        jLabel21.setBounds(40, 0, 54, 20);

        jLabel18.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel18.setText("ವಿಳಾಸ :");

        jLabel19.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel19.setText("ಮೊಬೈಲ್ ನ೦ :");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gct10, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gct10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        newbtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        newbtn.setText("Add New");
        newbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbtnActionPerformed(evt);
            }
        });
        newbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newbtnKeyPressed(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        savebtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                savebtnKeyPressed(evt);
            }
        });

        printbtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        printbtn.setText("Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });
        printbtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                printbtnKeyPressed(evt);
            }
        });

        closebtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        closebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transaction/computer.png"))); // NOI18N
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        closebtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                closebtnKeyPressed(evt);
            }
        });

        clearbtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(213, 142, 142));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        trntab.setFont(new java.awt.Font("Akshar Unicode", 1, 14));
        trntab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        trntab.setRowHeight(20);
        trntab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trntabKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(trntab);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(12, 13, 900, 110);

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel5.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel6.setText(" ಬಡ್ಡಿ ಶೆಕಡ :");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(480, 40, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel7.setText("ತೂಕ :");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(510, 10, 40, 20);

        tr6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tr6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tr6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr6KeyPressed(evt);
            }
        });
        jPanel5.add(tr6);
        tr6.setBounds(560, 70, 80, 20);

        tr4.setFont(new java.awt.Font("Akshar Unicode", 1, 14));
        tr4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tr4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tr4ActionPerformed(evt);
            }
        });
        tr4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr4KeyPressed(evt);
            }
        });
        jPanel5.add(tr4);
        tr4.setBounds(560, 10, 70, 20);

        jLabel16.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel16.setText("ಬಿಡಿಸುವ ದಿನಾ೦ಕ ");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(10, 80, 110, 20);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel27.setText("TranID :");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(10, 20, 60, 17);

        tr9.setEditable(false);
        tr9.setFont(new java.awt.Font("Georgia", 1, 18));
        tr9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        tr9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr9KeyPressed(evt);
            }
        });
        jPanel5.add(tr9);
        tr9.setBounds(830, 64, 100, 30);

        jLabel8.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel8.setText("ಆಭರಣಗಳು :");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(170, 20, 80, 20);

        jLabel32.setFont(new java.awt.Font("Tunga", 1, 14));
        jLabel32.setText("ಗ್ರಾ೦");
        jPanel5.add(jLabel32);
        jLabel32.setBounds(630, 10, 30, 20);

        gct7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct7KeyPressed(evt);
            }
        });

        tr3.setColumns(10);
        tr3.setFont(new java.awt.Font("Tunga", 1, 18));
        tr3.setRows(3);
        tr3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tr3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr3KeyPressed(evt);
            }
        });
        gct7.setViewportView(tr3);

        jPanel5.add(gct7);
        gct7.setBounds(250, 10, 200, 80);

        jLabel12.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel12.setText("ವಿತರಿಸಿದ ಮೊತ್ತ :");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(450, 70, 100, 20);

        tr2.setDateFormatString("dd/MM/yyyy");
        tr2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(tr2);
        tr2.setBounds(120, 50, 110, 20);

        tr5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tr5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tr5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr5KeyPressed(evt);
            }
        });
        jPanel5.add(tr5);
        tr5.setBounds(560, 40, 70, 20);

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jLabel14.setText("Status :");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(760, 70, 50, 20);

        tr1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        tr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr1KeyPressed(evt);
            }
        });
        jPanel5.add(tr1);
        tr1.setBounds(110, 20, 50, 24);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("%");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(640, 40, 20, 17);

        tr8.setEditable(false);
        tr8.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tr8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tr8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tr8KeyPressed(evt);
            }
        });
        jPanel5.add(tr8);
        tr8.setBounds(830, 40, 130, 20);

        jLabel11.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel11.setText(" ಸ್ವಿಕರಿಸಿದ ಮೊತ್ತ :");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(710, 40, 110, 20);

        jLabel13.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel13.setText("ಸ್ವಿಕರಿಸಿದ ಕೊನೆ ದಿನಾ೦ಕ :");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(677, 10, 150, 20);

        tr7.setDateFormatString("dd/MM/yyyy");
        tr7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tr7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tr7PropertyChange(evt);
            }
        });
        jPanel5.add(tr7);
        tr7.setBounds(830, 10, 105, 20);

        trr2.setDateFormatString("dd/MM/YYYY");
        trr2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel5.add(trr2);
        trr2.setBounds(120, 80, 110, 20);

        jLabel33.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel33.setText("ದಿನಾ೦ಕ :");
        jPanel5.add(jLabel33);
        jLabel33.setBounds(10, 50, 58, 20);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(10, 130, 973, 104);

        tnew.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tnew.setText("New");
        tnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnewActionPerformed(evt);
            }
        });
        jPanel2.add(tnew);
        tnew.setBounds(1000, 90, 80, 30);

        tupdate.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tupdate.setText("Update");
        tupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tupdateActionPerformed(evt);
            }
        });
        jPanel2.add(tupdate);
        tupdate.setBounds(1000, 130, 80, 30);

        tsave.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tsave.setText("Save");
        tsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsaveActionPerformed(evt);
            }
        });
        tsave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tsaveKeyPressed(evt);
            }
        });
        jPanel2.add(tsave);
        tsave.setBounds(1000, 170, 80, 30);

        tdel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tdel.setText("Delete");
        tdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdelActionPerformed(evt);
            }
        });
        jPanel2.add(tdel);
        tdel.setBounds(1000, 210, 80, 30);

        jPanel15.setBackground(new java.awt.Color(255, 180, 180));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel31.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel31.setText("ಪಡೆದ ಒಟ್ಟು  ಮೊತ್ತ ");

        tamt.setEditable(false);
        tamt.setFont(new java.awt.Font("Lucida Bright", 1, 16));
        tamt.setText("0");
        tamt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        tamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tamtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tamt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamt)
                .addContainerGap())
        );

        jPanel2.add(jPanel15);
        jPanel15.setBounds(920, 20, 160, 70);

        cupdatebtn.setFont(new java.awt.Font("SansSerif", 1, 14));
        cupdatebtn.setText("Update");
        cupdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cupdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(printbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cupdatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn))
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabcust.addTab("ಗ್ರಾಹಕ ವಿವರಗಳು", jPanel1);

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel10.setText("Preview");

        desk.setBackground(new java.awt.Color(255, 204, 204));
        desk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        closebtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        closebtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transaction/computer.png"))); // NOI18N
        closebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtn1ActionPerformed(evt);
            }
        });
        closebtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                closebtn1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(desk, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                        .addComponent(closebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addComponent(closebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desk, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabcust.addTab("ಬಿಲ್ ", jPanel7);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idcmb1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        idcmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcmb1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel9.setText("ಗ್ರಾಹಕ ನ೦ :");

        jLabel22.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel22.setText("ಹೆಸರು :");

        jLabel23.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel23.setText("ಮೊಬೈಲ್ ನ೦ :");

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(null);

        photo2.setBackground(new java.awt.Color(204, 204, 204));
        photo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                photo2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout photo2Layout = new javax.swing.GroupLayout(photo2);
        photo2.setLayout(photo2Layout);
        photo2Layout.setHorizontalGroup(
            photo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        photo2Layout.setVerticalGroup(
            photo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shot1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );

        jPanel10.add(photo2);
        photo2.setBounds(10, 20, 180, 190);

        jLabel24.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel24.setText("ಭಾವಚಿತ್ರ");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(70, 0, 54, 20);

        pc1.setBackground(new java.awt.Color(255, 255, 255));
        pc1.setFont(new java.awt.Font("Akshar Unicode", 1, 18));
        pc1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pc1.setOpaque(true);

        pc2.setBackground(new java.awt.Color(255, 255, 255));
        pc2.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pc2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pc2.setOpaque(true);

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tidcmb.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tidcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidcmbActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel30.setText("TranID :");

        jLabel25.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel25.setText(" ಬಡ್ಡಿ ಶೆಕಡ :");

        jLabel29.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel29.setText("ವಿತರಿಸಿದ ಮೊತ್ತ :");

        jLabel28.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel28.setText("ವಿತರಿಸಿದ ದಿನಾ೦ಕ :");

        pt3.setDateFormatString("dd/MM/yyyy");
        pt3.setFont(new java.awt.Font("Times New Roman", 1, 14));

        pt1.setBackground(new java.awt.Color(255, 255, 255));
        pt1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt1.setOpaque(true);

        pt2.setBackground(new java.awt.Color(255, 255, 255));
        pt2.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt2.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tidcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pt1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pt2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pt3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tidcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, 0, 0, Short.MAX_VALUE)
                    .addComponent(pt1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pt2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pc3.setColumns(8);
        pc3.setEditable(false);
        pc3.setFont(new java.awt.Font("Akshar Unicode", 1, 18));
        pc3.setRows(3);
        pc3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(pc3);

        jLabel26.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel26.setText("ವಿಳಾಸ :");

        pc4.setBackground(new java.awt.Color(250, 179, 179));
        pc4.setFont(new java.awt.Font("Bookman Old Style", 1, 18));
        pc4.setForeground(new java.awt.Color(255, 51, 51));
        pc4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pc4.setOpaque(true);

        jLabel38.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel38.setText("ಒಟ್ಟು  ವಿತರಿಸಿದ ಮೊತ್ತ :");

        cmbNam2.setFont(new java.awt.Font("Tunga", 1, 14)); // NOI18N
        cmbNam2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNam2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel38)
                            .addComponent(jLabel26)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(idcmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))
                                    .addComponent(pc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbNam2, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                    .addComponent(pc1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                            .addComponent(pc4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idcmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbNam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(pc1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, 0, 0, Short.MAX_VALUE)
                                    .addComponent(pc2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(pc4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        newbtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        newbtn1.setText("New");
        newbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbtn1ActionPerformed(evt);
            }
        });
        newbtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newbtn1KeyPressed(evt);
            }
        });

        savebtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        savebtn1.setText("Pay");
        savebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtn1ActionPerformed(evt);
            }
        });
        savebtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                savebtn1KeyPressed(evt);
            }
        });

        printbtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        printbtn1.setText("Print");
        printbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtn1ActionPerformed(evt);
            }
        });
        printbtn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                printbtn1KeyPressed(evt);
            }
        });

        clearbtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        clearbtn1.setText("Clear");
        clearbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtn1ActionPerformed(evt);
            }
        });

        closebtn2.setFont(new java.awt.Font("SansSerif", 1, 14));
        closebtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transaction/computer.png"))); // NOI18N
        closebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtn2ActionPerformed(evt);
            }
        });
        closebtn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                closebtn2KeyPressed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ptab.setFont(new java.awt.Font("Akshar Unicode", 1, 16));
        ptab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ptab.setRowHeight(20);
        ptab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ptabKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(ptab);

        jLabel40.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel40.setText("ಗ್ರಾಹಕನ ಪಾವತಿ ವಿವರಗಳು :-");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addComponent(jLabel40))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel34.setText("Pay ID:");

        jLabel36.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel36.setText("ಪಾವತಿ ಮಾಡಬೆಕಾದ  ಹಣ:");

        jLabel37.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel37.setText("ಪಾವತಿ  ದಿನಾ೦ಕ :");

        p3.setDateFormatString("dd/MM/yyyy");
        p3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        p3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                p3PropertyChange(evt);
            }
        });

        p1.setBackground(new java.awt.Color(255, 255, 255));
        p1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        p1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p1.setOpaque(true);

        p4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        p4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel39.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel39.setText("ಪಾವತಿದಾರನ ಹೆಸರು :");

        p2.setFont(new java.awt.Font("Tunga", 1, 16));
        p2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        p2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel39)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(p1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pupdate.setFont(new java.awt.Font("SansSerif", 1, 14));
        pupdate.setText("Update");
        pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupdateActionPerformed(evt);
            }
        });
        pupdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pupdateKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(savebtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(closebtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(newbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(savebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(printbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pupdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(clearbtn1))
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(closebtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabcust.addTab("ಪಾವತಿ", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabcust, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabcust, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            txt6.requestFocus(true);

        }
}//GEN-LAST:event_txt4KeyPressed

    private void txt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==java.awt.event.KeyEvent.VK_TAB) {
            txt4.requestFocus(true);
        }
}//GEN-LAST:event_txt3KeyPressed

    private void gct3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct3KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
           // Gct4.requestFocus(true);

        }
}//GEN-LAST:event_gct3KeyPressed

    private void txt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            txt3.requestFocus(true);
            JOptionPane.showMessageDialog(this,""+txt2.getText());
        }
}//GEN-LAST:event_txt2KeyPressed

    private void idcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcmbActionPerformed
        // TODO add your handling code here:
        String ccmb=(String) idcmb.getSelectedItem();
        if(!ccmb.equals("-Select-"))
        {
        t1=(String) idcmb.getSelectedItem();
        try {
            gs=new Transervices();
            Trancst_model gsm=(Trancst_model)gs.viewbycid(t1);
            Font f=new Font("Akshar Unicode",Font.BOLD,16);//font	Akshar Unicode 14 Bold
            txt2.setFont(new javax.swing.plaf.FontUIResource(f));
            txt1.setText(gsm.getCid());
            txt2.setText(gsm.getCname());
            cmbNam.setSelectedItem(gsm.getCname());
            txt3.setText(gsm.getAddress());
            txt4.setText(gsm.getPhno());
            txt5.setText(gsm.getVid());
            img1=gsm.getCpic();
            img2=gsm.getVpic();
            txt6.setText(gsm.getVdetails());
            txt7.setText(gsm.getVaddress());
            txt8.setText(gsm.getV_phno());
            tamt.setText(String.valueOf(gsm.getTotamt()));
            File fil=new File(img1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(118, 118, 100)));
            File fil2=new File(img2);
            BufferedImage myImage2 = ImageIO.read(fil2);
            shot2.setText("");
            shot2.setIcon(new ImageIcon(myImage2.getScaledInstance(118, 118, 100)));
            getNextTId();
            generateCodeViews();
            savebtn.setEnabled(false);
            tupdate.setEnabled(false);
            tdel.setEnabled(false);
            newbtn.setEnabled(true);
            cupdatebtn.setEnabled(true);
            tnew.setEnabled(true);
            tsave.setEnabled(true);
            tr3.requestFocus();
            clrtrn();
        }catch(Exception e){JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        newbtn.setEnabled(true);
    }//GEN-LAST:event_idcmbActionPerformed
 
 
   
    public void clear()
    {
     txt2.setText("");
     txt3.setText("");
     txt4.setText("");
     txt5.setText("");
     txt6.setText("");
     txt7.setText("");
     txt8.setText("");
    }
    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txt6ActionPerformed

    private void txt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            txt7.requestFocus(true);

        }
}//GEN-LAST:event_txt6KeyPressed

    private void txt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt8ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txt8ActionPerformed

    private void txt8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt8KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            savebtn.requestFocus(true);

        }
}//GEN-LAST:event_txt8KeyPressed

    private void txt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==java.awt.event.KeyEvent.VK_TAB) {
           txt8.requestFocus(true);
        }


    }//GEN-LAST:event_txt7KeyPressed

    private void gct10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct10KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_gct10KeyPressed

    private void photo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_photo1KeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_photo1KeyPressed

    private void start2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start2ActionPerformed
         img2="";
         img2=txt1.getText().toString();
         img2="d:\\myImages\\V"+img2+".jpeg";
         OpenCVFrameGrabber grabber=new OpenCVFrameGrabber(0);
        try{
            grabber.start();
            IplImage img=grabber.grab();
            if(img!=null)
            {
                cvSaveImage(img2, img);
            }
            File fil=new File(img2);
            BufferedImage myImage = ImageIO.read(fil);
            shot2.setText("");
            shot2.setIcon(new ImageIcon(myImage.getScaledInstance(118, 118, 100)));
        }catch(Exception e){e.printStackTrace();}

}//GEN-LAST:event_start2ActionPerformed

    private void start2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_start2KeyPressed
        
        
}//GEN-LAST:event_start2KeyPressed

    private void tr6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr6KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10)
        {
            Double tt=Double.valueOf(tamt.getText());
            Double ga=Double.valueOf(tr6.getText());
            Double st=tt+ga;
            tamt.setText(String.valueOf(st));
            tsave.requestFocus();
        }
        
}//GEN-LAST:event_tr6KeyPressed

    private void tr4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr4KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            tr5.requestFocus(true);
        }
}//GEN-LAST:event_tr4KeyPressed
    double wt;    
    private void tsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsaveActionPerformed
        // TODO add your handling code here:
        b1=txt1.getText();
        c1=tr1.getText().trim();
        c2=tr3.getText().trim();
        c3=tr4.getText().trim();
        c4=tr5.getText().trim();
        c5=tr6.getText().trim();
        boolean b=billvalid();
        if(b)
        {
            gs=new Transervices();
            java.sql.Date gdat=new java.sql.Date(tr2.getDate().getTime());
            java.sql.Date gdat2=new java.sql.Date(trr2.getDate().getTime());
            boolean flag=false;
    //, Double weight, Double intrst, Double g_amt,Date rdate,Double ramt
            flag=gs.Trnsave(b1,c1,gdat,c2,cc3,cc4,cc5,gdat2);
            if(flag)
            {
                printbtn.setEnabled(true);
                tsave.setEnabled(false);
                tnew.setEnabled(true);
                updatecst();
                JOptionPane.showMessageDialog(this,"Data saved");
            } else {
                JOptionPane.showMessageDialog(this,"Sorry bill data not saved");
            }
        }
}//GEN-LAST:event_tsaveActionPerformed
    public void updatecst()
    {
        boolean flag = false;
        String cid=txt1.getText();
        Double ta=Double.valueOf(tamt.getText());
        gs=new Transervices();
        flag = gs.updatecst(cid,ta);
        if(flag)
        {
            
            JOptionPane.showMessageDialog(this,"TOTAL AMT SAVED");
            generateCodeViews();
        }
        else{JOptionPane.showMessageDialog(this,"TOTAL AMT Not SAVED");}
    }
    
    private boolean billvalid()
    {
        if(c2.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Item name !");return false;}
        if(c3.length()==0){JOptionPane.showMessageDialog(this,"Please Enter weight !");return false;}
        try{cc3=Double.valueOf(c3);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in weight field");return false;}
        if(c4.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Interest !");return false;}
        try{cc4=Double.valueOf(c4);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in Interest field");return false;}
        if(c5.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Given Amount !");return false;}
        try{cc5=Double.valueOf(c5);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in Given Amount field");return false;}
        return true;
    }
    private void newbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbtnActionPerformed
        // TODO add your handling code here:
        clear();
        clrtrn();
        getNextcustId();
        getNextVId();
        savebtn.setEnabled(true);
        txt2.requestFocus();
    }//GEN-LAST:event_newbtnActionPerformed
    int in;
    public void getNextcustId()
    {
        List ls;
        gs=new Transervices();
        ls=gs.getNxtcid();
        int cod=ls.size();

        Calendar now = Calendar.getInstance();
        now.setTime(new java.util.Date());
        int rd=now.get(Calendar.YEAR);
        String g="C";
        int nxt=(rd*1000)+cod+1;
        txt1.setText(String.valueOf(g+nxt));
        in=cod+1;
    }
    public void getNextVId()
    {
        List ls;
        gs=new Transervices();
        ls=gs.getNxtVid();
        int cod=ls.size();
        int nxt=cod+1;
        txt5.setText(String.valueOf(nxt));
    }
    private void newbtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newbtnKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN) {
            savebtn.requestFocus();
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP) {
            newbtn.requestFocus();
        }
}//GEN-LAST:event_newbtnKeyPressed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        // TODO add your handling code here:
        t1=txt1.getText(); 
        t2=txt2.getText();
        t3=txt3.getText();
        t4=txt4.getText();
        t5=txt5.getText();
        t6=txt6.getText();
        t7=txt7.getText();
        t8=txt8.getText();
        

        boolean g=Validatefields();
        if(g) {
            System.out.println("validation success");
            boolean flag=false;
            gs=new Transervices();
            flag=gs.savecst(t1,t2,t3,t4,img1,t5,t6,t7,t8,img2);
            if(flag)
            {
                getNextTId();
                savebtn.setEnabled(false);
                newbtn.setEnabled(true);
                tsave.setEnabled(true);
                tr3.requestFocus();
                comboCustIDs();
                JOptionPane.showMessageDialog(this,"Saved Successfully");
            } else {
                JOptionPane.showMessageDialog(this,"Data not saved");
            }
        }
}//GEN-LAST:event_savebtnActionPerformed
    public void getNextTId()
    {
        List ls;
        String cid =txt1.getText();
        gs=new Transervices();
        ls=gs.getNxtTid(cid);
        int cod=ls.size();
        String g="TR";
        int nxt=cod+1;
        tr1.setText(String.valueOf(g+nxt));
    }
    
    public boolean Validatefields()
    {
        String cn="ದಯವಿಟ್ಟು  ಗ್ರಾಹಕರ ಹೆಸರನ್ನು ಫಿಲ್ ಮಾಡಿ ";
        String ca="ದಯವಿಟ್ಟು  ಗ್ರಾಹಕರ ವಿಳಾಸ ಫಿಲ್ ಮಾಡಿ ";
        String cp="ದಯವಿಟ್ಟು  ಗ್ರಾಹಕರ ಮೊಬೈಲ್ ನ೦ ಫಿಲ್ ಮಾಡಿ ";
        String vn="ದಯವಿಟ್ಟು  ಸಾಕ್ಷಿ ಹೆಸರು ಫಿಲ್ ಮಾಡಿ ";
        String va="ದಯವಿಟ್ಟು  ಸಾಕ್ಷಿ ವಿಳಾಸ ಫಿಲ್ ಮಾಡಿ ";
        String vp="ದಯವಿಟ್ಟು  ಸಾಕ್ಷಿ ಮೊಬೈಲ್ ನ೦ ಫಿಲ್ ಮಾಡಿ ";
        if(t2.length()==0){JOptionPane.showMessageDialog(this," "+cn);return false;}
        if(t3.length()==0){JOptionPane.showMessageDialog(this," "+ca);return false;}
        if(t4.length()==0){JOptionPane.showMessageDialog(this," "+cp);return false;}
        if(t6.length()==0){JOptionPane.showMessageDialog(this," "+vn);return false;}
        if(t7.length()==0){JOptionPane.showMessageDialog(this," "+va);return false;}
        if(t8.length()==0){JOptionPane.showMessageDialog(this," "+vp);return false;}
        return true;
    }
    private void savebtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_savebtnKeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10){savebtn.doClick();}
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN) {
            printbtn.requestFocus();
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP) {
            newbtn.requestFocus();
        }
}//GEN-LAST:event_savebtnKeyPressed

    private void printbtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_printbtnKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN) {
            closebtn.requestFocus();
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP) {
            savebtn.requestFocus();
        }
}//GEN-LAST:event_printbtnKeyPressed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        // TODO add your handling code here:
        Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
}//GEN-LAST:event_closebtnActionPerformed

    private void closebtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closebtnKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN) {
            clearbtn.requestFocus();
        }
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP) {
            printbtn.requestFocus();
        }
}//GEN-LAST:event_closebtnKeyPressed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed

        // TODO add your handling code here:
        clear();
        savebtn.setEnabled(true);
        newbtn.setEnabled(false);}
    {
    }//GEN-LAST:event_clearbtnActionPerformed

        private void photoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_photoKeyPressed
           
}//GEN-LAST:event_photoKeyPressed

        private void gct6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct6ActionPerformed
         img1="";
         img1=txt1.getText().toString();
         img1="d:\\myImages\\C"+img1+".jpeg";
        OpenCVFrameGrabber grabber=new OpenCVFrameGrabber(0);
        try{
            grabber.start();
            IplImage img=grabber.grab();
            if(img!=null)
            {
                cvSaveImage(img1, img);

            }
            File fil=new File(img1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(118, 118, 100)));
        }catch(Exception e){e.printStackTrace();}

}//GEN-LAST:event_gct6ActionPerformed

        private void gct6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct6KeyPressed
            // TODO add your handling code here:
}//GEN-LAST:event_gct6KeyPressed

        private void jPanel1formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1formKeyPressed
            // TODO add your handling code here:
}//GEN-LAST:event_jPanel1formKeyPressed

        private void tupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tupdateActionPerformed
            updatealltrn();
        }//GEN-LAST:event_tupdateActionPerformed
        public void updatealltrn()
        {
            b1=txt1.getText();
            c1=tr1.getText().trim();
            c2=tr3.getText().trim();
            c3=tr4.getText().trim();
            c4=tr5.getText().trim();
            c5=tr6.getText().trim();
            boolean b=billvalid();
            if(b)
            {
                gs=new Transervices();
                java.sql.Date gdat=new java.sql.Date(tr2.getDate().getTime());
                java.sql.Date gdat2=new java.sql.Date(trr2.getDate().getTime());
                boolean flag=false;
                flag=gs.AllTrnUpdate(b1,c1,gdat,c2,cc3,cc4,cc5,gdat2);
                if(flag)
                {
                    Double s1tot=lsttot-lstgamt;
                    Double ngamt=Double.valueOf(tr6.getText());
                    Double sftot=s1tot+ngamt;
                    tamt.setText(String.valueOf(sftot));
                    printbtn.setEnabled(true);
                    tupdate.setEnabled(false);
                    tnew.setEnabled(true);
                    JOptionPane.showMessageDialog(this,"Updated Successfully");
                    updatecst();
                    
                } else {JOptionPane.showMessageDialog(this,"Failed To update");}
        }
        }
        private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
          
            genByName();
        }//GEN-LAST:event_printbtnActionPerformed
        public void genByName()
        {
        HashMap param=new HashMap();
        String cstid=txt1.getText();
        String nam=txt2.getText();
        String tid=tr1.getText();
        param.put("cid",cstid);
        param.put("cname",nam);
        param.put("trnid",tid);
        try
        {
            File fl=new File("src\\Transaction\\Reports\\TrnPrint.jrxml");
            String rep=fl.getAbsolutePath();
            TranRep repo=new TranRep(rep, param);
            repo.setBounds(0, 0, desk.getWidth(), desk.getHeight());
            repo.setVisible(true);
            this.desk.add(repo);
            tabcust.setSelectedIndex(1);
        }catch(Exception e){}
        }
        String s_sno;        String Nam;
          
        private void tsaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsaveKeyPressed
            // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            tsave.doClick();
        }
        }//GEN-LAST:event_tsaveKeyPressed

        private void tr4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tr4ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_tr4ActionPerformed

        private void tr9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr9KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_tr9KeyPressed

        private void tdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdelActionPerformed
            // TODO add your handling code here:
            String cid=txt1.getText();
            String tid=tr1.getText();
            boolean flag=false;
            gs= new Transervices();
            flag=gs.DelTrn(cid,tid);
            if(flag)
            {
                JOptionPane.showMessageDialog(this, "Deleted Successfully");
                generateCodeViews();
            }else{JOptionPane.showMessageDialog(this, "Failed To delete");}
        }//GEN-LAST:event_tdelActionPerformed

        private void tr3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr3KeyPressed
            // TODO add your handling code here:
            if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_TAB){tr4.requestFocus();}
        }//GEN-LAST:event_tr3KeyPressed

        private void gct7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct7KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_gct7KeyPressed

        private void tr8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr8KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_tr8KeyPressed
        Double lstgamt,lsttot;
        private void trntabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trntabKeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            Date gd2=null;
            if(keycode==10) {
                try {
                    int ro=trntab.getSelectedRow();
                    String tid=trntab.getModel().getValueAt(ro,0).toString();
                    String cid=txt1.getText();
                    gs=new Transervices();
                    Trantrs_mod gtm=(Trantrs_mod)gs.getAllItmfromTab(cid, tid);
                    tr1.setText(gtm.getTid());
                    java.util.Date gd=new java.util.Date();
                    gd=gtm.getGdate();
                    gd2=gtm.getRtndat();
                    tr2.setDate(gd);
                    trr2.setDate(gd2);
                    tr3.setText(gtm.getItem());
                    tr4.setText(String.valueOf(gtm.getWeight()));
                    tr5.setText(String.valueOf(gtm.getIntrst()));
                    tr6.setText(String.valueOf(gtm.getG_amt()));
                    lstgamt=gtm.getG_amt();
                    lsttot=Double.valueOf(tamt.getText());
                    java.util.Date rd=new java.util.Date();
                    rd=gtm.getRdate();
                    tr7.setDate(rd);
                    tr8.setText(String.valueOf(gtm.getRamt()));
                    String sts=gtm.getStatus();
                    if(sts.matches("Opened"))
                    {
                        tr9.setBackground(Color.red);
                        tr9.setText(gtm.getStatus());
                    }
                    if(sts.matches("Closed"))
                    {
                        tr9.setBackground(Color.GREEN);
                        tr9.setText(gtm.getStatus());
                    }
                    tupdate.setEnabled(true);
                    tsave.setEnabled(false);
                    tnew.setEnabled(true);
                    tdel.setEnabled(true);
                    printbtn.setEnabled(true);
                } catch(Exception e){JOptionPane.showMessageDialog(this,"Dont Select on the blank Row");}
            }
        }//GEN-LAST:event_trntabKeyPressed

        private void tr5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr5KeyPressed
            // TODO add your handling code here:
            int kc=evt.getKeyCode();
            if(kc==10){tr6.requestFocus();}
        }//GEN-LAST:event_tr5KeyPressed

        private void tnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnewActionPerformed
            // TODO add your handling code here:
            getNextTId();
            clrtrn();
            tsave.setEnabled(true);
        }//GEN-LAST:event_tnewActionPerformed

        private void closebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtn1ActionPerformed
            // TODO add your handling code here:
            Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
        }//GEN-LAST:event_closebtn1ActionPerformed

        private void closebtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closebtn1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_closebtn1KeyPressed

        private void tr1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tr1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_tr1KeyPressed

        private void tr7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tr7PropertyChange
            // TODO add your handling code here:
        
        }//GEN-LAST:event_tr7PropertyChange

        private void idcmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcmb1ActionPerformed
            // TODO add your handling code here:
        String ccmb=(String) idcmb1.getSelectedItem();
        if(!ccmb.equals("-Select-"))
        {
        t1=(String) idcmb1.getSelectedItem();
        try {
            gs=new Transervices();
            Trancst_model gsm=(Trancst_model)gs.viewbycid(t1);
            pc1.setText(gsm.getCname());
            cmbNam2.setSelectedItem(gsm.getCname());
            pc2.setText(gsm.getPhno());
            pc3.setText(gsm.getAddress());
            pc4.setText(String.valueOf(gsm.getTotamt()));
            img1=gsm.getCpic();
            File fil=new File(img1);
            BufferedImage myImage = ImageIO.read(fil);
            shot1.setText("");
            shot1.setIcon(new ImageIcon(myImage.getScaledInstance(178, 188, 100)));
            comboTIDs();
        }catch(Exception e){JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        }//GEN-LAST:event_idcmb1ActionPerformed

        private void photo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_photo2KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_photo2KeyPressed

        private void tidcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidcmbActionPerformed
            // TODO add your handling code here:
            String ccmb=(String) tidcmb.getSelectedItem();
        if(!ccmb.equals("-Select-"))
        {

        try {
            String cid=(String) idcmb1.getSelectedItem();
            String tid=(String) tidcmb.getSelectedItem();
            gs=new Transervices();
            Trantrs_mod gtm=(Trantrs_mod)gs.getAllItmfromTab(cid,tid);
            pt1.setText(String.valueOf(gtm.getIntrst()));
            pt2.setText(String.valueOf(gtm.getG_amt()));
            java.util.Date gd=new java.util.Date();
            gd=gtm.getGdate();
            pt3.setDate(gd);
            getNextPId();
            generatePayViews();
        }catch(Exception e){JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        }//GEN-LAST:event_tidcmbActionPerformed
        public void getNextPId()
        {
            List ls;
            String cid =(String) idcmb1.getSelectedItem();
            String tid =(String) tidcmb.getSelectedItem();
            gs=new Transervices();
            ls=gs.getNxtPid(cid,tid);
            int cod=ls.size();
            int nxt=cod+1;
            p1.setText(String.valueOf(nxt));
        }
        private void newbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbtn1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_newbtn1ActionPerformed

        private void newbtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newbtn1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_newbtn1KeyPressed

        private void savebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtn1ActionPerformed
            // TODO add your handling code here:
            m1=(String) idcmb1.getSelectedItem();
            m2=(String) tidcmb.getSelectedItem();
            m3=p1.getText();
            m4=pt2.getText();
            m5=p4.getText();
            m6=p2.getText();
            java.sql.Date pd=new java.sql.Date(p3.getDate().getTime());
            boolean vl=validpay();
            if(vl)
            {
                mm4=Double.valueOf(m4);
                boolean flag=false;
                gs=new Transervices();
                flag=gs.Savepay(m1,m2,m3,mm4,mm5,m6,pd);
                if(flag)
                {
                    updattrs();
                    
                    
                }else{JOptionPane.showMessageDialog(this, "Sorry Failed to Pay");}
            }
        }//GEN-LAST:event_savebtn1ActionPerformed
        public void updattrs()
        {
            String cid=(String) idcmb1.getSelectedItem();
            String tid=(String) tidcmb.getSelectedItem();
            java.sql.Date pd=new java.sql.Date(p3.getDate().getTime());
            Double pa=Double.valueOf(p4.getText());
            boolean flag=false;
            gs=new Transervices();
            flag=gs.UpdateTrn(cid,tid,pd,pa);
            if(flag)
            {
            generatePayViews();
            JOptionPane.showMessageDialog(this, "ಹಣ ಪಾವತಿಸಲಗಿದೆ");
        }else{JOptionPane.showMessageDialog(this, "Failed Update");}
        }
        private boolean validpay()
        {
            if(idcmb1.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  ಗ್ರಾಹಕ ನ೦ ಆಯ್ಡುಕೊ ಳ್ಳಿ");return false;}
            if(tidcmb.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  Tran ID ಆಯ್ಡುಕೊ ಳ್ಳಿ");return false;}
            if(p3.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  ದಿನಾ೦ಕ ಆಯ್ದು ಕೊ ಳ್ಳಿ");return false;}
            if(m5.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  ಪಾವತಿ ಮೊ ತ್ತವನ್ನು ನಮೊದಿಸಿರಿ");return false;}
            if(m6.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  ಪಾವತಿದಾರನ ಹೆಸರನ್ನು ನಮೊದಿಸಿರಿ");return false;}
            try{mm5=Double.valueOf(m5);}catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು  ಪಾವತಿ ಮೊ ತ್ತವನ್ನು ಸ೦ಖ್ಯೆಗಳಲ್ಲಿ ನಮೊದಿಸಿರಿ");return false;}
            return true;
        }
        private void savebtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_savebtn1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_savebtn1KeyPressed

        private void printbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtn1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_printbtn1ActionPerformed

        private void printbtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_printbtn1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_printbtn1KeyPressed

        private void clearbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtn1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_clearbtn1ActionPerformed

        private void closebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtn2ActionPerformed
            // TODO add your handling code here:
            Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
        }//GEN-LAST:event_closebtn2ActionPerformed

        private void closebtn2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closebtn2KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_closebtn2KeyPressed

        private void ptabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ptabKeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                try {
                    int ro=ptab.getSelectedRow();
                    String pid=ptab.getModel().getValueAt(ro,0).toString();
                    String cid=(String) idcmb1.getSelectedItem();
                    String tid=(String)tidcmb.getSelectedItem();
                    gs=new Transervices();
                    Tranpay_mod tpm=(Tranpay_mod)gs.GenPayDATA(cid, tid,pid);
                    p1.setText(tpm.getPid());
                    p2.setText(tpm.getPayee());
                    java.util.Date pd=new java.util.Date();
                    pd=tpm.getPdate();
                    p3.setDate(pd);
                    p4.setText(String.valueOf(tpm.getPamt()));
                    savebtn1.setEnabled(false);
                    pupdate.setEnabled(true);
                } catch(Exception e){JOptionPane.showMessageDialog(this,"Dont Select on the blank Row");}
            }
        }//GEN-LAST:event_ptabKeyPressed

        private void p3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_p3PropertyChange
            // TODO add your handling code here:
            try
        {
            //old date----------------------------------
            Calendar old = Calendar.getInstance();
            old.setTime(new java.util.Date(pt3.getDate().getTime()));
            int oyy=old.get(Calendar.YEAR);
            int omm=old.get(Calendar.MONTH);
            int odd=old.get(Calendar.DATE);
            //-------------------------------------------
            //present date---------------------------------
            Calendar now = Calendar.getInstance();
            now.setTime(new java.util.Date(p3.getDate().getTime()));
            int nyy=now.get(Calendar.YEAR);
            int nmm=now.get(Calendar.MONTH);
            int ndd=now.get(Calendar.DATE);
            //----------------------------------------------
            Date past = new Date(oyy, omm, odd); // June 20th, 2010
            Date today = new Date(nyy, nmm, ndd); // July 24th
            int days = Days.daysBetween(new DateTime(past), new DateTime(today)).getDays();
            int month = Months.monthsBetween(new DateTime(past), new DateTime(today)).getMonths();
            int mnth = month+1;
            int td=days+1;
            int totdays=getDaysInMonth(nmm, nyy);
            int dvd=totdays/2;
            if(ndd>dvd)
            {
                Double ga=Double.valueOf(pt2.getText());
                Double itrs=Double.valueOf(pt1.getText());
                Double pmi=ga/100;
                Double fi=pmi*itrs;
                Double ti=mnth*fi;
                Double tot=ti+ga;
                DecimalFormat df=new DecimalFormat("#######.##");
                String dt=df.format(tot);
                p4.setText(String.valueOf(dt));
            }
            if(ndd<=dvd)
            {
                Double tdays=Double.valueOf(td);
                Double m=tdays/30;
                Double ga=Double.valueOf(pt2.getText());
                Double itrs=Double.valueOf(pt1.getText());
                Double pmi=ga/100;
                Double fi=pmi*itrs;
                Double ti=m*fi;
                Double tot=ti+ga;
                DecimalFormat df=new DecimalFormat("#######.##");
                String dt=df.format(tot);
                p4.setText(String.valueOf(dt));}
            JOptionPane.showMessageDialog(this, "the days in a month are"+td);
        }
        catch(Exception e){}
        }//GEN-LAST:event_p3PropertyChange
        private int getDaysInMonth(int month, int year) {
            Calendar cal = Calendar.getInstance();  // or pick another time zone if necessary
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DAY_OF_MONTH, 1);      // 1st day of month
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.MINUTE, 0);
            Date startDate = cal.getTime();
            int nextMonth = (month == Calendar.DECEMBER) ? Calendar.JANUARY : month + 1;
            cal.set(Calendar.MONTH, nextMonth);
            if (month == Calendar.DECEMBER)
            {
                cal.set(Calendar.YEAR, year + 1);
            }
            Date endDate = cal.getTime();

            // get the number of days by measuring the time between the first of this
            //   month, and the first of next month
            return (int)((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000));
   }
        private void tamtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamtKeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_tamtKeyPressed

        private void p2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p2KeyPressed
            // TODO add your handling code here:
            int kc=evt.getKeyCode();
            if(kc==10){p3.requestFocus();}
        }//GEN-LAST:event_p2KeyPressed

        private void cupdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdatebtnActionPerformed
            // TODO add your handling code here:
            t1=txt1.getText();
            t2=txt2.getText();
            t3=txt3.getText();
            t4=txt4.getText();
            t5=txt5.getText();
            t6=txt6.getText();
            t7=txt7.getText();
            t8=txt8.getText();
            boolean g=Validatefields();
            if(g)
            {
                System.out.println("validation success");
                boolean flag=false;
                gs=new Transervices();
                flag=gs.Updatecst(t1,t2,t3,t4,img1,t5,t6,t7,t8,img2);
                if(flag)
                {
                    cupdatebtn.setEnabled(false);
                    newbtn.setEnabled(true);
                    JOptionPane.showMessageDialog(this,"Updated Successfully");
                } else{JOptionPane.showMessageDialog(this,"Failed TO Update");}
            }
        }//GEN-LAST:event_cupdatebtnActionPerformed

        private void pupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupdateActionPerformed
            // TODO add your handling code here:
            updatepay();
        }//GEN-LAST:event_pupdateActionPerformed
        public void updatepay()
        {
            m1=(String) idcmb1.getSelectedItem();
            m2=(String) tidcmb.getSelectedItem();
            m3=p1.getText();
            m4=pt2.getText();
            m5=p4.getText();
            m6=p2.getText();
            java.sql.Date pd=new java.sql.Date(p3.getDate().getTime());
            boolean vl=validpay();
            if(vl)
            {
                mm4=Double.valueOf(m4);
                boolean flag=false;
                gs=new Transervices();
                flag=gs.UpdatePay(m1,m2,m3,mm4,mm5,m6,pd);
                if(flag)
                {
                    updattrs();
                    JOptionPane.showMessageDialog(this, "Updated SuccessFully");

                }else{JOptionPane.showMessageDialog(this, "Sorry Failed to Updated");}
            }

        }
        private void pupdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pupdateKeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_pupdateKeyPressed

        private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_txt2ActionPerformed

        private void cmbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamActionPerformed
             String ccmb=(String) cmbNam.getSelectedItem();
        if(!ccmb.equals("-Select-"))
        {
        t1=(String) cmbNam.getSelectedItem();
        try {
            gs=new Transervices();
            Trancst_model gsm=(Trancst_model)gs.viewbyName(t1);
            Font f=new Font("Akshar Unicode",Font.BOLD,16);//font	Akshar Unicode 14 Bold
            txt2.setFont(new javax.swing.plaf.FontUIResource(f));
            txt1.setText(gsm.getCid());
            idcmb.setSelectedItem(gsm.getCid());
            txt2.setText(gsm.getCname());
            txt3.setText(gsm.getAddress());
            txt4.setText(gsm.getPhno());
            txt5.setText(gsm.getVid());
            img1=gsm.getCpic();
            img2=gsm.getVpic();
            txt6.setText(gsm.getVdetails());
            txt7.setText(gsm.getVaddress());
            txt8.setText(gsm.getV_phno());
            tamt.setText(String.valueOf(gsm.getTotamt()));
            File fil=new File(img1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(118, 118, 100)));
            File fil2=new File(img2);
            BufferedImage myImage2 = ImageIO.read(fil2);
            shot2.setText("");
            shot2.setIcon(new ImageIcon(myImage2.getScaledInstance(118, 118, 100)));
            getNextTId();
            generateCodeViews();
            savebtn.setEnabled(false);
            tupdate.setEnabled(false);
            tdel.setEnabled(false);
            newbtn.setEnabled(true);
            cupdatebtn.setEnabled(true);
            tnew.setEnabled(true);
            tsave.setEnabled(true);
            tr3.requestFocus();
            clrtrn();
        }catch(Exception e){JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        newbtn.setEnabled(true);
        }//GEN-LAST:event_cmbNamActionPerformed

        private void cmbNam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNam2ActionPerformed
                 // TODO add your handling code here:
        String ccmb=(String) cmbNam2.getSelectedItem();
        if(!ccmb.equals("-Select-"))
        {
        t1=(String)cmbNam2.getSelectedItem();
        try {
            gs=new Transervices();
            Trancst_model gsm=(Trancst_model)gs.viewbyName(t1);
            idcmb1.setSelectedItem(gsm.getCid());
            pc1.setText(gsm.getCname());
            pc2.setText(gsm.getPhno());
            pc3.setText(gsm.getAddress());
            pc4.setText(String.valueOf(gsm.getTotamt()));
            img1=gsm.getCpic();
            File fil=new File(img1);
            BufferedImage myImage = ImageIO.read(fil);
            shot1.setText("");
            shot1.setIcon(new ImageIcon(myImage.getScaledInstance(178, 188, 100)));
            comboTIDs();
        }catch(Exception e){JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        }//GEN-LAST:event_cmbNam2ActionPerformed
    public void clrtrn()
    {
      tr2.setDate(new java.util.Date());
      tr3.setText("");
      tr4.setText("");
      tr5.setText("");
      tr6.setText("");
      tr7.setDate(null);
      tr8.setText("");
    }
    public void generateCodeViews()
    {
        System.out.println("Viw 1");
        int i=0,j=0;
        double x=0.0;
        gs=new Transervices();
        Trantrs_mod trm=null;
        List lst=new LinkedList();
        String cid=(String) idcmb.getSelectedItem();
        lst=(List)gs.GenTRtab(cid);
        Object dat[][]=new Object[lst.size()+2][9];
        String col[]={"TRN ID","ವಿತರಿಸಿದ ದಿನಾ೦ಕ","ಆಭರಣಗಳು","ತೂ ಕ","ಬಡ್ಡಿ ಶೆಕಡ","ವಿತರಿಸಿದ ಮೊತ್ತ","ಸ್ವಿಕರಿಸಿದ ದಿನಾ೦ಕ"," ಸ್ವಿಕರಿಸಿದ ಮೊತ್ತ","Status"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            trm=(Trantrs_mod)itm.next();
            dat[i][0]=(String)trm.getTid();
            dat[i][1]=(Date)trm.getGdate();
            dat[i][2]=(String)trm.getItem();
            dat[i][3]=(Double)trm.getWeight();
            dat[i][4]=(Double)trm.getIntrst();
            dat[i][5]=(Double)trm.getG_amt();
            dat[i][6]=(Date)trm.getRdate();
            dat[i][7]=(Double)trm.getRamt();
            dat[i][8]=(String)trm.getStatus();
            x=x+(Double)dat[i][5];
            i++;
        }
        dat[i+1][4]="ಒಟ್ಟು ಮೊತ್ತ :";
        dat[i+1][5]=x;
        DefaultTableModel dm=new DefaultTableModel(dat,col);
        trntab.setModel(dm);
        trntab.setAutoResizeMode(trntab.AUTO_RESIZE_OFF);
        trntab.getColumnModel().getColumn(0).setPreferredWidth(60);
        trntab.getColumnModel().getColumn(1).setPreferredWidth(120);
        trntab.getColumnModel().getColumn(2).setPreferredWidth(200);
        trntab.getColumnModel().getColumn(3).setPreferredWidth(60);
        trntab.getColumnModel().getColumn(4).setPreferredWidth(80);
        trntab.getColumnModel().getColumn(5).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(6).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(7).setPreferredWidth(100);
        trntab.getColumnModel().getColumn(7).setPreferredWidth(100);
    }
    public void generatePayViews()
    {
        System.out.println("Viw 1");
        int i=0,j=0;
        gs=new Transervices();
        Tranpay_mod pmod=null;
        List lst=new LinkedList();
        String cid=(String) idcmb1.getSelectedItem();
        String tid=(String) tidcmb.getSelectedItem();
        lst=(List)gs.GenPaytab(cid,tid);
        Object dat[][]=new Object[lst.size()][9];
        String col[]={"Pay ID","ಒಟ್ಟು ಮೊ ತ್ತ","ಪಾವತಿದಾರನ ಹೆಸರು","ಪಾವತಿಸಿದ ದಿನಾ೦ಕ","ಪಾವತಿಸಿದ ಮೊ ತ್ತ"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            pmod=(Tranpay_mod)itm.next();
            dat[i][0]=(String)pmod.getPid();
            dat[i][1]=(Double)pmod.getTotamt();
            dat[i][2]=(String)pmod.getPayee();
            dat[i][3]=(Date)pmod.getPdate();
            dat[i][4]=(Double)pmod.getPamt();
            i++;
        }
       DefaultTableModel dm=new DefaultTableModel(dat,col);
       ptab.setModel(dm);
       ptab.setAutoResizeMode(ptab.AUTO_RESIZE_OFF);
       ptab.getColumnModel().getColumn(0).setPreferredWidth(70);
       ptab.getColumnModel().getColumn(1).setPreferredWidth(80);
       ptab.getColumnModel().getColumn(2).setPreferredWidth(130);
       ptab.getColumnModel().getColumn(3).setPreferredWidth(130);
       ptab.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton clearbtn1;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton closebtn1;
    private javax.swing.JButton closebtn2;
    private javax.swing.JComboBox cmbNam;
    private javax.swing.JComboBox cmbNam2;
    private javax.swing.JButton cupdatebtn;
    private javax.swing.JDesktopPane desk;
    private javax.swing.JScrollPane gct10;
    private javax.swing.JScrollPane gct3;
    private javax.swing.JButton gct6;
    private javax.swing.JScrollPane gct7;
    private javax.swing.JComboBox idcmb;
    private javax.swing.JComboBox idcmb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newbtn;
    private javax.swing.JButton newbtn1;
    private javax.swing.JLabel p1;
    private javax.swing.JTextField p2;
    private com.toedter.calendar.JDateChooser p3;
    private javax.swing.JTextField p4;
    private javax.swing.JLabel pc1;
    private javax.swing.JLabel pc2;
    private javax.swing.JTextArea pc3;
    private javax.swing.JLabel pc4;
    private javax.swing.JPanel photo;
    private javax.swing.JPanel photo1;
    private javax.swing.JPanel photo2;
    private javax.swing.JButton printbtn;
    private javax.swing.JButton printbtn1;
    private javax.swing.JLabel pt1;
    private javax.swing.JLabel pt2;
    private com.toedter.calendar.JDateChooser pt3;
    private javax.swing.JTable ptab;
    private javax.swing.JButton pupdate;
    private javax.swing.JButton savebtn;
    private javax.swing.JButton savebtn1;
    private javax.swing.JLabel shot;
    private javax.swing.JLabel shot1;
    private javax.swing.JLabel shot2;
    private javax.swing.JButton start2;
    private javax.swing.JTabbedPane tabcust;
    private javax.swing.JTextField tamt;
    private javax.swing.JButton tdel;
    private javax.swing.JComboBox tidcmb;
    private javax.swing.JButton tnew;
    private javax.swing.JTextField tr1;
    private com.toedter.calendar.JDateChooser tr2;
    private javax.swing.JTextArea tr3;
    private javax.swing.JTextField tr4;
    private javax.swing.JTextField tr5;
    private javax.swing.JTextField tr6;
    private com.toedter.calendar.JDateChooser tr7;
    private javax.swing.JTextField tr8;
    private javax.swing.JTextField tr9;
    private javax.swing.JTable trntab;
    private com.toedter.calendar.JDateChooser trr2;
    private javax.swing.JButton tsave;
    private javax.swing.JButton tupdate;
    private javax.swing.JLabel txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextArea txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextArea txt7;
    private javax.swing.JTextField txt8;
    // End of variables declaration//GEN-END:variables
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
