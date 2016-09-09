/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Gold_sale1.java
 *
 * Created on 28 Dec, 2014, 7:01:26 PM
 */

package Sales;
//camera imports
import com.googlecode.javacv.cpp.opencv_highgui;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
/*import javax.swing.JButton;*/

import Admin.MetalRate;
import Sales.Services.Goldservices;
import Sales.Services.Silver_Service;
import Sales.SilverReport.Silverrepo;
import Sales.SilverReport.SpayRep;
import Sales.model.CstAmt_mod;
import Sales.model.Goldcst_model;
import Sales.model.Silvercst_model;
import Sales.model.Silvertrs_mod;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Dell-PC
 */
public class Silver_sale extends javax.swing.JPanel   {
     Sales.Services.Silver_Service ss=new Sales.Services.Silver_Service();
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
//attrib for shadow stops************************************************
    //t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,tt12,tt13,tt14,tt15,tt16,tt17,tt18,tt19,t20
    String t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,img1="c:/myImages/imgSrini.jpg",img2="c:/myImages/imgSrini.jpg",idp1,idp2;
    Double tt10,tt11,tt12,tt13,tt14,tt15,tt16,tt18,tt19,tt17;
    String b1,b2,b3,b4,b5;
    Double bb2,bb3,bb4,taxs=0.0;
    int phot1=0,phot2=0;
    String trnd;
    String slno;
    /** Creates new form Gold_sale1 */
    public Silver_sale() throws IOException {
        initComponents();
        comboCustIDs();
        clear();
        gct21.setText(String.valueOf(MetalRate.sil));
        pydate.setDate(new java.util.Date());
        taxlbl.setText(String.valueOf(MetalRate.tax));
        Delete.setEnabled(false);
        btnUpdateSil.setEnabled(false);
        updatebtn.setEnabled(false);
        autoupload();
        comboNames();
         jDateChooser2.setDate(new java.util.Date());
    }
    public void autoupload() throws IOException
    {
        File fl=new File("src\\Sales\\IDp.png");
        ImageIcon ip= new ImageIcon(fl.getPath());
        BufferedImage myImage = ImageIO.read(fl.getAbsoluteFile());

        File fp=new File("src\\Sales\\user.png");
        ImageIcon ipr= new ImageIcon(fp.getPath());
        BufferedImage myPic = ImageIO.read(fp.getAbsoluteFile());
                    //idp1.setText("");
        idc1.setIcon(new ImageIcon(myImage.getScaledInstance(108, 118, 100)));
        idc2.setIcon(new ImageIcon(myImage.getScaledInstance(108, 118, 100)));
        shot.setIcon(new ImageIcon(myPic.getScaledInstance(118, 118, 100)));
        shot2.setIcon(new ImageIcon(myPic.getScaledInstance(118, 118, 100)));
        img1=fp.getAbsolutePath();
        img2=fp.getAbsolutePath();
        idp1=fl.getAbsolutePath();
        idp2=fl.getAbsolutePath();
    }
    public void comboCustIDs()
    {
        try
        {
        int i=0;
        List lst=null;
        ss=new Silver_Service();
        lst=(List)ss.getcustid();
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
        goldcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
        goldcmb.setMaximumRowCount(6);
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
        String cstid = (String) idcmb.getSelectedItem();
        ss=new Silver_Service();
        lst=(List)ss.getTid(cstid);
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        tcmb1.setModel(new javax.swing.DefaultComboBoxModel(cods));
        tcmb1.setMaximumRowCount(6);
        tcmb1.setFocusable(true);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        gct5 = new javax.swing.JTextField();
        gct3 = new javax.swing.JScrollPane();
        Gct3 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        gct2 = new javax.swing.JTextField();
        Gct4 = new javax.swing.JTextField();
        gct1 = new javax.swing.JLabel();
        idcmb = new javax.swing.JComboBox();
        ncmb = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        gct9 = new javax.swing.JTextField();
        gct12 = new javax.swing.JTextField();
        gct10 = new javax.swing.JScrollPane();
        Gct10 = new javax.swing.JTextArea();
        gct11 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        gct17 = new javax.swing.JTextField();
        gct18 = new javax.swing.JTextField();
        gct20 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        gct22 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        taxlbl = new javax.swing.JTextField();
        gct21 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tidlbl = new javax.swing.JTextField();
        addnewb = new javax.swing.JButton();
        savebill = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        gct16 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        txtslno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdateSil = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gstab = new javax.swing.JTable();
        gct23 = new javax.swing.JLabel();
        gct25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        gct24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tcmb1 = new javax.swing.JComboBox();
        addnewb1 = new javax.swing.JButton();
        newbtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        photo1 = new javax.swing.JPanel();
        shot2 = new javax.swing.JLabel();
        idcard1 = new javax.swing.JPanel();
        idc2 = new javax.swing.JLabel();
        start2 = new javax.swing.JButton();
        gct15 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        photo = new javax.swing.JPanel();
        shot = new javax.swing.JLabel();
        idcard = new javax.swing.JPanel();
        idc1 = new javax.swing.JLabel();
        gct6 = new javax.swing.JButton();
        gct7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Desktop1 = new javax.swing.JDesktopPane();
        closebtn1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        datelbl = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        netamtlbl = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        balamtlbl = new javax.swing.JLabel();
        goldcmb = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        tcmb2 = new javax.swing.JComboBox();
        jLabel46 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cnametxt = new javax.swing.JTextField();
        ncmb1 = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        pid = new javax.swing.JLabel();
        paytxt = new javax.swing.JTextField();
        rmbalamtlbl = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        pydate = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paytab = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        padd = new javax.swing.JButton();
        psave = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setOpaque(false);

        tabcust.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 500));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1formKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal_details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText(" Customer id:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(16, 25, 85, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Address :");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(16, 91, 58, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("City :");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(16, 142, 35, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Phone_no:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(16, 173, 75, 17);

        gct5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct5.setText(" ");
        gct5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct5KeyPressed(evt);
            }
        });
        jPanel3.add(gct5);
        gct5.setBounds(124, 173, 127, 21);

        gct3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct3KeyPressed(evt);
            }
        });

        Gct3.setColumns(20);
        Gct3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        Gct3.setRows(5);
        Gct3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Gct3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Gct3KeyPressed(evt);
            }
        });
        gct3.setViewportView(Gct3);

        jPanel3.add(gct3);
        gct3.setBounds(124, 91, 158, 40);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel15.setText("Customer name:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(16, 60, 104, 17);

        gct2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        gct2.setText(" ");
        gct2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct2KeyPressed(evt);
            }
        });
        jPanel3.add(gct2);
        gct2.setBounds(124, 58, 158, 22);

        Gct4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        Gct4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Gct4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Gct4KeyPressed(evt);
            }
        });
        jPanel3.add(Gct4);
        Gct4.setBounds(124, 142, 158, 21);

        gct1.setBackground(new java.awt.Color(255, 255, 255));
        gct1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct1.setText("-------");
        gct1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gct1.setOpaque(true);
        jPanel3.add(gct1);
        gct1.setBounds(107, 23, 84, 21);

        idcmb.setFont(new java.awt.Font("Times New Roman", 1, 12));
        idcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcmbActionPerformed(evt);
            }
        });
        jPanel3.add(idcmb);
        idcmb.setBounds(201, 22, 81, 20);

        ncmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ncmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncmbActionPerformed(evt);
            }
        });
        ncmb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ncmbKeyPressed(evt);
            }
        });
        jPanel3.add(ncmb);
        ncmb.setBounds(130, 60, 170, 20);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vitness", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel20.setText(" Personal Details :");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel21.setText(" Address :");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel22.setText(" City :");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel23.setText(" Phone_no:");

        gct9.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct9.setText(" ");
        gct9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct9ActionPerformed(evt);
            }
        });
        gct9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct9KeyPressed(evt);
            }
        });

        gct12.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct12.setText(" ");
        gct12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct12ActionPerformed(evt);
            }
        });
        gct12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct12KeyPressed(evt);
            }
        });

        gct10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct10KeyPressed(evt);
            }
        });

        Gct10.setColumns(20);
        Gct10.setFont(new java.awt.Font("Times New Roman", 1, 14));
        Gct10.setRows(5);
        Gct10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Gct10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Gct10KeyPressed(evt);
            }
        });
        gct10.setViewportView(Gct10);

        gct11.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct11KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gct9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(gct11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(gct10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gct12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gct9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(gct10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gct11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gct12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel5.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel6.setText("Purchase item :");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(10, 40, 97, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel7.setText("Weight :");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(10, 100, 54, 17);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel9.setText("Making charge :");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(10, 130, 101, 17);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel11.setText("Total payment :");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(10, 160, 97, 17);

        gct17.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct17KeyPressed(evt);
            }
        });
        jPanel5.add(gct17);
        gct17.setBounds(110, 40, 133, 21);

        gct18.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct18ActionPerformed(evt);
            }
        });
        gct18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct18KeyPressed(evt);
            }
        });
        jPanel5.add(gct18);
        gct18.setBounds(110, 100, 74, 21);

        gct20.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gct20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct20KeyPressed(evt);
            }
        });
        jPanel5.add(gct20);
        gct20.setBounds(110, 130, 74, 21);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel16.setText(" Date :");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(250, 10, 42, 17);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel31.setText("grams");
        jPanel5.add(jLabel31);
        jLabel31.setBounds(210, 100, 32, 14);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel33.setText("Tax.");
        jPanel5.add(jLabel33);
        jLabel33.setBounds(280, 190, 26, 17);

        gct22.setBackground(new java.awt.Color(255, 255, 255));
        gct22.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct22.setText("0.0");
        gct22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gct22.setOpaque(true);
        gct22.setPreferredSize(null);
        jPanel5.add(gct22);
        gct22.setBounds(110, 160, 99, 21);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel34.setText("Silver Rate:");
        jPanel5.add(jLabel34);
        jLabel34.setBounds(10, 70, 80, 17);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel35.setText("per 1 Kg");
        jPanel5.add(jLabel35);
        jLabel35.setBounds(210, 70, 44, 14);

        taxlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        taxlbl.setText("0.0");
        taxlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        taxlbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxlblActionPerformed(evt);
            }
        });
        taxlbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taxlblKeyPressed(evt);
            }
        });
        jPanel5.add(taxlbl);
        taxlbl.setBounds(310, 190, 79, 21);

        gct21.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        gct21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct21KeyPressed(evt);
            }
        });
        jPanel5.add(gct21);
        gct21.setBounds(110, 70, 74, 20);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel27.setText("Transaction ID:");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(10, 10, 97, 17);

        tidlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tidlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        tidlbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tidlblKeyPressed(evt);
            }
        });
        jPanel5.add(tidlbl);
        tidlbl.setBounds(110, 10, 61, 24);

        addnewb.setFont(new java.awt.Font("Times New Roman", 1, 14));
        addnewb.setText("+ New Itm");
        addnewb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewbActionPerformed(evt);
            }
        });
        jPanel5.add(addnewb);
        addnewb.setBounds(300, 50, 110, 25);

        savebill.setFont(new java.awt.Font("Times New Roman", 1, 14));
        savebill.setText("Save Itm");
        savebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebillActionPerformed(evt);
            }
        });
        savebill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                savebillKeyPressed(evt);
            }
        });
        jPanel5.add(savebill);
        savebill.setBounds(300, 80, 110, 25);

        Delete.setFont(new java.awt.Font("Times New Roman", 1, 14));
        Delete.setText("Delete Itm");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel5.add(Delete);
        Delete.setBounds(300, 110, 110, 25);

        gct16.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel5.add(gct16);
        gct16.setBounds(300, 10, 110, 20);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel18.setText("Pay Date");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(10, 190, 60, 17);

        jDateChooser2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel5.add(jDateChooser2);
        jDateChooser2.setBounds(110, 190, 140, 20);

        txtslno.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel5.add(txtslno);
        txtslno.setBounds(210, 10, 40, 23);

        jLabel1.setText("SlNo");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(180, 10, 30, 14);

        btnUpdateSil.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnUpdateSil.setText("Update");
        btnUpdateSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSilActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdateSil);
        btnUpdateSil.setBounds(300, 140, 110, 23);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel12.setText("Net Amount");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel13.setText(" Paid");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel14.setText(" Balance");

        gstab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SLno", "Item Name", "Date", "Silver Rate", "Weight", "Wastage", "Making Chrg", "Tax", "Total"
            }
        ));
        gstab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gstabKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(gstab);

        gct23.setBackground(new java.awt.Color(255, 255, 255));
        gct23.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct23.setText("0.0");
        gct23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gct23.setOpaque(true);

        gct25.setBackground(new java.awt.Color(255, 255, 255));
        gct25.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct25.setText("0.0");
        gct25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gct25.setOpaque(true);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel28.setText("Rs/-");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel29.setText("Rs/-");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel30.setText("Rs/-");

        gct24.setBackground(new java.awt.Color(255, 255, 255));
        gct24.setFont(new java.awt.Font("Times New Roman", 1, 14));
        gct24.setText("0");
        gct24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gct24.setOpaque(true);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel37.setText("Transaction ID:");

        tcmb1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tcmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcmb1ActionPerformed(evt);
            }
        });

        addnewb1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        addnewb1.setText("Add New Trns");
        addnewb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gct25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(gct24, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcmb1, 0, 92, Short.MAX_VALUE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(gct23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)))
                        .addGap(18, 18, 18)
                        .addComponent(addnewb1)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(gct23)
                        .addComponent(jLabel37)
                        .addComponent(tcmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(addnewb1)))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gct25)
                    .addComponent(jLabel14)
                    .addComponent(jLabel28)
                    .addComponent(jLabel13)
                    .addComponent(gct24)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        newbtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        newbtn.setText(" Add New");
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

        printbtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        printbtn.setText(" Print Invoice");
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

        closebtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        closebtn.setText(" CLOSE");
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

        clearbtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        clearbtn.setText(" CLEAR");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        savebtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
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

        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        updatebtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updatebtnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(closebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(printbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(newbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(newbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Id_proof", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel14.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel24.setText("Photo");
        jPanel14.add(jLabel24);
        jLabel24.setBounds(30, 20, 30, 14);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel26.setText("Id-card");
        jPanel14.add(jLabel26);
        jLabel26.setBounds(180, 20, 36, 14);

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
        photo1.setBounds(16, 33, 120, 120);

        idcard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idcard1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idcard1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout idcard1Layout = new javax.swing.GroupLayout(idcard1);
        idcard1.setLayout(idcard1Layout);
        idcard1Layout.setHorizontalGroup(
            idcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(idc2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );
        idcard1Layout.setVerticalGroup(
            idcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(idc2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        jPanel14.add(idcard1);
        idcard1.setBounds(148, 33, 110, 120);

        start2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        start2.setText("Start");
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
        start2.setBounds(40, 160, 73, 15);

        gct15.setFont(new java.awt.Font("Times New Roman", 1, 12));
        gct15.setText(" Upload");
        gct15.setBorder(null);
        gct15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct15ActionPerformed(evt);
            }
        });
        gct15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct15KeyPressed(evt);
            }
        });
        jPanel14.add(gct15);
        gct15.setBounds(170, 160, 78, 15);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Id_proof", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel9.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel17.setText("Photo");
        jPanel9.add(jLabel17);
        jLabel17.setBounds(30, 20, 30, 14);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel19.setText("Id-card");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(190, 20, 36, 14);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, photoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(shot, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jPanel9.add(photo);
        photo.setBounds(10, 40, 120, 120);

        idcard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        idcard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idcardKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout idcardLayout = new javax.swing.GroupLayout(idcard);
        idcard.setLayout(idcardLayout);
        idcardLayout.setHorizontalGroup(
            idcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(idc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );
        idcardLayout.setVerticalGroup(
            idcardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, idcardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idc1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel9.add(idcard);
        idcard.setBounds(150, 40, 110, 120);

        gct6.setFont(new java.awt.Font("Times New Roman", 1, 12));
        gct6.setText("CLICK");
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
        gct6.setBounds(40, 160, 62, 15);

        gct7.setFont(new java.awt.Font("Times New Roman", 1, 12));
        gct7.setText(" Upload");
        gct7.setBorder(null);
        gct7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gct7ActionPerformed(evt);
            }
        });
        gct7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gct7KeyPressed(evt);
            }
        });
        jPanel9.add(gct7);
        gct7.setBounds(160, 160, 79, 15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabcust.addTab("Customer Entry", jPanel1);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel10.setText("Preview");

        closebtn1.setFont(new java.awt.Font("SansSerif", 1, 14));
        closebtn1.setText(" CLOSE");
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
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(jLabel10)
                        .addGap(556, 556, 556)
                        .addComponent(closebtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Desktop1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(closebtn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Desktop1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabcust.addTab("Preview", jPanel7);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaction Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel10.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel36.setText("Name :");
        jPanel10.add(jLabel36);
        jLabel36.setBounds(58, 73, 44, 26);

        datelbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        datelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        datelbl.setOpaque(true);
        jPanel10.add(datelbl);
        datelbl.setBounds(105, 111, 131, 26);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel38.setText("Net Amount:");
        jPanel10.add(jLabel38);
        jLabel38.setBounds(269, 74, 80, 24);

        netamtlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        netamtlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(netamtlbl);
        netamtlbl.setBounds(359, 74, 141, 24);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel40.setText("Balance Amount:");
        jPanel10.add(jLabel40);
        jLabel40.setBounds(242, 109, 107, 28);

        balamtlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        balamtlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(balamtlbl);
        balamtlbl.setBounds(359, 109, 80, 24);

        goldcmb.setFont(new java.awt.Font("Times New Roman", 1, 14));
        goldcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldcmbActionPerformed(evt);
            }
        });
        jPanel10.add(goldcmb);
        goldcmb.setBounds(112, 33, 103, 30);

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel45.setText("Customer ID:");
        jPanel10.add(jLabel45);
        jLabel45.setBounds(16, 40, 86, 17);

        tcmb2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tcmb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcmb2ActionPerformed(evt);
            }
        });
        jPanel10.add(tcmb2);
        tcmb2.setBounds(365, 33, 103, 23);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel46.setText("Transaction ID:");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(258, 36, 97, 17);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel39.setText("Date:");
        jPanel10.add(jLabel39);
        jLabel39.setBounds(61, 111, 34, 26);

        cnametxt.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        cnametxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel10.add(cnametxt);
        cnametxt.setBounds(110, 70, 110, 30);

        ncmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ncmb1ActionPerformed(evt);
            }
        });
        ncmb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ncmb1KeyPressed(evt);
            }
        });
        jPanel10.add(ncmb1);
        ncmb1.setBounds(110, 70, 130, 30);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel42.setText("Payment ID:");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel43.setText("Pay Amount:");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel44.setText("Balance Amount:");

        pid.setFont(new java.awt.Font("Times New Roman", 1, 14));
        pid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        paytxt.setFont(new java.awt.Font("Times New Roman", 1, 14));
        paytxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        paytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paytxtActionPerformed(evt);
            }
        });
        paytxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paytxtKeyPressed(evt);
            }
        });

        rmbalamtlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        rmbalamtlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel47.setText("Date:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rmbalamtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pydate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(8, 8, 8)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmbalamtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(pydate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        paytab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(paytab);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        padd.setFont(new java.awt.Font("Times New Roman", 1, 14));
        padd.setText("New Payment");
        padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paddActionPerformed(evt);
            }
        });

        psave.setFont(new java.awt.Font("Times New Roman", 1, 14));
        psave.setText("Save Payment");
        psave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psaveActionPerformed(evt);
            }
        });
        psave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psaveKeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(padd, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(psave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(padd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(psave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabcust.addTab("Payment", jPanel8);

        jLabel25.setFont(new java.awt.Font("Lucida Bright", 1, 18));
        jLabel25.setForeground(new java.awt.Color(252, 0, 0));
        jLabel25.setText("Silver Sales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(524, 524, 524))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tabcust, javax.swing.GroupLayout.PREFERRED_SIZE, 1217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabcust, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gct5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct5KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct9.requestFocus(true);

        }
}//GEN-LAST:event_gct5KeyPressed

    private void Gct3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Gct3KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Gct4.requestFocus(true);
        }
}//GEN-LAST:event_Gct3KeyPressed

    private void gct3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct3KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Gct4.requestFocus(true);

        }
}//GEN-LAST:event_gct3KeyPressed

    private void gct2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct2KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Gct3.requestFocus(true);
        }
}//GEN-LAST:event_gct2KeyPressed

    private void Gct4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Gct4KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct5.requestFocus(true);
        }
}//GEN-LAST:event_Gct4KeyPressed

    private void idcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcmbActionPerformed
        // TODO add your handling code here:
        t1=(String) idcmb.getSelectedItem();
        try {
            ss=new Silver_Service();
            Silvercst_model gsm=(Silvercst_model)ss.viewbycid(t1);
            gct1.setText(gsm.getCid());
            gct2.setText(gsm.getCname());
            Gct3.setText(gsm.getAddress());
            Gct4.setText(gsm.getCity());
            gct5.setText(gsm.getPhno());
            gct9.setText(gsm.getPdetails());
            Gct10.setText(gsm.getPaddress());
            gct11.setText(gsm.getPcity());
            gct12.setText(gsm.getP_phno());
            //******************
            String im1="",im2="",im3="",im4="";
            im1=gsm.getImg1();
            im2=gsm.getIdp1();
            im3=gsm.getImg2();
            im4=gsm.getIdp2();

              img1=gsm.getImg1();
            idp1=gsm.getIdp1();
            img2=gsm.getImg2();
            idp2=gsm.getIdp2();

            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(120, 115, 100)));

            File fil1=new File(im2);
            BufferedImage myImage1 = ImageIO.read(fil1);
            idc1.setText("");
            idc1.setIcon(new ImageIcon(myImage1.getScaledInstance(115, 115, 100)));

            File fil2=new File(im3);
            BufferedImage myImage2 = ImageIO.read(fil2);
            shot2.setText("");
            shot2.setIcon(new ImageIcon(myImage2.getScaledInstance(120, 115, 100)));

            File fil3=new File(im4);
            BufferedImage myImage3 = ImageIO.read(fil3);
            idc2.setText("");
            idc2.setIcon(new ImageIcon(myImage3.getScaledInstance(115, 115, 100)));
            savebtn.setEnabled(false);

            //*******************


             Double gt,gb;
            gt=Double.valueOf(gct23.getText());
            gb=Double.valueOf(gct25.getText());
            Double p=gt-gb;
            String pa=String.valueOf(p);
            gct24.setText(pa);
            
            comboTIDs();
            java.util.Date di =new java.util.Date();
            String de=String.valueOf(gsm.getTrans_date());
            di=Date.valueOf(de);
            gct16.setDate(di);
            updatebtn.setEnabled(true);
            clearTranstab();
            getTcount();
            getNextTId();
            gct23.setText("0.0");
            gct24.setText("0.0");
            gct25.setText("0.0");
            clearTransData();

        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data not found search another no"+e);
        }
        newbtn.setEnabled(true);

    }//GEN-LAST:event_idcmbActionPerformed
    public void byname()
        {
        t2=(String) ncmb.getSelectedItem();
        try {

            Goldservices gs=new Goldservices();
            Goldcst_model gsm=(Goldcst_model)gs.viewbyName(t2);
            idcmb.setSelectedItem(gsm.getCid());
            gct1.setText(gsm.getCid());
            gct2.setText(gsm.getCname());
            Gct3.setText(gsm.getAddress());
            Gct4.setText(gsm.getCity());
            gct5.setText(gsm.getPhno());
            gct9.setText(gsm.getPdetails());
            Gct10.setText(gsm.getPaddress());
            gct11.setText(gsm.getPcity());
            gct12.setText(gsm.getP_phno());
            //******************
            String im1="",im2="",im3="",im4="";
            im1=gsm.getImg1();
            im2=gsm.getIdp1();
            im3=gsm.getImg2();
            im4=gsm.getIdp2();

              img1=gsm.getImg1();
            idp1=gsm.getIdp1();
            img2=gsm.getImg2();
            idp2=gsm.getIdp2();
            
            File fil=new File(im1);
            BufferedImage myImage = ImageIO.read(fil);
            shot.setText("");
            shot.setIcon(new ImageIcon(myImage.getScaledInstance(120, 115, 100)));

            File fil1=new File(im2);
            BufferedImage myImage1 = ImageIO.read(fil1);
            idc1.setText("");
            idc1.setIcon(new ImageIcon(myImage1.getScaledInstance(115, 115, 100)));

            File fil2=new File(im3);
            BufferedImage myImage2 = ImageIO.read(fil2);
            shot2.setText("");
            shot2.setIcon(new ImageIcon(myImage2.getScaledInstance(120, 115, 100)));

            File fil3=new File(im4);
            BufferedImage myImage3 = ImageIO.read(fil3);
            idc2.setText("");
            idc2.setIcon(new ImageIcon(myImage3.getScaledInstance(115, 115, 100)));
            savebtn.setEnabled(false);

            //*******************


             Double gt,gb;
            gt=Double.valueOf(gct23.getText());
            gb=Double.valueOf(gct25.getText());
            Double p=gt-gb;
            String pa=String.valueOf(p);
            gct24.setText(pa);

            comboTIDs();
            java.util.Date di =new java.util.Date();
            String de=String.valueOf(gsm.getTrans_date());
            di=Date.valueOf(de);
            gct16.setDate(di);
            updatebtn.setEnabled(true);

        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data not found search another no"+e);
        }
        }
 
    public void generateViews()
    {
        try{
        t1=gct1.getText();
        t2=tidlbl.getText();
        int i=0,j=0;
        double x=0;
        ss=new Silver_Service();
        taxs=0.0;
        Silvertrs_mod stm=null;
        List lst=new LinkedList();
        lst=(List)ss.getgspTab(t1,t2);
        Object dat[][]=new Object[lst.size()+3][10];
        String col[]={"Slno","Item name","Date","Silver rate","Weight","Making Charge","Tax","Total"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            stm=(Sales.model.Silvertrs_mod)itm.next();
            dat[i][0]=(String)stm.getSlno();
            dat[i][1]=(String)stm.getPurch_item();
            dat[i][2]=(Date)stm.getT_date();
            dat[i][3]=(Double)stm.getGoldrate();
            dat[i][4]=(Double)stm.getWeight();
            dat[i][5]=(Double)stm.getMak_chrg();
            dat[i][6]=(Double)stm.getTax();
            dat[i][7]=(Double)stm.getTotamt();
            x=x+(Double)dat[i][7];
            taxs=taxs+(Double)stm.getTax();
            i++;
        }
        dat[i+1][6]="Net Amount";
        dat[i+1][7]=x;
       DefaultTableModel dm=new DefaultTableModel(dat,col);
       gstab.setModel(dm);
       gstab.setAutoResizeMode(gstab.AUTO_RESIZE_OFF);
       gstab.getColumnModel().getColumn(0).setPreferredWidth(30);
       gstab.getColumnModel().getColumn(1).setPreferredWidth(80);
       gstab.getColumnModel().getColumn(2).setPreferredWidth(80);
       gstab.getColumnModel().getColumn(3).setPreferredWidth(80);
       gstab.getColumnModel().getColumn(4).setPreferredWidth(50);
       gstab.getColumnModel().getColumn(5).setPreferredWidth(50);
       gstab.getColumnModel().getColumn(6).setPreferredWidth(100);
       gstab.getColumnModel().getColumn(7).setPreferredWidth(80);
        }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}

    }
 
        public void clear()
    {
     gct2.setText("");
     Gct3.setText("");
     Gct4.setText("");
     gct5.setText("");
     gct9.setText("");
     Gct10.setText("");
     gct11.setText("");
     gct12.setText("");
     gct16.setDate(new java.util.Date());
     gct17.setText("");
     gct18.setText("");
     gct20.setText("");
     gct22.setText("0.0");
     taxlbl.setText("");
     gct23.setText("0.0");
     gct24.setText("0");
     gct25.setText("0.0");
    }
    private void gct9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct9ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_gct9ActionPerformed

    private void gct9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct9KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Gct10.requestFocus(true);

        }
}//GEN-LAST:event_gct9KeyPressed

    private void gct12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct12ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_gct12ActionPerformed

    private void gct12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct12KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            savebtn.requestFocus(true);

        }
}//GEN-LAST:event_gct12KeyPressed

    private void Gct10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Gct10KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct11.requestFocus(true);
        }


    }//GEN-LAST:event_Gct10KeyPressed

    private void gct10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct10KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_gct10KeyPressed

    private void gct11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct11KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct12.requestFocus(true);
        }
}//GEN-LAST:event_gct11KeyPressed

    private void gct17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct17KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct21.requestFocus(true);

        }
}//GEN-LAST:event_gct17KeyPressed

    private void gct18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct18KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Double sr=Double.valueOf(gct21.getText());
            Double tot=sr/10;
            Double w=Double.valueOf(gct18.getText());
            Double t=tot*w;
            String ta=String.valueOf(t);
            gct20.requestFocus(true);
            gct22.setText(ta);
        }
}//GEN-LAST:event_gct18KeyPressed
    double wt;
    private void gct20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct20KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            Double t=Double.valueOf(gct22.getText());
            Double mc=Double.valueOf(gct20.getText());
            Double tot=t+mc;
            wt=tot;
            String ta=String.valueOf(tot);
            gct22.setText(ta);
            taxlbl.requestFocus(true);
            savebill.setEnabled(true);
        }
}//GEN-LAST:event_gct20KeyPressed

    private void gct16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct16KeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10) {
            gct17.requestFocus(true);
        }
}//GEN-LAST:event_gct16KeyPressed
    double tax=0.0;
    private void taxlblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxlblKeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        String pa="";
        if(keycode==10)
        {
            double t=Double.valueOf(gct22.getText());
            double taxn=Double.valueOf(taxlbl.getText());
            tax=((t*taxn)/100);
            double tot=t+tax;
            double dpt=Double.valueOf(gct23.getText());
            double bpt=Double.valueOf(gct25.getText());
            double dt=dpt+tot;
            double ba=tot+bpt;
            gct25.setText(String.valueOf(ba));
            String ta=String.valueOf(tot);
            String dtp=String.valueOf(dt);
            gct22.setText(ta);
            gct23.setText(dtp);
           Double gt=Double.valueOf(gct23.getText());
           Double gb=Double.valueOf(gct25.getText());
           Double p=gt-gb;
           pa=String.valueOf(p);
           gct24.setText(pa);
           savebill.requestFocus(true);
        }
}//GEN-LAST:event_taxlblKeyPressed
    
    private void savebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebillActionPerformed
        // TODO add your handling code here:
        //getTcount();
        t11=gct17.getText();//purchase//
        t12=gct21.getText();//gold rate//
        t13=gct18.getText();//weight//
        t15=gct20.getText();//making charge//
        t16=taxlbl.getText();//tax
        t17=gct22.getText();//total payment//
        tt12=Double.valueOf(t12);
        tt17=Double.valueOf(t17);
        b1=gct1.getText();
        
        trnd=tidlbl.getText();
        boolean b=billvalid();

        if(b) {
            java.sql.Date d=(Date) new java.sql.Date(gct16.getDate().getTime());
        java.sql.Date rtd=new java.sql.Date(jDateChooser2.getDate().getTime());
            tt16=tax;
            boolean flag=false;
            ss=new Silver_Service();
            flag=ss.billsave(b1,trnd,slno,d,t11,tt12,tt13,tt15,tax,tt17,wt,rtd);
            if(flag) {
                t1=gct1.getText();
                updatecust();
                 savebill.setEnabled(false);
                generateViews();
                comboTIDs();
                printbtn.setEnabled(true);
                savebill.setEnabled(false);
                addnewb.doClick();
            } else {
                JOptionPane.showMessageDialog(this,"Sorry bill data not saved");
            }
        }
}//GEN-LAST:event_savebillActionPerformed
    public void getTcount()
    {
        List ls;
        String cid =gct1.getText();
        String trnid = tidlbl.getText();
        ss=new Silver_Service();
        ls=ss.getCount(cid,trnid);
        int cod=ls.size();
        int nxt=cod+1;
        slno=String.valueOf(nxt);
        l_sno=cod;
        txtslno.setText(slno);
    }
int l_sno;
    public void updatecust()
    {
        b1=gct1.getText();
        b2=gct23.getText().trim();
        Double bb2,bb3;
        b3=gct25.getText().trim();
        bb2=Double.valueOf(b2);
        bb3=Double.valueOf(b3);
        String trnid =tidlbl.getText();
        boolean flag=false;
        ss=new Silver_Service();
        flag=ss.updateAMTdata(b1,trnid,bb2,bb3);
        if(flag)
        {
            JOptionPane.showMessageDialog(this,"the  total Amount for you is"+bb2+"\n and Your due amount is "+bb3);
        }
        else
        {
            JOptionPane.showMessageDialog(this ,"sorry u cant make transaction");
        }
    }
    private boolean billvalid()
    {
        if(t11.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Item name !");return false;}
        try{tt13=Double.valueOf(t13);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in weight field");return false;}
        try{tt15=Double.valueOf(t15);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in making charge field");return false;}
       try{tt16=Double.valueOf(t16);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in tax field ");return false;}
        if(b1.length()==0){JOptionPane.showMessageDialog(this,"please select the voucher id");return false;}
        return true;
    }
    private void newbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbtnActionPerformed
        try 
        {
            autoupload();
            clear();
            clearTranstab();
            
            getNextcustId();

            savebtn.setEnabled(true);
            newbtn.setEnabled(false);
            savebill.setEnabled(false);
            gct2.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error"+e);
        }
        
    }//GEN-LAST:event_newbtnActionPerformed
    int in;
    public void getNextcustId()
    {
        List ls;
        ss=new Silver_Service();
        ls=ss.getNxtcid();
        int cod=ls.size();
        Calendar now = Calendar.getInstance();
        now.setTime(new java.util.Date());
        int yy=now.get(Calendar.YEAR);
        String g="C";
        int nxt=(yy*1000)+cod+1;
        gct1.setText(String.valueOf(g+nxt));
        in=cod+1;
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
        t1=gct1.getText(); //Customer id//
        t2=gct2.getText();//cust name//
        t3=Gct3.getText();//address//
        t4=Gct4.getText();//city//
        t5=gct5.getText();//phone no//
        t6=gct9.getText();//personal details//
        t7=Gct10.getText();//address//
        t8=gct11.getText();//city//
        t9=gct12.getText();//phone no.//
        java.sql.Date d=(Date) new java.sql.Date(gct16.getDate().getTime());
        boolean g=Validatefields();
        if(g) {
            System.out.println("validation success");
            boolean flag=false;
            ss=new Silver_Service();
            t2=t2+" "+t1;
            flag=ss.goldsalesave(t1,t2,t3,t4,t5,t6,t7,t8,t9,d,img1,img2,idp1,idp2);
            if(flag)
            {
                getNextTId();
                creatTrans();
                getTcount();
                savebtn.setEnabled(false);
                newbtn.setEnabled(true);
                savebill.setEnabled(true);
                gct17.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this,"Data not saved");
            }
        }
}//GEN-LAST:event_savebtnActionPerformed
    public void getNextTId()
    {
        List ls;
        String cid =gct1.getText();
        ss=new Silver_Service();
        ls=ss.getNxtTid(cid);
        int cod=ls.size();
        String g="INV";
        int nxt=cod+1;
        tidlbl.setText(String.valueOf(g+nxt));
    }
    public void creatTrans()
    {
        String tr1,tr2;
        tr1=gct1.getText();
        tr2 = tidlbl.getText();
        boolean flag = false;
        ss=new Silver_Service();
        flag = ss.Transsave(tr1,tr2);
        if(flag)
        {
            JOptionPane.showMessageDialog(this,"Customer AddedSucessfully Start transacion");
        }
        else{JOptionPane.showMessageDialog(this,"Failed to set Transaction");}
    }
    public boolean Validatefields()
    {
       if(t1.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Customer ID !");return false;}
        if(t2.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Customer Name !");return false;}
        if(t3.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Customer Address !");return false;}
        if(t4.matches("-select city-")){JOptionPane.showMessageDialog(this,"Please Enter City !");return false;}
        if(t5.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Phone Number  !");return false;}
        if(t6.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Personal details  !");return false;}
        if(t7.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Address !");return false;}
        if(t8.matches("-select city-")){JOptionPane.showMessageDialog(this,"Please Enter city !");return false;}
        if(t9.length()==0){JOptionPane.showMessageDialog(this,"Please Enter Phone Number !");return false;}
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

        private void jPanel1formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1formKeyPressed
            // TODO add your handling code here:
}//GEN-LAST:event_jPanel1formKeyPressed

        private void addnewbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewbActionPerformed

     clearTransData();

        }//GEN-LAST:event_addnewbActionPerformed
        public void clearTransData()
    {
            gct16.setDate(new java.util.Date());
     gct17.setText("");
     gct18.setText("");
     gct20.setText("");
     gct22.setText("0.0");
     taxlbl.setText("0.0");
     gct17.requestFocus();
     getTcount();
     savebill.setEnabled(true);
     Delete.setEnabled(false);
     btnUpdateSil.setEnabled(false);
        }
        private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
           boolean pv=validprint();
            if(pv)
            {
                //$P{cid}$P{cname}$P{tdat}$P{rate}$P{tot}
            String id= gct1.getText();
            java.sql.Date d=(Date) new java.sql.Date(gct16.getDate().getTime());
            //d=Date.valueOf(gct16.getDate().getTime());
            String dat=String.valueOf(d);
            String cn=gct2.getText();
            String t=gct23.getText();
            String r=gct21.getText();
            String trn=tidlbl.getText();
            Double tt=Double.valueOf(gct23.getText());
            Double tx=taxs;
            Double wtx=tt-tx;
            HashMap param=new HashMap();
            param.put("cid",id);
            param.put("cname", cn);
            param.put("tdat", dat);
            param.put("rat", r);
            param.put("tot", t);
            param.put("t_id", trn);
            param.put("stx", tx);
            param.put("wt", wtx);
             try{
            JOptionPane.showMessageDialog(null,"Openeing Report");
            File fl=new File("src\\Sales\\SilverReport\\Silverrepo");
            String sr=fl.getAbsolutePath();
            Silverrepo repo=new Silverrepo(sr, param);
            repo.setBounds(0, 0, Desktop1.getWidth(), Desktop1.getHeight());
            repo.setVisible(true);
            this.Desktop1.add(repo);
            tabcust.setSelectedIndex(1);
            }catch(Exception e){}
            }
            
        }//GEN-LAST:event_printbtnActionPerformed
        String s_sno;
        Double lstnt,lstnb;
        private void gstabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gstabKeyPressed
        // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            if(keycode==10) {
        int ro=gstab.getSelectedRow();
        try
        {
        String sln=gstab.getModel().getValueAt(ro,0).toString();
        
        if(gct1.getText().length()==0)JOptionPane.showMessageDialog(null,"Invoice No Shoud not be blank");
        String cid=gct1.getText().trim();
        String trid=tidlbl.getText().trim();
        ss=new Silver_Service();
        Silvertrs_mod stm=(Silvertrs_mod)ss.getAllItmfromTab(cid, trid, sln);
        Date dt1=(Date)stm.getT_date();
        Date dt2=(Date)stm.getRtndat();
        gct16.setDate(dt1);
        jDateChooser2.setDate(dt2);

        gct17.setText(stm.getPurch_item());
        String gr=String.valueOf(stm.getGoldrate());
        gct21.setText(gr);
        String wt=String.valueOf(stm.getWeight());
        gct18.setText(wt);
        String mc=String.valueOf(stm.getMak_chrg());
        gct20.setText(mc);
        String tx=String.valueOf(stm.getTax());
        taxlbl.setText(tx);
        String ta=String.valueOf(stm.getTotamt());
        lsttot=stm.getTotamt();
        gct22.setText(ta);
        s_sno =sln;
        lstnt=Double.valueOf(gct23.getText());
        lstnb=Double.valueOf(gct25.getText());
        txtslno.setText(sln);
         Delete.setEnabled(true);
         btnUpdateSil.setEnabled(true);

        }
        catch(Exception e){JOptionPane.showMessageDialog(this,"Dont Select on the blank Row");}
            }
        }//GEN-LAST:event_gstabKeyPressed

        private void closebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtn1ActionPerformed
            // TODO add your handling code here:
            Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
        }//GEN-LAST:event_closebtn1ActionPerformed

        private void closebtn1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closebtn1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_closebtn1KeyPressed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            // TODO add your handling code here:
            Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
        }//GEN-LAST:event_jButton3ActionPerformed
        String Nam;
        private void goldcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldcmbActionPerformed
            // TODO add your handling code here:
            t1=(String) goldcmb.getSelectedItem();
        try {

            ss=new Silver_Service();
            Silvercst_model ssm=(Silvercst_model)ss.viewbycid(t1);
            java.util.Date d= ssm.getTrans_date();
            System.out.println("  "+d);
            Nam=ssm.getCname();
            java.util.Date di =new java.util.Date();
            String de=String.valueOf(d);
            di=Date.valueOf(de);
            String pd=String.valueOf(di);
            datelbl.setText(pd);
            comboPTIDs();
            
        } catch(Exception e) {JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }//GEN-LAST:event_goldcmbActionPerformed
        public void comboPTIDs()
    {
        try
        {
        int i=0;
        String cstid = (String) goldcmb.getSelectedItem();
        ss=new Silver_Service();
        List lst=null;
        lst=(List)ss.getTid(cstid);
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        tcmb2.setModel(new javax.swing.DefaultComboBoxModel(cods));
        tcmb2.setMaximumRowCount(6);
        tcmb2.setFocusable(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
        public void generatepaymentViews()
    {
        t1=(String) goldcmb.getSelectedItem();
        t2=(String) tcmb2.getSelectedItem();
        int i=0,j=0;
        Sales.model.Silverpay_mod spm=null;
        List lst=new LinkedList();
        lst=(List)ss.getpayTab(t1,t2);
        Object dat[][]=new Object[lst.size()][7];
        String col[]={"Payment Id","Transaction Date","Net Amount","Balance","Payment Amount","Paid date"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            spm=(Sales.model.Silverpay_mod)itm.next();
            dat[i][0]=(Integer)spm.getPid();
            dat[i][1]=(Date)spm.getTdat();
            dat[i][2]=(Double)spm.getNa();
            dat[i][3]=(Double)spm.getBa();
            dat[i][4]=(Double)spm.getPamt();
            dat[i][5]=(Date)spm.getPaydate();
            i++;
        }
        //dat[i+1][7]="Net Amount";
        //dat[i+1][8]=x;
       DefaultTableModel dm=new DefaultTableModel(dat,col);
       paytab.setModel(dm);
       paytab.setAutoResizeMode(paytab.AUTO_RESIZE_OFF);
       paytab.getColumnModel().getColumn(0).setPreferredWidth(100);
       paytab.getColumnModel().getColumn(1).setPreferredWidth(100);
       paytab.getColumnModel().getColumn(2).setPreferredWidth(100);
       paytab.getColumnModel().getColumn(3).setPreferredWidth(100);
       paytab.getColumnModel().getColumn(4).setPreferredWidth(100);
       paytab.getColumnModel().getColumn(5).setPreferredWidth(100);
      // String tot=String.valueOf(x);
      // gct23.setText(tot);

    }
        public void getpids()
    {
        List ls;
        String gid=(String) goldcmb.getSelectedItem();
        String tid=(String) tcmb2.getSelectedItem();
        ss=new Silver_Service();
        ls=ss.getNxtpid(gid,tid);
        int cod=ls.size();
        int nxt=cod+1;
        pid.setText(String.valueOf(nxt));
    }
        private void psaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psaveActionPerformed
            // TODO add your handling code here:  gold_trans
            
            boolean vp=validatepay();
            p3=netamtlbl.getText();
            p4=balamtlbl.getText();
            p5=Integer.valueOf(pid.getText());
            pp3=Double.valueOf(p3);
            pp4=Double.valueOf(p4);
            Date td= Date.valueOf(datelbl.getText());
            java.sql.Date pd=(Date) new java.sql.Date(pydate.getDate().getTime());
            trnd=(String) tcmb2.getSelectedItem();
            if(vp)
            {
                boolean flag=false;
                ss=new Silver_Service();
                flag=ss.savepayment(p1,trnd,pd,pp3,pp4,p5,pp6,pd);
                if(flag)
                {
                    JOptionPane.showMessageDialog(this,"ready to bill data saved success fully");
                    updatebal();
                    generatepaymentViews();
                    psave.setEnabled(false);
                    padd.setEnabled(true);
                }
                else
                {
                   JOptionPane.showMessageDialog(this,"sorry u cant able to print bill data not saved");
                }
            }

        }//GEN-LAST:event_psaveActionPerformed
        public void updatebal()
    {
        b1=(String) goldcmb.getSelectedItem();
        String trid=(String) tcmb2.getSelectedItem();
        b3=rmbalamtlbl.getText();
        b2=netamtlbl.getText().trim();
        Double bb2,pb3;
        bb2=Double.valueOf(b2);
        pb3=Double.valueOf(b3);
        boolean flag=false;
        flag=ss.updateAMTdata(b1,trid,bb2,pb3);
        if(flag)
        {
            JOptionPane.showMessageDialog(this,"the  total Amount for you is"+bb2+"\n and Your due amount is "+pb3);

        }
        else
        {
            JOptionPane.showMessageDialog(this ,"sorry u cant make transaction");
        }
    }
        private void paytxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paytxtKeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                Double p=Double.valueOf(paytxt.getText());
                Double b=Double.valueOf(balamtlbl.getText());
                Double bal=b-p;
                String bamt=String.valueOf(bal);
                rmbalamtlbl.setText(bamt);
                balamtlbl.setText(bamt);
                psave.setEnabled(true);
                psave.requestFocus();
            }

        }//GEN-LAST:event_paytxtKeyPressed

        private void paytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paytxtActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_paytxtActionPerformed

        private void paddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paddActionPerformed
            // TODO add your handling code here:
            pydate.setDate(new java.util.Date());
            paytxt.setText("");
            rmbalamtlbl.setText("");
            padd.setEnabled(false);
            paytxt.requestFocus();
            getpids();
        }//GEN-LAST:event_paddActionPerformed

        private void taxlblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxlblActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_taxlblActionPerformed

        private void savebillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_savebillKeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
        if(keycode==10) {
            savebill.doClick();
        }
        }//GEN-LAST:event_savebillKeyPressed

        private void psaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psaveKeyPressed
            // TODO add your handling code here:
             int keycode=evt.getKeyCode();
        if(keycode==10) {
            psave.doClick();
        }
        }//GEN-LAST:event_psaveKeyPressed

        private void gct18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct18ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_gct18ActionPerformed

        private void gct21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct21KeyPressed
            int keycode=evt.getKeyCode();

        if(keycode==10) {
            try{MetalRate.sil=Double.valueOf(gct21.getText());}catch(Exception e){}
            
            gct18.requestFocus(true);
        }
        }//GEN-LAST:event_gct21KeyPressed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            // TODO add your handling code here:
           if(goldcmb.getSelectedIndex()!=0){
                //$P{cid}$P{cname}$P{tdat}$P{rate}$P{tot}
            String id= (String) goldcmb.getSelectedItem();
            String cn=Nam;
            String td=(String) tcmb2.getSelectedItem();
            //$P{cstid}$P{cstid}
            HashMap param=new HashMap();
            param.put("cstid",id);
            param.put("cname", cn);//t_id
            param.put("t_id",td);
            try{
           // JOptionPane.showMessageDialog(null,"Openeing Report");
            File fl=new File("src\\Sales\\SilverReport\\SPayment.jrxml");
            String sr=fl.getAbsolutePath();
            SpayRep repo=new SpayRep(sr, param);
            repo.setBounds(0, 0, Desktop1.getWidth(), Desktop1.getHeight());
            repo.setVisible(true);
            this.Desktop1.add(repo);
            tabcust.setSelectedIndex(1);
            }catch(Exception e){}
            }
        }//GEN-LAST:event_jButton4ActionPerformed

        private void tidlblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tidlblKeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_tidlblKeyPressed

        private void tcmb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcmb2ActionPerformed
            // TODO add your handling code here:
            getPamtdata();
        }//GEN-LAST:event_tcmb2ActionPerformed

        private void tcmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcmb1ActionPerformed
            // TODO add your handling code here:
            String id=(String) tcmb1.getSelectedItem();
            if(!id.endsWith("-Select-"))
            {
            tidlbl.setText((String) tcmb1.getSelectedItem());
            getamtdata();
            
            }
        }//GEN-LAST:event_tcmb1ActionPerformed
        public void clearTranstab()
        {

            try{
                t1=gct1.getText();
                t2=tidlbl.getText();
                int i=0,j=0;
                double x=0;
                CstAmt_mod gam = null;
                Silvertrs_mod stm=null;
                List lst=new LinkedList();
                lst=(List)ss.getgspTab("C2014","INV0");
                Object dat[][]=new Object[lst.size()+3][10];
                String col[]={"Slno","Item name","Date","Silver rate","Weight","Making Charge","Tax","Total"};
                Iterator itm=lst.iterator();
                while(itm.hasNext())
                {
                    stm=(Sales.model.Silvertrs_mod)itm.next();
                    dat[i][0]=(String)stm.getSlno();
                    dat[i][1]=(String)stm.getPurch_item();
                    dat[i][2]=(Date)stm.getT_date();
                    dat[i][3]=(Double)stm.getGoldrate();
                    dat[i][4]=(Double)stm.getWeight();
                    dat[i][5]=(Double)stm.getMak_chrg();
                    dat[i][6]=(Double)stm.getTax();
                    dat[i][7]=(Double)stm.getTotamt();
                    x=x+(Double)dat[i][7];
                    i++;
                }
                dat[i+1][6]="Net Amount";
                dat[i+1][7]=x;
                DefaultTableModel dm=new DefaultTableModel(dat,col);
                gstab.setModel(dm);
                gstab.setAutoResizeMode(gstab.AUTO_RESIZE_OFF);
                gstab.getColumnModel().getColumn(0).setPreferredWidth(30);
                gstab.getColumnModel().getColumn(1).setPreferredWidth(80);
                gstab.getColumnModel().getColumn(2).setPreferredWidth(80);
                gstab.getColumnModel().getColumn(3).setPreferredWidth(80);
                gstab.getColumnModel().getColumn(4).setPreferredWidth(50);
                gstab.getColumnModel().getColumn(5).setPreferredWidth(50);
                gstab.getColumnModel().getColumn(6).setPreferredWidth(100);
                gstab.getColumnModel().getColumn(7).setPreferredWidth(80);
            }catch(Exception e){JOptionPane.showMessageDialog(this, "No Data Found");}
        }

        public void getPamtdata()
        {
            
             
        try {
            t1=(String) goldcmb.getSelectedItem();
            t2=(String) tcmb2.getSelectedItem();
            CstAmt_mod gam = null;
            ss=new Silver_Service();
            gam=(CstAmt_mod)ss.getamt(t1,t2);
            netamtlbl.setText(String.valueOf(gam.getTot()));
            balamtlbl.setText(String.valueOf(gam.getBal()));
            Double t=Double.valueOf(netamtlbl.getText());
            Double b=Double.valueOf(balamtlbl.getText());
            Double p=t-b;
            gct24.setText(String.valueOf(p));
            printbtn.setEnabled(true);
            generatepaymentViews();
            getpids();
            
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data not found search another no"+e);
        }
    }
        public void getamtdata()
        {
             
        try {
            t1=(String) idcmb.getSelectedItem();
            t2=tidlbl.getText();
            CstAmt_mod gam = null;
            ss=new Silver_Service();
            gam=(CstAmt_mod)ss.getamt(t1,t2);
            System.out.println(t1+" "+t2);
            gct23.setText(String.valueOf(gam.getTot()));
            System.out.println(t1+" "+t2);
            gct25.setText(String.valueOf(gam.getBal()));
            Double t=Double.valueOf(gct23.getText());
            Double b=Double.valueOf(gct25.getText());
            Double p=t-b;
            gct24.setText(String.valueOf(p));
            printbtn.setEnabled(true);
            generateViews();
              savebill.setEnabled(true);
            printbtn.setEnabled(true);
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data not found search another no"+e);
        }
        }
        private void addnewb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewb1ActionPerformed
            // TODO add your handling code here:
            int n = JOptionPane.showConfirmDialog(this, "Would you like To Create New Transaction","",JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION)
            {
                getNextTId();
                creatTrans();
                gct17.setText("");
                gct18.setText("");
                gct20.setText("");
                gct22.setText("0.0");
                taxlbl.setText("");
                gct23.setText("0.0");
                gct24.setText("0.0");
                gct25.setText("0.0");
                tcmb1.setSelectedIndex(0);
                gct17.requestFocus();
                getTcount();
                savebill.setEnabled(true);
                 Delete.setEnabled(false);
                btnUpdateSil.setEnabled(false);
            } else if (n == JOptionPane.NO_OPTION){
            } else {}
        }//GEN-LAST:event_addnewb1ActionPerformed

        private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
            // TODO add your handling code here:
        Double pa=Double.valueOf(gct24.getText());
        if(pa==0.0)
        {
            getTcount();
            String lstsno=String.valueOf(l_sno);
            if(lstsno.equals(s_sno))
            {
                deletedata();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Sorry U cant Delete this record Plase Select Last record");
            }
        }else{JOptionPane.showMessageDialog(this,"Sorry U cant Delete This Transaction Payment Already Done");}
        }//GEN-LAST:event_DeleteActionPerformed

        private void photo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_photo1KeyPressed
            // TODO add your handling code here:

        }//GEN-LAST:event_photo1KeyPressed

        private void idcard1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idcard1KeyPressed
            // TODO add your handling code here
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                gct17.requestFocus(true);

            }
}//GEN-LAST:event_idcard1KeyPressed

        private void start2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start2ActionPerformed
            img2="";
            img2=gct1.getText().toString();
            img2="d:\\myImages\\V"+img2+".jpeg";
            OpenCVFrameGrabber grabber=new OpenCVFrameGrabber(0);
            try{
                grabber.start();
                IplImage img=grabber.grab();
                if(img!=null) {
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

        private void gct15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct15ActionPerformed
            // TODO add your handling code here:
            JOptionPane.showMessageDialog(this,"Please Select Smaller Image(100X100)!!!");
            JFileChooser jf=new JFileChooser();
            jf.showOpenDialog(this);
            try {
                File imagefile=jf.getSelectedFile();

                if(imagefile.getName().endsWith(".jpg")||imagefile.getName().endsWith(".png")||imagefile.getName().endsWith(".jpeg")||imagefile.getName().endsWith(".gif")) {

                    ImageIcon i= new ImageIcon(imagefile.getPath());
                    File imagefile1=jf.getSelectedFile();
                    BufferedImage myImage = ImageIO.read(imagefile1);
                    //idp1.setText("");
                    idc2.setIcon(new ImageIcon(myImage.getScaledInstance(108, 118, 100)));


                    idp2=imagefile.getAbsolutePath();
                    //idc2.setIcon(i);
                }

            } catch(Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
}//GEN-LAST:event_gct15ActionPerformed

        private void gct15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct15KeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                gct16.requestFocus(true);
            }
}//GEN-LAST:event_gct15KeyPressed

        private void photoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_photoKeyPressed

}//GEN-LAST:event_photoKeyPressed

        private void idcardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idcardKeyPressed
            // TODO add your handling code here:
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                gct9.requestFocus(true);

            }
}//GEN-LAST:event_idcardKeyPressed

        private void gct6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct6ActionPerformed
            img1="";
            img1=gct1.getText().toString();
            img1="d:\\myImages\\V"+img1+".jpeg";
            OpenCVFrameGrabber grabber=new OpenCVFrameGrabber(0);
            try{
                grabber.start();
                IplImage img=grabber.grab();
                if(img!=null) {
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
            int keycode=evt.getKeyCode();
            if(keycode==10) {
                gct7.requestFocus(true);
            }
}//GEN-LAST:event_gct6KeyPressed

        private void gct7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gct7ActionPerformed
            // TODO add your handling code here:
            JFileChooser jf=new JFileChooser();
            jf.showOpenDialog(this);
            try {
                File imagefile=jf.getSelectedFile();

                if(imagefile.getName().endsWith(".jpg")||imagefile.getName().endsWith(".png")||imagefile.getName().endsWith(".jpeg")||imagefile.getName().endsWith(".gif")) {

                    ImageIcon i= new ImageIcon(imagefile.getPath());

                    //File imagefile1=jf.getSelectedFile();
                    BufferedImage myImage = ImageIO.read(imagefile);
                    //idp1.setText("");
                    idc1.setIcon(new ImageIcon(myImage.getScaledInstance(108, 118, 100)));



                    idp1=imagefile.getAbsolutePath();
                    //idc1.setIcon(i);
                }

            } catch(Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
}//GEN-LAST:event_gct7ActionPerformed

        private void gct7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gct7KeyPressed

}//GEN-LAST:event_gct7KeyPressed

        private void ncmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncmb1ActionPerformed
            // TODO add your handling code here:
            viewbycname();
}//GEN-LAST:event_ncmb1ActionPerformed
    public void viewbycname()
        {
            t2=(String) ncmb1.getSelectedItem();
        try {

            Goldservices gs=new Goldservices();
            Goldcst_model gsm=(Goldcst_model)gs.viewbyName(t2);
            java.util.Date d= gsm.getTrans_date();
            goldcmb.setSelectedItem(gsm.getCid());
            System.out.println("  "+d);
            Nam=gsm.getCname();
            cnametxt.setText(gsm.getCname());
            java.util.Date di =new java.util.Date();
            String de=String.valueOf(d);
            di=Date.valueOf(de);
            String pd=String.valueOf(di);
            datelbl.setText(pd);
            comboPTIDs();

        } catch(Exception e) {JOptionPane.showMessageDialog(null, "data not found search another no"+e);}
        }
        private void ncmb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ncmb1KeyPressed
            // TODO add your handling code here:
            int kc=evt.getKeyCode();
            if(kc==10) {
                viewbycname();
            }
}//GEN-LAST:event_ncmb1KeyPressed

        private void ncmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ncmbActionPerformed
            // TODO add your handling code here:
            byname();
        }//GEN-LAST:event_ncmbActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
            comboTIDs();
            comboCustIDs();
            comboNames();
}//GEN-LAST:event_jButton1ActionPerformed

        private void ncmbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ncmbKeyPressed
            // TODO add your handling code here:
            int kc=evt.getKeyCode();
            if(kc==10)
            {
                byname();
            }
        }//GEN-LAST:event_ncmbKeyPressed

        private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
            // TODO add your handling code here:
            t1=gct1.getText(); //Customer id//
        t2=gct2.getText();//cust name//
        t3=Gct3.getText();//address//
        t4=Gct4.getText();//city//
        t5=gct5.getText();//phone no//
        t6=gct9.getText();//personal details//
        t7=Gct10.getText();//address//
        t8=gct11.getText();//city//
        t9=gct12.getText();//phone no.//
        java.sql.Date d=(Date) new java.sql.Date(gct16.getDate().getTime());
        boolean g=Validatefields();
        if(g) {
            System.out.println("validation success");
            boolean flag=false;
            Goldservices gs=new Goldservices();
            //t2=t2+" "+t1;
            flag=gs.goldsaleUpdate(t1,t2,t3,t4,t5,t6,t7,t8,t9,d,img1,img2,idp1,idp2);
            if(flag)
            {
                updatebtn.setEnabled(false);
                newbtn.setEnabled(true);
                JOptionPane.showMessageDialog(this, "Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(this,"Failed To Update");
            }
        }
        }//GEN-LAST:event_updatebtnActionPerformed

        private void updatebtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updatebtnKeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_updatebtnKeyPressed
        Double lsttot;
        private void btnUpdateSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSilActionPerformed
        //getTcount();
        t11=gct17.getText();//purchase//
        t12=gct21.getText();//gold rate//
        t13=gct18.getText();//weight//
        t15=gct20.getText();//making charge//
        t16=taxlbl.getText();//tax
        t17=gct22.getText();//total payment//
        tt12=Double.valueOf(t12);
        tt17=Double.valueOf(t17);
        b1=gct1.getText();
        trnd=tidlbl.getText();
        boolean b=billvalid();
        if(b) {
            java.sql.Date d=new java.sql.Date(gct16.getDate().getTime());
            java.sql.Date rtd= new java.sql.Date(jDateChooser2.getDate().getTime());
            tt16=tax;
            boolean flag=false;
            Double tot=lstnt;
            Double bal=lstnb;
            Double st=tot-lsttot;
            Double sb=bal-lsttot;
            gct23.setText(String.valueOf(st));
            gct25.setText(String.valueOf(sb));
            ss=new Silver_Service();
            slno=txtslno.getText();
            flag=ss.billUpdate(b1,trnd,slno,d,t11,tt12,tt13,tt15,tax,tt17,wt,rtd);
            if(flag) {
                t1=gct1.getText();
                 Delete.setEnabled(false);
                btnUpdateSil.setEnabled(false);
                Double n1tot=Double.valueOf(gct23.getText());
                Double n1bal=Double.valueOf(gct25.getText());
                Double sna=Double.valueOf(gct22.getText());
                Double snt=n1tot+sna;
                Double snb=n1bal+sna;
                gct23.setText(String.valueOf(snt));
                gct25.setText(String.valueOf(snb));
                updatecust();
                generateViews();
                printbtn.setEnabled(true);
                savebill.setEnabled(false);
                addnewb.doClick();
            } else {
                JOptionPane.showMessageDialog(this,"Sorry bill data not saved");
            }
        }
        }//GEN-LAST:event_btnUpdateSilActionPerformed
        public void comboNames()
    {
        try
        {
        int i=0;
        List lst=null;
        
        Goldservices gs=new Goldservices();
        lst=(List)gs.getNames();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        ncmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
        ncmb.setMaximumRowCount(6);
        ncmb.setFocusable(true);
        ncmb1.setModel(new javax.swing.DefaultComboBoxModel(cods));
        ncmb1.setMaximumRowCount(6);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
        public void deletedata()
        {
            Double lstamt =Double.valueOf(gct22.getText());
            boolean flag =false;
            String d1,d2,d3;
            d1=gct1.getText();
            d2=tidlbl.getText();
            d3=slno;
            ss=new Silver_Service();
            flag =ss.TransDel(d1,d2,d3);
            if(flag)
            {
                Double t=Double.valueOf(gct23.getText());
                Double nt =t-lstamt;
                gct23.setText(String.valueOf(nt));
                Double b=Double.valueOf(gct25.getText());
                Double nb =b-lstamt;
                gct25.setText(String.valueOf(nb));
                Double ntot=Double.valueOf(gct23.getText());
                Double nbal=Double.valueOf(gct25.getText());
                Double np=ntot-nbal;
                gct24.setText(String.valueOf(np));
                JOptionPane.showMessageDialog(this, "Item Deleted Successfully");
                updatecust();
                Delete.setEnabled(false);
                btnUpdateSil.setEnabled(false);
                generateViews();
            }
        }




        Double pp3,pp4,pp6;
        int p5;
      
        String p1,p3,p4,p6;
        private boolean validatepay()        
        {
            p1=(String) goldcmb.getSelectedItem();
            p6=paytxt.getText();
            if(goldcmb.getSelectedIndex()==0){JOptionPane.showMessageDialog(this,"please select the id first");return false;}
            if(tcmb2.getSelectedIndex()==0){JOptionPane.showMessageDialog(this,"please select the Transaction ID");return false;}
            if(p6.length()==0){JOptionPane.showMessageDialog(this,"please enter payment amount");return false;}
            try{pp6=Double.valueOf(p6);}catch(Exception e){JOptionPane.showMessageDialog(this,"enter no in the payment field");return false;}
            return true;
        }
        private boolean validprint()
        {
            if(gct1.getText()=="-------"){JOptionPane.showMessageDialog(this, "please select customer id");return false;}
            if(gct16.getDate()==null){JOptionPane.showMessageDialog(this, "please select Date");return false;}
            return true;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JDesktopPane Desktop1;
    private javax.swing.JTextArea Gct10;
    private javax.swing.JTextArea Gct3;
    private javax.swing.JTextField Gct4;
    private javax.swing.JButton addnewb;
    private javax.swing.JButton addnewb1;
    private javax.swing.JLabel balamtlbl;
    private javax.swing.JButton btnUpdateSil;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton closebtn1;
    private javax.swing.JTextField cnametxt;
    private javax.swing.JLabel datelbl;
    private javax.swing.JLabel gct1;
    private javax.swing.JScrollPane gct10;
    private javax.swing.JTextField gct11;
    private javax.swing.JTextField gct12;
    private javax.swing.JButton gct15;
    private com.toedter.calendar.JDateChooser gct16;
    private javax.swing.JTextField gct17;
    private javax.swing.JTextField gct18;
    private javax.swing.JTextField gct2;
    private javax.swing.JTextField gct20;
    private javax.swing.JTextField gct21;
    private javax.swing.JLabel gct22;
    private javax.swing.JLabel gct23;
    private javax.swing.JLabel gct24;
    private javax.swing.JLabel gct25;
    private javax.swing.JScrollPane gct3;
    private javax.swing.JTextField gct5;
    private javax.swing.JButton gct6;
    private javax.swing.JButton gct7;
    private javax.swing.JTextField gct9;
    private javax.swing.JComboBox goldcmb;
    private javax.swing.JTable gstab;
    private javax.swing.JLabel idc1;
    private javax.swing.JLabel idc2;
    private javax.swing.JPanel idcard;
    private javax.swing.JPanel idcard1;
    private javax.swing.JComboBox idcmb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox ncmb;
    private javax.swing.JComboBox ncmb1;
    private javax.swing.JLabel netamtlbl;
    private javax.swing.JButton newbtn;
    private javax.swing.JButton padd;
    private javax.swing.JTable paytab;
    private javax.swing.JTextField paytxt;
    private javax.swing.JPanel photo;
    private javax.swing.JPanel photo1;
    private javax.swing.JLabel pid;
    private javax.swing.JButton printbtn;
    private javax.swing.JButton psave;
    private com.toedter.calendar.JDateChooser pydate;
    private javax.swing.JLabel rmbalamtlbl;
    private javax.swing.JButton savebill;
    private javax.swing.JButton savebtn;
    private javax.swing.JLabel shot;
    private javax.swing.JLabel shot2;
    private javax.swing.JButton start2;
    private javax.swing.JTabbedPane tabcust;
    private javax.swing.JTextField taxlbl;
    private javax.swing.JComboBox tcmb1;
    private javax.swing.JComboBox tcmb2;
    private javax.swing.JTextField tidlbl;
    private javax.swing.JTextField txtslno;
    private javax.swing.JButton updatebtn;
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
