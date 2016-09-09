package Forms;
import APMCMain.GETOC;
import Forms.Models.CstModel;
import Forms.Models.CstPrdSellModel;
import Forms.Models.PayModel;
import Forms.Models.PrdActModel;
import Forms.Models.PrdInvModel;
import Forms.Models.PrdModel;
import Forms.Models.TrnPayModel;
import Forms.Services.CustomerSrvs;
import Forms.Services.MasterSrvs;
import Forms.Services.PrdWiseSrvs;
import Forms.Services.TranSrvs;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
public class ProductWise extends javax.swing.JInternalFrame {
    TableRowSorter<TableModel> rowsort;
    public ProductWise() {
        super("ಉತ್ಪಾದನ ಪಾವತಿ",false,true,false,true);
        initComponents();
        getTableDATA();
        disableall();
        comboAllCodes();
        MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Arial Unicode MS",Font.BOLD,16));
        sdat.setDate(new java.util.Date());
        asdat.setDate(new java.util.Date());
        mdat.setDate(new java.util.Date());
        pdat.setDate(new java.util.Date());
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));this.updateUI();
        //-------------------------Seacrh Table String From Text Field------------------------------------------
        rowsort=new TableRowSorter<TableModel>(csttab.getModel());
        csttab.setRowSorter(rowsort);
        cntxt.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                String text = cntxt.getText();
                if (text.trim().length() == 0)
                {rowsort.setRowFilter(null);}
                else
                {rowsort.setRowFilter(RowFilter.regexFilter("(?i)" + text));}
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                String text = cntxt.getText();
                if (text.trim().length() == 0)
                {rowsort.setRowFilter(null);}
                else
                {rowsort.setRowFilter(RowFilter.regexFilter("(?i)" + text));}
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {throw new UnsupportedOperationException("Not supported yet.");} //To change body of generated methods, choose Tools | Templates.
        });
        pupdt.setEnabled(false);
    }
    String cid;
    //-----------------Variables----------------------------
    //-------Product Stock--------------------------
    String p1,p2,p3,p4,p5;
    //-------Product Action--------------------------
    String a1,a2,a3,a4,a5,a6,a7,asts;
    Double aa4,aa6,aa7;
    java.sql.Date aed=null;
    java.sql.Date asd=null;
    //----------Product Selling----------------
    Double mm1,mm2,mm3;

   //-------------Payment--------------------
    String t1,t2,t3,t5;
    Double tt4,tt6,tt7,tt8,tt9,tt10;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        csttab = new javax.swing.JTable();
        cntxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tabpan = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        st2 = new javax.swing.JComboBox();
        st1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        st3 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        st4 = new javax.swing.JTextField();
        sdat = new com.toedter.calendar.JDateChooser();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        st5 = new javax.swing.JComboBox();
        lbl1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        sadd = new javax.swing.JButton();
        ssave = new javax.swing.JButton();
        supdate = new javax.swing.JButton();
        sclr = new javax.swing.JButton();
        codcmb = new javax.swing.JComboBox();
        lbl3 = new javax.swing.JLabel();
        cidlbl = new javax.swing.JLabel();
        lbl28 = new javax.swing.JLabel();
        codcmb1 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        lbl9 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        asdat = new com.toedter.calendar.JDateChooser();
        lbl14 = new javax.swing.JLabel();
        at4 = new javax.swing.JTextField();
        lbl15 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        aedat = new com.toedter.calendar.JDateChooser();
        at5 = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        aadd = new javax.swing.JButton();
        asave = new javax.swing.JButton();
        aclr = new javax.swing.JButton();
        lbl17 = new javax.swing.JLabel();
        at6 = new javax.swing.JTextField();
        lbl19 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        at7 = new javax.swing.JTextField();
        lbl20 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        at3 = new javax.swing.JLabel();
        at1 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        at2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        msave = new javax.swing.JButton();
        mpbtn = new javax.swing.JButton();
        lbl21 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        mdat = new com.toedter.calendar.JDateChooser();
        lbl23 = new javax.swing.JLabel();
        mt1 = new javax.swing.JLabel();
        lbl26 = new javax.swing.JLabel();
        lbl24 = new javax.swing.JLabel();
        mt2 = new javax.swing.JLabel();
        lbl27 = new javax.swing.JLabel();
        lbl25 = new javax.swing.JLabel();
        mt3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trntab = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        pt3 = new javax.swing.JComboBox();
        l5 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        pt4 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        pt5 = new javax.swing.JLabel();
        pt6 = new javax.swing.JLabel();
        l10 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        pt7 = new javax.swing.JComboBox();
        pt8 = new javax.swing.JLabel();
        l12 = new javax.swing.JLabel();
        l13 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        pt1 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l15 = new javax.swing.JLabel();
        pt9 = new javax.swing.JLabel();
        l14 = new javax.swing.JLabel();
        pt10 = new javax.swing.JLabel();
        l17 = new javax.swing.JLabel();
        l16 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        pdat = new com.toedter.calendar.JDateChooser();
        pclr = new javax.swing.JButton();
        pupdt = new javax.swing.JButton();
        psave = new javax.swing.JButton();
        pt2 = new javax.swing.JComboBox();
        pidcmb = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        dpan = new javax.swing.JDesktopPane();

        setBackground(new java.awt.Color(59, 0, 59));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sanlogo.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        csttab.setBackground(new java.awt.Color(0, 0, 0));
        csttab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        csttab.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        csttab.setForeground(new java.awt.Color(0, 255, 0));
        csttab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ));
        csttab.setGridColor(new java.awt.Color(51, 255, 0));
        csttab.setOpaque(false);
        csttab.setRowHeight(20);
        csttab.setSelectionBackground(new java.awt.Color(51, 255, 0));
        csttab.setSelectionForeground(new java.awt.Color(0, 0, 0));
        csttab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                csttabMouseClicked(evt);
            }
        });
        csttab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csttabKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(csttab);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(12, 88, 204, 410);

        cntxt.setBackground(new java.awt.Color(51, 255, 0));
        cntxt.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        cntxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        cntxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cntxtKeyPressed(evt);
            }
        });
        jPanel2.add(cntxt);
        cntxt.setBounds(12, 41, 204, 29);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("Type Text Here To Search :-");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(12, 13, 204, 17);

        tabpan.setFont(new java.awt.Font("Kedage", 1, 19));

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

        st2.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        st2.setOpaque(false);
        st2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                st2ActionPerformed(evt);
            }
        });
        st2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                st2KeyPressed(evt);
            }
        });

        st1.setBackground(new java.awt.Color(51, 255, 0));
        st1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        st1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st1.setOpaque(true);

        lbl2.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl2.setForeground(new java.awt.Color(51, 255, 51));
        lbl2.setText("ಕ್ರಂ ಸಂಖ್ಯೆ :");

        lbl4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl4.setForeground(new java.awt.Color(51, 255, 51));
        lbl4.setText("CODE :");

        lbl5.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl5.setForeground(new java.awt.Color(51, 255, 51));
        lbl5.setText("    ಉತ್ಪನ್ನ :");

        st3.setBackground(new java.awt.Color(51, 255, 0));
        st3.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
        st3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        st3.setOpaque(true);

        lbl6.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl6.setForeground(new java.awt.Color(51, 255, 51));
        lbl6.setText("ಚಿಲಗಳು :");

        st4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        st4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        st4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                st4KeyPressed(evt);
            }
        });

        lbl7.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl7.setForeground(new java.awt.Color(51, 255, 51));
        lbl7.setText(" ದಿನಾಂಕ :");

        lbl8.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl8.setForeground(new java.awt.Color(51, 255, 51));
        lbl8.setText("ಗುಣಮಟ್ಟ :");

        st5.setBackground(new java.awt.Color(215, 215, 162));
        st5.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        st5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-", "Poor", "Average", "Good", "Super Fine" }));
        st5.setOpaque(false);
        st5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                st5KeyPressed(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl1.setForeground(new java.awt.Color(255, 236, 24));
        lbl1.setText("ಷೆರು ಉತ್ಪನ್ನ");

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setOpaque(false);

        sadd.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        sadd.setText("ADD");
        sadd.setOpaque(false);
        sadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saddActionPerformed(evt);
            }
        });

        ssave.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        ssave.setText("SAVE");
        ssave.setOpaque(false);
        ssave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssaveActionPerformed(evt);
            }
        });
        ssave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ssaveKeyPressed(evt);
            }
        });

        supdate.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        supdate.setText("UPDATE");
        supdate.setOpaque(false);
        supdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supdateActionPerformed(evt);
            }
        });

        sclr.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        sclr.setText("CLEAR");
        sclr.setOpaque(false);
        sclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sclrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sadd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ssave, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sclr)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sadd)
                    .addComponent(sclr)
                    .addComponent(supdate)
                    .addComponent(ssave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        codcmb.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        codcmb.setOpaque(false);
        codcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codcmbActionPerformed(evt);
            }
        });

        lbl3.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl3.setForeground(new java.awt.Color(51, 255, 51));
        lbl3.setText("  CODE :");

        cidlbl.setBackground(new java.awt.Color(51, 255, 0));
        cidlbl.setFont(new java.awt.Font("Times New Roman", 1, 14));
        cidlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cidlbl.setOpaque(true);

        lbl28.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl28.setForeground(new java.awt.Color(51, 255, 51));
        lbl28.setText("Closed :");

        codcmb1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        codcmb1.setOpaque(false);
        codcmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codcmb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl6)
                            .addComponent(lbl2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl5)
                                .addComponent(lbl7)
                                .addComponent(lbl4)
                                .addComponent(lbl8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(st1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codcmb, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(st2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sdat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(st5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cidlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(lbl28, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codcmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl28)
                                .addComponent(codcmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cidlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(st1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl4)
                            .addComponent(st2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl3)
                        .addComponent(codcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl5)
                    .addComponent(st3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(st4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        lbl9.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl9.setForeground(new java.awt.Color(255, 236, 24));
        lbl9.setText("ಉತ್ಪನ್ನ ಹರಾಜು ");
        jPanel4.add(lbl9);
        lbl9.setBounds(12, 13, 105, 24);

        lbl13.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl13.setForeground(new java.awt.Color(51, 255, 51));
        lbl13.setText("ಹರಾಜು ದಿನಾಂಕ :");
        jPanel4.add(lbl13);
        lbl13.setBounds(98, 82, 103, 24);

        asdat.setDateFormatString("dd/MM/yyyy");
        asdat.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel4.add(asdat);
        asdat.setBounds(208, 86, 119, 20);

        lbl14.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl14.setForeground(new java.awt.Color(51, 255, 51));
        lbl14.setText("ಹರಾಜು ಹಣ :");
        jPanel4.add(lbl14);
        lbl14.setBounds(124, 113, 83, 24);

        at4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        at4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        at4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                at4KeyPressed(evt);
            }
        });
        jPanel4.add(at4);
        at4.setBounds(208, 112, 58, 21);

        lbl15.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl15.setForeground(new java.awt.Color(51, 255, 51));
        lbl15.setText("ಹರಾಜು ಸ್ಥಿತಿ :");
        jPanel4.add(lbl15);
        lbl15.setBounds(124, 143, 80, 24);

        lbl16.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl16.setForeground(new java.awt.Color(51, 255, 51));
        lbl16.setText("ಹರಾಜು ಮುಕ್ತಾಯ ದಿನಾಂಕ :");
        jPanel4.add(lbl16);
        lbl16.setBounds(39, 178, 165, 24);

        aedat.setDateFormatString("dd/MM/yyyy");
        aedat.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel4.add(aedat);
        aedat.setBounds(208, 178, 119, 20);

        at5.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        at5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-", "In Progress", "Cancelled", "Completed" }));
        at5.setOpaque(false);
        at5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                at5KeyPressed(evt);
            }
        });
        jPanel4.add(at5);
        at5.setBounds(208, 144, 89, 23);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setOpaque(false);

        aadd.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        aadd.setText("ADD");
        aadd.setOpaque(false);
        aadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaddActionPerformed(evt);
            }
        });

        asave.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        asave.setText("SAVE");
        asave.setOpaque(false);
        asave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asaveActionPerformed(evt);
            }
        });
        asave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                asaveKeyPressed(evt);
            }
        });

        aclr.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        aclr.setText("CLEAR");
        aclr.setOpaque(false);
        aclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aadd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(asave, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(aclr)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aadd)
                    .addComponent(aclr)
                    .addComponent(asave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(12, 275, 337, 40);

        lbl17.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl17.setForeground(new java.awt.Color(51, 255, 51));
        lbl17.setText("ಉತ್ಪನ್ನದ ಒಟ್ಟುತೂಕ :");
        jPanel4.add(lbl17);
        lbl17.setBounds(76, 209, 127, 24);

        at6.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        at6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        at6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                at6KeyPressed(evt);
            }
        });
        jPanel4.add(at6);
        at6.setBounds(208, 208, 58, 21);

        lbl19.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl19.setForeground(new java.awt.Color(51, 255, 51));
        lbl19.setText("Kg/-");
        jPanel4.add(lbl19);
        lbl19.setBounds(276, 210, 34, 17);

        lbl18.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl18.setForeground(new java.awt.Color(51, 255, 51));
        lbl18.setText("1 ಕ್ವಿಂಟಲ್‍ನ ರೂ :");
        jPanel4.add(lbl18);
        lbl18.setBounds(100, 245, 108, 24);

        at7.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        at7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        at7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                at7KeyPressed(evt);
            }
        });
        jPanel4.add(at7);
        at7.setBounds(208, 244, 58, 21);

        lbl20.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl20.setForeground(new java.awt.Color(51, 255, 51));
        lbl20.setText("Rs/-");
        jPanel4.add(lbl20);
        lbl20.setBounds(276, 246, 33, 17);

        lbl11.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl11.setForeground(new java.awt.Color(51, 255, 51));
        lbl11.setText("ಕ್ರಂ ಸಂಖ್ಯೆ:");
        jPanel4.add(lbl11);
        lbl11.setBounds(12, 52, 63, 22);

        at3.setBackground(new java.awt.Color(51, 255, 0));
        at3.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
        at3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        at3.setOpaque(true);
        jPanel4.add(at3);
        at3.setBounds(208, 50, 141, 26);

        at1.setBackground(new java.awt.Color(51, 255, 0));
        at1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        at1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        at1.setOpaque(true);
        jPanel4.add(at1);
        at1.setBounds(210, 10, 50, 26);

        lbl12.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl12.setForeground(new java.awt.Color(51, 255, 51));
        lbl12.setText("    ಉತ್ಪನ್ನ :");
        jPanel4.add(lbl12);
        lbl12.setBounds(134, 50, 71, 20);

        lbl10.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl10.setForeground(new java.awt.Color(51, 255, 51));
        lbl10.setText("ಹರಾಜು ನಂ :");
        jPanel4.add(lbl10);
        lbl10.setBounds(130, 12, 77, 20);

        at2.setBackground(new java.awt.Color(51, 255, 0));
        at2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        at2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        at2.setOpaque(true);
        jPanel4.add(at2);
        at2.setBounds(82, 52, 44, 21);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setOpaque(false);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setOpaque(false);

        msave.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        msave.setText("SAVE");
        msave.setOpaque(false);
        msave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msaveActionPerformed(evt);
            }
        });

        mpbtn.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        mpbtn.setText("MAKE PAYMENT");
        mpbtn.setOpaque(false);
        mpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mpbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(msave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(msave, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mpbtn)
                .addContainerGap())
        );

        lbl21.setFont(new java.awt.Font("Kedage", 1, 18));
        lbl21.setForeground(new java.awt.Color(255, 236, 24));
        lbl21.setText("ಉತ್ಪನ್ನ ಮಾರಾಟ");

        lbl22.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl22.setForeground(new java.awt.Color(51, 255, 51));
        lbl22.setText("ಮಾರಾಟ ದಿನಾಂಕ :");

        mdat.setDateFormatString("dd/MM/yyyy");
        mdat.setFont(new java.awt.Font("Times New Roman", 1, 14));

        lbl23.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl23.setForeground(new java.awt.Color(51, 255, 51));
        lbl23.setText("ಉತ್ಪನ್ನದ ಒಟ್ಟುತೂಕ :");

        mt1.setBackground(new java.awt.Color(51, 255, 0));
        mt1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        mt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mt1.setOpaque(true);

        lbl26.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl26.setForeground(new java.awt.Color(51, 255, 51));
        lbl26.setText("Kg/-");

        lbl24.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl24.setForeground(new java.awt.Color(51, 255, 51));
        lbl24.setText("1 ಕ್ವಿಂಟಲ್‍ನ ರೂ :");

        mt2.setBackground(new java.awt.Color(51, 255, 0));
        mt2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        mt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mt2.setOpaque(true);

        lbl27.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        lbl27.setForeground(new java.awt.Color(51, 255, 51));
        lbl27.setText("Rs/-");

        lbl25.setFont(new java.awt.Font("Kedage", 1, 16));
        lbl25.setForeground(new java.awt.Color(51, 255, 51));
        lbl25.setText("ಒಟ್ಟು ಮೊತ್ತ :");

        mt3.setBackground(new java.awt.Color(51, 255, 0));
        mt3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        mt3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mt3.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mdat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl21, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl23)
                        .addGap(8, 8, 8)
                        .addComponent(mt1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl26)))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbl25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mt3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mt2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl22, 0, 0, Short.MAX_VALUE)
                            .addComponent(mt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl24, 0, 0, Short.MAX_VALUE)
                            .addComponent(mdat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mt1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl23, 0, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, 0, 326, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabpan.addTab("ಉತ್ಪನ್ನ ಹರಾಜು / ಮಾರಟ", jPanel1);

        jPanel5.setBackground(new java.awt.Color(51, 0, 51));

        trntab.setBackground(new java.awt.Color(0, 0, 0));
        trntab.setFont(new java.awt.Font("Tunga", 1, 18));
        trntab.setForeground(new java.awt.Color(51, 255, 0));
        trntab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        trntab.setGridColor(new java.awt.Color(51, 255, 0));
        trntab.setSelectionBackground(new java.awt.Color(51, 255, 0));
        trntab.setSelectionForeground(new java.awt.Color(0, 0, 0));
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

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(null);

        pt3.setFont(new java.awt.Font("Arial Unicode MS", 1, 16));
        pt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pt3ActionPerformed(evt);
            }
        });
        pt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pt3KeyPressed(evt);
            }
        });
        jPanel10.add(pt3);
        pt3.setBounds(180, 100, 160, 20);

        l5.setFont(new java.awt.Font("Sampige", 1, 18));
        l5.setForeground(new java.awt.Color(51, 255, 51));
        l5.setText("ಉತ್ಪನ್ನ :");
        jPanel10.add(l5);
        l5.setBounds(120, 100, 55, 20);

        l2.setFont(new java.awt.Font("Tunga", 1, 18));
        l2.setForeground(new java.awt.Color(255, 236, 24));
        l2.setText("ಪಾವತಿ ವಿವರ");
        jPanel10.add(l2);
        l2.setBounds(16, 21, 88, 23);

        l6.setFont(new java.awt.Font("Sampige", 1, 18));
        l6.setForeground(new java.awt.Color(51, 255, 51));
        l6.setText(" ಉತ್ಪನ್ನದ ಮೊತ್ತ :");
        jPanel10.add(l6);
        l6.setBounds(70, 130, 110, 22);

        pt4.setBackground(new java.awt.Color(0, 255, 0));
        pt4.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt4.setOpaque(true);
        jPanel10.add(pt4);
        pt4.setBounds(180, 130, 100, 30);

        l9.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l9.setForeground(new java.awt.Color(51, 255, 0));
        l9.setText("Rs/-");
        jPanel10.add(l9);
        l9.setBounds(290, 130, 31, 30);

        l8.setFont(new java.awt.Font("Sampige", 1, 18));
        l8.setForeground(new java.awt.Color(51, 255, 51));
        l8.setText("   ವ್ಯವಹಾರಿಕ ಸಾಲದ ಮೊತ್ತ :");
        jPanel10.add(l8);
        l8.setBounds(10, 210, 170, 22);

        l7.setFont(new java.awt.Font("Sampige", 1, 18));
        l7.setForeground(new java.awt.Color(51, 255, 51));
        l7.setText("   ವ್ಯವಹಾರಿಕ ಸಂಖ್ಯೆ :");
        jPanel10.add(l7);
        l7.setBounds(50, 170, 130, 30);

        pt5.setBackground(new java.awt.Color(0, 255, 0));
        pt5.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt5.setOpaque(true);
        jPanel10.add(pt5);
        pt5.setBounds(180, 170, 50, 30);

        pt6.setBackground(new java.awt.Color(0, 255, 0));
        pt6.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt6.setOpaque(true);
        jPanel10.add(pt6);
        pt6.setBounds(180, 210, 100, 30);

        l10.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l10.setForeground(new java.awt.Color(51, 255, 0));
        l10.setText("Rs/-");
        jPanel10.add(l10);
        l10.setBounds(280, 210, 31, 30);

        l11.setFont(new java.awt.Font("Sampige", 1, 18));
        l11.setForeground(new java.awt.Color(51, 255, 51));
        l11.setText("  ಬಡ್ಡಿ ಶೆಕಡ :");
        jPanel10.add(l11);
        l11.setBounds(100, 250, 80, 24);

        pt7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        pt7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Select-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        pt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pt7ActionPerformed(evt);
            }
        });
        jPanel10.add(pt7);
        pt7.setBounds(180, 250, 90, 20);

        pt8.setBackground(new java.awt.Color(0, 255, 0));
        pt8.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt8.setOpaque(true);
        jPanel10.add(pt8);
        pt8.setBounds(180, 280, 90, 30);

        l12.setFont(new java.awt.Font("Sampige", 1, 18));
        l12.setForeground(new java.awt.Color(51, 255, 51));
        l12.setText("  ಕೊಟ್ಟ ಹಣಕ್ಕೆ ಬಡ್ಡಿಸೆರಿಸಿ :");
        jPanel10.add(l12);
        l12.setBounds(30, 280, 150, 22);

        l13.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l13.setForeground(new java.awt.Color(51, 255, 0));
        l13.setText("Rs/-");
        jPanel10.add(l13);
        l13.setBounds(280, 280, 31, 30);

        l4.setFont(new java.awt.Font("Sampige", 1, 18));
        l4.setForeground(new java.awt.Color(51, 255, 51));
        l4.setText("ಮಾರಾಟ  ದಿನಾಂಕ :");
        jPanel10.add(l4);
        l4.setBounds(60, 70, 120, 20);

        pt1.setBackground(new java.awt.Color(0, 255, 0));
        pt1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt1.setOpaque(true);
        jPanel10.add(pt1);
        pt1.setBounds(180, 10, 38, 20);

        l1.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l1.setForeground(new java.awt.Color(51, 255, 0));
        l1.setText(" PayID :");
        jPanel10.add(l1);
        l1.setBounds(120, 10, 60, 17);

        l15.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l15.setForeground(new java.awt.Color(51, 255, 0));
        l15.setText("Rs/-");
        jPanel10.add(l15);
        l15.setBounds(280, 320, 31, 30);

        pt9.setBackground(new java.awt.Color(0, 255, 0));
        pt9.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt9.setOpaque(true);
        jPanel10.add(pt9);
        pt9.setBounds(180, 320, 92, 30);

        l14.setFont(new java.awt.Font("Sampige", 1, 18));
        l14.setForeground(new java.awt.Color(51, 255, 51));
        l14.setText("ಬಾಕಿ ಮೊತ್ತ :");
        jPanel10.add(l14);
        l14.setBounds(100, 320, 80, 22);

        pt10.setBackground(new java.awt.Color(0, 255, 0));
        pt10.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pt10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pt10.setOpaque(true);
        jPanel10.add(pt10);
        pt10.setBounds(180, 360, 92, 30);

        l17.setFont(new java.awt.Font("Lucida Fax", 1, 14));
        l17.setForeground(new java.awt.Color(51, 255, 0));
        l17.setText("Rs/-");
        jPanel10.add(l17);
        l17.setBounds(280, 360, 31, 30);

        l16.setFont(new java.awt.Font("Sampige", 1, 18));
        l16.setForeground(new java.awt.Color(51, 255, 51));
        l16.setText("ವಿತರಿಸಬೆಕಾದ ಮೊತ್ತ :");
        jPanel10.add(l16);
        l16.setBounds(50, 360, 130, 30);

        l3.setFont(new java.awt.Font("Sampige", 1, 18));
        l3.setForeground(new java.awt.Color(51, 255, 51));
        l3.setText("  ದಿನಾಂಕ :");
        jPanel10.add(l3);
        l3.setBounds(110, 40, 70, 20);

        pdat.setDateFormatString("dd/MM/yyyy");
        pdat.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jPanel10.add(pdat);
        pdat.setBounds(180, 40, 130, 20);

        pclr.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        pclr.setText("CLEAR");
        pclr.setOpaque(false);
        pclr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pclrActionPerformed(evt);
            }
        });
        jPanel10.add(pclr);
        pclr.setBounds(270, 400, 71, 23);

        pupdt.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        pupdt.setText("UPDATE");
        pupdt.setOpaque(false);
        pupdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupdtActionPerformed(evt);
            }
        });
        jPanel10.add(pupdt);
        pupdt.setBounds(140, 400, 79, 23);

        psave.setFont(new java.awt.Font("Lucida Fax", 1, 11));
        psave.setText("SAVE");
        psave.setOpaque(false);
        psave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psaveActionPerformed(evt);
            }
        });
        jPanel10.add(psave);
        psave.setBounds(20, 400, 74, 23);

        pt2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        pt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pt2ActionPerformed(evt);
            }
        });
        pt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pt2KeyPressed(evt);
            }
        });
        jPanel10.add(pt2);
        pt2.setBounds(180, 70, 130, 23);

        pidcmb.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        pidcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidcmbActionPerformed(evt);
            }
        });
        jPanel10.add(pidcmb);
        pidcmb.setBounds(240, 10, 60, 20);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabpan.addTab("ಪಾವತಿ", jPanel5);

        jPanel13.setBackground(new java.awt.Color(51, 0, 51));

        dpan.setBackground(new java.awt.Color(74, 2, 74));
        dpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpan, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpan, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpan.addTab("ರಸಿದಿ", jPanel13);

        jPanel2.add(tabpan);
        tabpan.setBounds(222, 2, 760, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void csttabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csttabMouseClicked
        // TODO add your handling code here:
        try
        {
            int ro=csttab.getSelectedRow();
            cid=csttab.getModel().getValueAt(ro,0).toString();
            cidlbl.setText(cid);
            enableprd();
            comboCodes(cid);
            nxtPrdslno();
            nxtAcId();
            getTRNTable(cid);
            comboPrds(cid);
            comboDates(cid);
            comboCCodes(cid);
        }catch(Exception e){}
}//GEN-LAST:event_csttabMouseClicked

    private void csttabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csttabKeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10)
        {
            int ro=csttab.getSelectedRow();
            cid=csttab.getModel().getValueAt(ro,0).toString();
            cidlbl.setText(cid);
            enableprd();
            comboCodes(cid);
            nxtPrdslno();
            nxtAcId();
            getTRNTable(cid);
            comboPrds(cid);
            comboDates(cid);
            comboCCodes(cid);
        }
}//GEN-LAST:event_csttabKeyPressed

    public void comboCodes(String cid)
    {
        try
        {
            int i=0;
            List lst=null;
            PrdWiseSrvs prdws = new PrdWiseSrvs();
            String sts="Opened";
            lst=(List)prdws.getIcodes(cid, sts);
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            codcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
            codcmb.setMaximumRowCount(6);
            codcmb.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");}
    }
    public void comboCCodes(String cid)
    {
        try
        {
            int i=0;
            List lst=null;
            PrdWiseSrvs prdws = new PrdWiseSrvs();
            String sts="Closed";
            lst=(List)prdws.getIcodes(cid, sts);
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            codcmb1.setModel(new javax.swing.DefaultComboBoxModel(cods));
            codcmb1.setMaximumRowCount(6);
            codcmb1.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");}
    }
    public void comboPrds(String cid)
    {
        try
        {
            int i=0;
            List lst=null;
            PrdWiseSrvs prdws = new PrdWiseSrvs();
            lst=(List)prdws.getPRDcmb(cid);
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            pt3.setModel(new javax.swing.DefaultComboBoxModel(cods));
            pt3.setMaximumRowCount(6);
            pt3.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again"+e);}
    }
    public void comboPIDs(String cid,String tid)
    {
        try
        {
            int i=0;
            List lst=null;
            PrdWiseSrvs prdws = new PrdWiseSrvs();
            lst=(List)prdws.getPIDcmb(cid,tid);
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            pidcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
            pidcmb.setMaximumRowCount(6);
            pidcmb.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again"+e);}
    }
    public void comboDates(String cid)
    {
        try
        {
            int i=0;
            List lst=null;
            PrdWiseSrvs prdws = new PrdWiseSrvs();
            lst=(List)prdws.getDATEcmb(cid);
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            pt2.setModel(new javax.swing.DefaultComboBoxModel(cods));
            pt2.setMaximumRowCount(6);
            pt2.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again"+e);}
    }
    public void comboAllCodes()
    {
        try
        {
            int i=0;
            List lst=null;
            MasterSrvs msrv = new MasterSrvs();
            lst=(List)msrv.getItmcod();
            String cods[]=new String[lst.size()];
            Iterator itm1=lst.iterator();
            while(itm1.hasNext())
            {
                cods[i]=(String)itm1.next();
                i++;
            }
            st2.setModel(new javax.swing.DefaultComboBoxModel(cods));
            st2.setMaximumRowCount(6);
            st2.setFocusable(true);
        }catch(Exception e){JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");}
    }
    public void nxtPrdslno()
    {
        PrdWiseSrvs pwsr=new PrdWiseSrvs();
        List ls=null;
        cid=cidlbl.getText();
        ls= pwsr.getNextPslno(cid);
        int cod=ls.size();
        int nex=cod+1;
        st1.setText(String.valueOf(nex));
    }
    public void nxtAcId()
    {
        PrdWiseSrvs pwsr=new PrdWiseSrvs();
        List ls=null;
        cid=cidlbl.getText();
        ls= pwsr.getNextActno(cid);
        int cod=ls.size();
        int nex=cod+1;
        at1.setText(String.valueOf(nex));
    }
    public void nxtASlno()
    {
        PrdWiseSrvs pwsr=new PrdWiseSrvs();
        List ls=null;
        cid=cidlbl.getText();
        String aid=at1.getText();
        ls= pwsr.getNextAslno(cid,aid);
        int cod=ls.size();
        int nex=cod+1;
        at2.setText(String.valueOf(nex));
    }
    public void nxtPID(String tid)
    {
        PrdWiseSrvs pwsr=new PrdWiseSrvs();
        List ls=null;
        cid=cidlbl.getText();
        ls= pwsr.NxtPslno(cid,tid);
        int cod=ls.size();
        int nex=cod+1;
        pt1.setText(String.valueOf(nex));
    }
    public void disableall()
    {
        //-------------------------------Stock ---------------------------
        lbl1.setEnabled(false);
        lbl2.setEnabled(false);
        lbl3.setEnabled(false);
        lbl4.setEnabled(false);
        lbl5.setEnabled(false);
        lbl6.setEnabled(false);
        lbl7.setEnabled(false);
        lbl8.setEnabled(false);
        cidlbl.setEnabled(false);
        codcmb.setEnabled(false);
        st1.setEnabled(false);
        st2.setEnabled(false);
        st3.setEnabled(false);
        st4.setEnabled(false);
        st5.setEnabled(false);
        sdat.setEnabled(false);
        sadd.setEnabled(false);
        ssave.setEnabled(false);
        supdate.setEnabled(false);
        sclr.setEnabled(false);
        //-------------------------------Action ---------------------------
        lbl9.setEnabled(false);
        lbl10.setEnabled(false);
        lbl11.setEnabled(false);
        lbl12.setEnabled(false);
        lbl13.setEnabled(false);
        lbl14.setEnabled(false);
        lbl15.setEnabled(false);
        lbl16.setEnabled(false);
        lbl17.setEnabled(false);
        lbl18.setEnabled(false);
        lbl19.setEnabled(false);
        lbl20.setEnabled(false);
        at1.setEnabled(false);
        at2.setEnabled(false);
        at3.setEnabled(false);
        at4.setEnabled(false);
        at5.setEnabled(false);
        at6.setEnabled(false);
        at7.setEnabled(false);
        asdat.setEnabled(false);
        aedat.setEnabled(false);
        aadd.setEnabled(false);
        asave.setEnabled(false);
        aclr.setEnabled(false);
        //-------------------------------Marketing ---------------------------
        lbl21.setEnabled(false);
        lbl22.setEnabled(false);
        lbl23.setEnabled(false);
        lbl24.setEnabled(false);
        lbl25.setEnabled(false);
        lbl26.setEnabled(false);
        lbl27.setEnabled(false);
        mdat.setEnabled(false);
        mt1.setEnabled(false);
        mt2.setEnabled(false);
        mt3.setEnabled(false);
        mpbtn.setEnabled(false);
        msave.setEnabled(false);
        //-----------------------------Payment----------------------------
        l1.setEnabled(false);
        l2.setEnabled(false);
        l3.setEnabled(false);
        l4.setEnabled(false);
        l5.setEnabled(false);
        l6.setEnabled(false);
        l7.setEnabled(false);
        l8.setEnabled(false);
        l9.setEnabled(false);
        l10.setEnabled(false);
        l11.setEnabled(false);
        l12.setEnabled(false);
        l13.setEnabled(false);
        l14.setEnabled(false);
        l15.setEnabled(false);
        l16.setEnabled(false);
        l17.setEnabled(false);
        pt1.setEnabled(false);
        pt2.setEnabled(false);
        pt3.setEnabled(false);
        pt4.setEnabled(false);
        pt5.setEnabled(false);
        pt6.setEnabled(false);
        pt7.setEnabled(false);
        pt8.setEnabled(false);
        pt9.setEnabled(false);
        pt10.setEnabled(false);
        pdat.setEnabled(false);
        psave.setEnabled(false);
        pupdt.setEnabled(false);
    }
    public void enablepay()
    {
        l1.setEnabled(true);
        l2.setEnabled(true);
        l3.setEnabled(true);
        l4.setEnabled(true);
        l5.setEnabled(true);
        l6.setEnabled(true);
        l7.setEnabled(true);
        l8.setEnabled(true);
        l9.setEnabled(true);
        l10.setEnabled(true);
        l11.setEnabled(true);
        l12.setEnabled(true);
        l13.setEnabled(true);
        l14.setEnabled(true);
        l15.setEnabled(true);
        l16.setEnabled(true);
        l17.setEnabled(true);
        pt1.setEnabled(true);
        pt2.setEnabled(true);
        pt3.setEnabled(true);
        pt4.setEnabled(true);
        pt5.setEnabled(true);
        pt6.setEnabled(true);
        pt7.setEnabled(true);
        pt8.setEnabled(true);
        pt9.setEnabled(true);
        pt10.setEnabled(true);
        pdat.setEnabled(true);
        psave.setEnabled(true);
        pupdt.setEnabled(true);
    }
    public void enableprd()
    {
        lbl1.setEnabled(true);
        lbl2.setEnabled(true);
        lbl3.setEnabled(true);
        lbl4.setEnabled(true);
        lbl5.setEnabled(true);
        lbl6.setEnabled(true);
        lbl7.setEnabled(true);
        lbl8.setEnabled(true);
        cidlbl.setEnabled(true);
        codcmb.setEnabled(true);
        st1.setEnabled(true);
        st2.setEnabled(true);
        st3.setEnabled(true);
        st4.setEnabled(true);
        st5.setEnabled(true);
        sdat.setEnabled(true);
        sadd.setEnabled(true);
        ssave.setEnabled(true);
        sclr.setEnabled(true);
    }
    public void enableact()
    {
        lbl9.setEnabled(true);
        lbl10.setEnabled(true);
        lbl11.setEnabled(true);
        lbl12.setEnabled(true);
        lbl13.setEnabled(true);
        lbl14.setEnabled(true);
        lbl15.setEnabled(true);
        lbl16.setEnabled(true);
        lbl17.setEnabled(true);
        lbl18.setEnabled(true);
        lbl19.setEnabled(true);
        lbl20.setEnabled(true);
        at1.setEnabled(true);
        at2.setEnabled(true);
        at3.setEnabled(true);
        at4.setEnabled(true);
        at5.setEnabled(true);
        at6.setEnabled(true);
        at7.setEnabled(true);
        asdat.setEnabled(true);
        aedat.setEnabled(true);
        aadd.setEnabled(true);
        asave.setEnabled(true);
        aclr.setEnabled(true);
    }
    public void enablesell()
    {
        lbl21.setEnabled(true);
        lbl22.setEnabled(true);
        lbl23.setEnabled(true);
        lbl24.setEnabled(true);
        lbl25.setEnabled(true);
        lbl26.setEnabled(true);
        lbl27.setEnabled(true);
        mdat.setEnabled(true);
        mt1.setEnabled(true);
        mt2.setEnabled(true);
        mt3.setEnabled(true);
        msave.setEnabled(true);
    }
    private void cntxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cntxtKeyPressed
        // TODO add your handling code here:
        int key=evt.getKeyCode();
        if(key==10) {
            csttab.requestFocus();
        }
}//GEN-LAST:event_cntxtKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        GETOC.pp=0;
    }//GEN-LAST:event_formInternalFrameClosed

    private void mpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpbtnActionPerformed
        // TODO add your handling code here:
        tabpan.setSelectedIndex(1);
        cid=cidlbl.getText();
        getTRNTable(cid);
        comboPrds(cid);
        comboDates(cid);
    }//GEN-LAST:event_mpbtnActionPerformed

    private void saddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saddActionPerformed
        // TODO add your handling code here:
        nxtPrdslno();
        clrprd();
        st2.requestFocus();
    }//GEN-LAST:event_saddActionPerformed

    private void st2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_st2ActionPerformed
        // TODO add your handling code here:
        String s=(String) st2.getSelectedItem();
        if(!s.equals("-Select-"))
        {
            try{
            String ic=(String) st2.getSelectedItem();
            MasterSrvs msrv=new MasterSrvs();
            PrdModel pm=null;
            pm=(PrdModel)msrv.getPBicode(ic);
            st3.setText(pm.getProduct());
            }catch(Exception e){}
        }
    }//GEN-LAST:event_st2ActionPerformed

    private void sclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sclrActionPerformed
        clrprd();
    }//GEN-LAST:event_sclrActionPerformed
    private void codcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codcmbActionPerformed
        // TODO add your handling code here:
        String s=(String) codcmb.getSelectedItem();
        if(!s.equals("-Select-"))
        {
            try
            {
                cid=cidlbl.getText();
                String icod=(String) codcmb.getSelectedItem();
                String sts="Opened";
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                PrdInvModel pim=null;
                pim=(PrdInvModel)pwsrv.getPrdInvBic(cid, icod, sts);
                st1.setText(pim.getSlno());
                st2.setSelectedItem(pim.getIcode());
                st3.setText(pim.getIname());
                at3.setText(pim.getIname());
                st4.setText(pim.getPack());
                java.util.Date d=new java.util.Date();
                d=pim.getPidate();
                sdat.setDate(d);
                st5.setSelectedItem(pim.getPstatus());
                ssave.setEnabled(false);
                supdate.setEnabled(true);
                callaction();
                nxtASlno();
                enableact();
            }catch(Exception e){}
        }
    }//GEN-LAST:event_codcmbActionPerformed
    String sno;
    public void callaction()
    {
        getASlno();
        try
        {
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            PrdActModel pam=null;
            cid=cidlbl.getText();
            String pno=st1.getText();
            pam=(PrdActModel)pwsrv.getPrdActBypno(cid, pno,sno);
            at1.setText(pam.getAid());
            java.util.Date d=new java.util.Date();
            d=pam.getAsdate();
            asdat.setDate(d);
            asts=pam.getStatus();
            if(asts.equals("Closed"))
            {
                chksts();
                enablesell();
            }
        }catch(Exception e){}
    }
    public void getASlno()
    {
        PrdWiseSrvs pwsr=new PrdWiseSrvs();
        List ls=null;
        cid=cidlbl.getText();
        String aid=at1.getText();
        ls= pwsr.getNextAslno(cid,aid);
        int cod=ls.size();
        sno=String.valueOf(cod);
    }
    private void st2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_st2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            String s=(String) st2.getSelectedItem();
            if(!s.equals("-Select-"))
            {
                try
                {
                    String ic=(String) st2.getSelectedItem();
                    MasterSrvs msrv=new MasterSrvs();
                    PrdModel pm=null;
                    pm=(PrdModel)msrv.getPBicode(ic);
                    st3.setText(pm.getProduct());
                    st4.requestFocus();
                }catch(Exception e){}
            }
        }
    }//GEN-LAST:event_st2KeyPressed

    private void st4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_st4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            st5.requestFocus();
        }
    }//GEN-LAST:event_st4KeyPressed

    private void st5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_st5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            ssave.requestFocus();
        }
    }//GEN-LAST:event_st5KeyPressed

    private void ssaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ssaveKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            ssave.doClick();
        }
    }//GEN-LAST:event_ssaveKeyPressed

    private void ssaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssaveActionPerformed
        // TODO add your handling code here:
        cid=cidlbl.getText();
        p1=st1.getText();
        p2=(String) st2.getSelectedItem();
        p3=st3.getText();
        p4=st4.getText();
        p5=(String) st5.getSelectedItem();
        boolean vsp=validprdstock();
        if(vsp)
        {
            boolean flag=false;
            java.sql.Date d=new java.sql.Date(sdat.getDate().getTime());
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            flag=pwsrv.savePrsInv(cid, p1, p2, p3, p4, d, p5);
            if(flag)
            {
                comboCodes(cid);
                codcmb.setSelectedItem(p2);
                JOptionPane.showMessageDialog(this, "ಖಾತೆಯ ಷೆರು ಉತ್ಪನ್ನವನ್ನು ಉಳಿಸಲಾಗಿದೆ");
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಖಾತೆಯ ಷೆರು ಉತ್ಪನ್ನವನ್ನು ಉಳಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }

    }//GEN-LAST:event_ssaveActionPerformed

    private void supdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdateActionPerformed
        // TODO add your handling code here:
        cid=cidlbl.getText();
        p1=st1.getText();
        p2=(String) st2.getSelectedItem();
        p3=st3.getText();
        p4=st4.getText();
        p5=(String) st5.getSelectedItem();
        boolean vsp=validprdstock();
        if(vsp)
        {
            boolean flag=false;
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            flag=pwsrv.updatePrsInv(cid, p1, p2, p3, p4,p5);
            if(flag)
            {
                comboCodes(cid);
                JOptionPane.showMessageDialog(this, "ಖಾತೆಯ ಷೆರು ಉತ್ಪನ್ನವನ್ನು ಉಳಿಸಲಾಗಿದೆ");
            }
        }
    }//GEN-LAST:event_supdateActionPerformed
    public void updateAsts()
    {
      boolean flag=false;
      PrdWiseSrvs pwsrv=new PrdWiseSrvs();
      flag=pwsrv.UpdtActSTS(cid, a1, asts);
      if(flag)
      {
          updatePsts();
      }else{JOptionPane.showMessageDialog(this, "Updateing Failed");}
    }
    public void updatePsts()
    {
      boolean flag=false;
      PrdWiseSrvs pwsrv=new PrdWiseSrvs();
      String pslno=st1.getText();
      flag=pwsrv.updatePSTS(cid, pslno, asts);
      if(flag)
      {
          JOptionPane.showMessageDialog(this, "ಹರಾಜು ಪ್ರಕ್ರಿಯೆಯ ವಿವರಗಳನ್ನು ಉಳಿಸಲಾಗಿದೆ");
      }else{JOptionPane.showMessageDialog(this, "Updateing Failed");}
    }
    private void aaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaddActionPerformed
        // TODO add your handling code here:
        nxtASlno();
        clraction();
        at4.requestFocus();
    }//GEN-LAST:event_aaddActionPerformed
    public void clraction()
    {
        at4.setText("");
        at5.setSelectedIndex(0);
        at6.setText("");
        at7.setText("");
    }
    private void asaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asaveActionPerformed
        // TODO add your handling code here:
        cid=cidlbl.getText();
        a1=at1.getText();
        a2=at2.getText();
        a3=at3.getText();
        a4=at4.getText();
        a5=(String) at5.getSelectedItem();
        a6=at6.getText();
        a7=at7.getText();
        boolean vac=validAction();
        if(vac)
        {
            boolean flag=false;
            asd=new java.sql.Date(asdat.getDate().getTime());
            String pslno=st1.getText();
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            flag=pwsrv.savePrsAct(cid, a1, a2, a3, asd, aa4, a5, aed, aa6, aa7,asts,pslno);
            if(flag)
            {
                chksts();
                updateAsts();
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಹರಾಜು ಪ್ರಕ್ರಿಯೆಯ ವಿವರಗಳನ್ನು ಉಳಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }
    }//GEN-LAST:event_asaveActionPerformed
    private void at4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_at4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            at5.requestFocus();
        }
    }//GEN-LAST:event_at4KeyPressed
    private void at5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_at5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            at6.requestFocus();
        }
    }//GEN-LAST:event_at5KeyPressed
    private void at6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_at6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            try{aa6=Double.valueOf(at6.getText());at7.requestFocus();
            }catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಸಂಖ್ಯೆಯನ್ನು ನಮೊದಿಸಿ");at6.requestFocus();}
        }
    }//GEN-LAST:event_at6KeyPressed
    private void at7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_at7KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            try{aa7=Double.valueOf(at7.getText());asave.requestFocus();
            }catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಸಂಖ್ಯೆಯನ್ನು ನಮೊದಿಸಿ");at7.requestFocus();}
        }
    }//GEN-LAST:event_at7KeyPressed
    private void asaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asaveKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            asave.doClick();
        }
    }//GEN-LAST:event_asaveKeyPressed
    private void aclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclrActionPerformed
        // TODO add your handling code here:
        clraction();
    }//GEN-LAST:event_aclrActionPerformed

    private void msaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msaveActionPerformed
        // TODO add your handling code here:
        cid=cidlbl.getText();
        String aid=at1.getText();
        boolean vl=validsell();
        if(vl)
        {
            boolean flag=false;
            java.sql.Date md=new java.sql.Date(mdat.getDate().getTime());
            PrdWiseSrvs pwrv=new PrdWiseSrvs();
            String prd=at3.getText();
            flag=pwrv.savePrsSell(cid, aid,prd,md, mm1, mm2, mm3);
            if(flag)
            {
                mpbtn.setEnabled(true);
                JOptionPane.showMessageDialog(this, "ಖಾತೆಯ ಉತ್ಪನ್ನ ಮಾರಾಟದ ವಿವರಗಳನ್ನು ಉಳಿಸಲಾಗಿದೆ");
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಮಾರಾಟದ ವಿವರಗಳನ್ನು ಉಳಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }
    }//GEN-LAST:event_msaveActionPerformed
    String gdat;
    String tid;
    private void trntabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trntabKeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==10)
        {
            int ro=trntab.getSelectedRow();
            tid=trntab.getModel().getValueAt(ro,0).toString();
            gdat=trntab.getModel().getValueAt(ro,1).toString();
            String amt=trntab.getModel().getValueAt(ro,2).toString();
            pt5.setText(tid);
            pt6.setText(amt);
            nxtPID(tid);
            enablepay();
            comboPIDs(cid,tid);
        }
    }//GEN-LAST:event_trntabKeyPressed

    private void trntabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trntabMouseClicked
        // TODO add your handling code here:
        
        int ro=trntab.getSelectedRow();
        tid=trntab.getModel().getValueAt(ro,0).toString();
        gdat=trntab.getModel().getValueAt(ro,1).toString();
        String amt=trntab.getModel().getValueAt(ro,2).toString();
        pt5.setText(tid);
        pt6.setText(amt);
        nxtPID(tid);
        enablepay();
        comboPIDs(cid,tid);
    }//GEN-LAST:event_trntabMouseClicked

    private void pt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pt3ActionPerformed
        // TODO add your handling code here:
        if(pt3.getSelectedIndex()!=0)
        {
            try
            {
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                CstPrdSellModel psm=null;
                String prd=(String) pt3.getSelectedItem();
                java.sql.Date mdt=new java.sql.Date(java.sql.Date.valueOf(pt2.getSelectedItem().toString()).getTime());
                psm=(CstPrdSellModel)pwsrv.getPrdActBP(cid, prd, mdt);
                pt4.setText(String.valueOf(psm.getTotamt()));
            }catch(Exception e){JOptionPane.showMessageDialog(this,"Error"+e);}
        }
    }//GEN-LAST:event_pt3ActionPerformed

    private void pt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pt2ActionPerformed
        // TODO add your handling code here:
        if(pt2.getSelectedIndex()!=0)
        {
            try
            {
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                CstPrdSellModel psm=null;
                java.sql.Date mdt=new java.sql.Date(java.sql.Date.valueOf(pt2.getSelectedItem().toString()).getTime());
                psm=(CstPrdSellModel)pwsrv.getPrdActBD(cid, mdt);
                pt3.setSelectedItem(psm.getProduct());
            }catch(Exception e){JOptionPane.showMessageDialog(this,"Error"+e);}
        }
    }//GEN-LAST:event_pt2ActionPerformed

    private void pt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pt7ActionPerformed
        // TODO add your handling code here:
         try
        {
            DateFormat formatter = null;
            Date cDate = null;
            //old date----------------------------------
            Calendar old = Calendar.getInstance();
            
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            cDate = (Date) formatter.parse(gdat);
            old.setTime(new java.util.Date(cDate.getTime()));
            int oyy=old.get(Calendar.YEAR);
            int omm=old.get(Calendar.MONTH);
            int odd=old.get(Calendar.DATE);
            //-------------------------------------------
            //present date---------------------------------
            Calendar now = Calendar.getInstance();
            now.setTime(new java.util.Date(pdat.getDate().getTime()));
            int nyy=now.get(Calendar.YEAR);
            int nmm=now.get(Calendar.MONTH);
            int ndd=now.get(Calendar.DATE);
            //----------------------------------------------
            Date past = new Date(oyy, omm, odd); // June 20th, 2010
            Date today = new Date(nyy, nmm, ndd); // July 24th
            int days = Days.daysBetween(new DateTime(past), new DateTime(today)).getDays();
           // int month = Months.monthsBetween(new DateTime(past), new DateTime(today)).getMonths();
           // int mnth = month+1;
            int td=days+1;
            if(td<30)
            {
                int tday=30;
                int cm1=tday/30;
                Double ga=Double.valueOf(pt6.getText());
                Double itrs=Double.valueOf(pt7.getSelectedItem().toString());
                Double cga=ga/100;
                Double ci=cga*itrs;
                Double cti=ci*cm1;
                double tamt=ga+cti;
                pt8.setText(String.valueOf(tamt));
                Double pr=Double.valueOf(pt4.getText());
                Double cbal=tamt-pr;
                if(cbal>0)
                {
                    Double balamt=tamt-pr;
                    pt9.setText(String.valueOf(balamt));
                    pt10.setText("0.0"); 
                }
                if(cbal<0)
                {
                    Double balamt=pr-tamt;
                    pt9.setText("0.0");
                    pt10.setText(String.valueOf(balamt));
                }
            }
            if(td>30)
            {
                int mnt2=td/30;
                Double ga=Double.valueOf(pt6.getText());
                Double itrs=Double.valueOf(pt7.getSelectedItem().toString());
                Double cga=ga/100;
                Double ci=cga*itrs;
                Double cti=ci*mnt2;
                double tamt=ga+cti;
                pt8.setText(String.valueOf(tamt));
                Double pr=Double.valueOf(pt4.getText());
                Double cbal=tamt-pr;
                if(cbal>0)
                {
                    Double balamt=tamt-pr;
                    pt9.setText(String.valueOf(balamt));
                    pt10.setText("0.0");
                }
                if(cbal<0)
                {
                    Double balamt=pr-tamt;
                    pt9.setText("0.0");
                    pt10.setText(String.valueOf(balamt));
                }
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, "Error is ="+e);}
    }//GEN-LAST:event_pt7ActionPerformed
    
    private void pt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pt2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            if(pt2.getSelectedIndex()!=0)
        {
            try
            {
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                CstPrdSellModel psm=null;
                java.sql.Date mdat=new java.sql.Date(java.sql.Date.valueOf(pt2.getSelectedItem().toString()).getTime());
                psm=(CstPrdSellModel)pwsrv.getPrdActBD(cid, mdat);
                pt3.setSelectedItem(psm.getProduct());
            }catch(Exception e){JOptionPane.showMessageDialog(this,"Error"+e);}
        }
        }
    }//GEN-LAST:event_pt2KeyPressed

    private void pt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pt3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            if(pt3.getSelectedIndex()!=0)
        {
            try
            {
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                CstPrdSellModel psm=null;
                String prd=(String) pt3.getSelectedItem();
                java.sql.Date mdt=new java.sql.Date(java.sql.Date.valueOf(pt2.getSelectedItem().toString()).getTime());
                psm=(CstPrdSellModel)pwsrv.getPrdActBP(cid, prd, mdt);
                pt4.setText(String.valueOf(psm.getTotamt()));
            }catch(Exception e){JOptionPane.showMessageDialog(this,"Error"+e);}
        }
        }
    }//GEN-LAST:event_pt3KeyPressed

    private void psaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psaveActionPerformed
        // TODO add your handling code here:
        t1=pt1.getText();
        t2=(String) pt2.getSelectedItem();
        t3=(String) pt3.getSelectedItem();
        tt4=Double.valueOf(pt4.getText());
        t5=pt5.getText();
        tt6=Double.valueOf(pt6.getText());
        tt7=Double.valueOf(pt7.getSelectedItem().toString());
        tt8=Double.valueOf(pt8.getText());
        tt9=Double.valueOf(pt9.getText());
        tt10=Double.valueOf(pt10.getText());
        boolean vp=validpaym();
        if(vp)
        {
            boolean flag=false;
            java.sql.Date pdt=new java.sql.Date(pdat.getDate().getTime());
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            String pn="-";
            Double bc=0.0;
            flag=pwsrv.savePrdPay(cid, t1, pdt, t2, t3, tt4, t5, tt6, tt7, tt8, tt9, tt10, pn, bc);
            if(flag)
            {
                Double cb=Double.valueOf(pt9.getText());
                if(cb==0.0)
                {updateTrn();}else{updatetrnPay("Opened");JOptionPane.showMessageDialog(this, "ಉತ್ಪನ್ನದಿಂದ ಬಂದ ಹಣವನ್ನು ಪಾವತಿಸಲಾಗಿದೆ");}
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಉತ್ಪನ್ನದಿಂದ ಬಂದ ಹಣವನ್ನು ಪಾವತಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }

    }//GEN-LAST:event_psaveActionPerformed

    private void pupdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupdtActionPerformed
        // TODO add your handling code here:
        t1=pt1.getText();
        t2=(String) pt2.getSelectedItem();
        t3=(String) pt3.getSelectedItem();
        tt4=Double.valueOf(pt4.getText());
        t5=pt5.getText();
        tt6=Double.valueOf(pt6.getText());
        tt7=Double.valueOf(pt7.getSelectedItem().toString());
        tt8=Double.valueOf(pt8.getText());
        tt9=Double.valueOf(pt9.getText());
        tt10=Double.valueOf(pt10.getText());
        boolean vp=validpaym();
        if(vp)
        {
            boolean flag=false;
            java.sql.Date pdt=new java.sql.Date(pdat.getDate().getTime());
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            String pn="-";
            Double bc=0.0;
            flag=pwsrv.UpdatePrdPay(cid, t1,t2, t3, tt4, t5, tt6, tt7, tt8, tt9, tt10, pn, bc);
            if(flag)
            {
                Double cb=Double.valueOf(pt9.getText());
                if(cb==0)
                {updateTrn();}else{updatetrnPay("Opened");JOptionPane.showMessageDialog(this, "ಉತ್ಪನ್ನದಿಂದ ಬಂದ ಹಣವನ್ನು ಪಾವತಿಸಲಾಗಿದೆ");}
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಉತ್ಪನ್ನದಿಂದ ಬಂದ ಹಣವನ್ನು ಪಾವತಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }
    }//GEN-LAST:event_pupdtActionPerformed

    private void pclrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pclrActionPerformed
        // TODO add your handling code here:
        clr();
    }//GEN-LAST:event_pclrActionPerformed

    private void pidcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidcmbActionPerformed
        // TODO add your handling code here:
        if(pidcmb.getSelectedIndex()!=0)
        {
            String pid=(String) pidcmb.getSelectedItem();
            PrdWiseSrvs pwsrv=new PrdWiseSrvs();
            PayModel paym=null;
            paym=(PayModel)pwsrv.getPayData(cid, tid, pid);
            String chk=paym.getProduct();
            if(!chk.equals(""))
            {
            pt1.setText(paym.getPid());
            java.util.Date d=new java.util.Date();
            d=paym.getPaydate();
            pdat.setDate(d);
            pt2.setSelectedItem(paym.getSolddate());
            pt3.setSelectedItem(paym.getProduct());
            pt4.setText(String.valueOf(paym.getPrdamt()));
            pt5.setText(paym.getTid());
            pt6.setText(String.valueOf(paym.getTrnamt()));
            pt7.setSelectedItem(paym.getIntrest());
            pt8.setText(String.valueOf(paym.getWtintrst()));
            pt9.setText(String.valueOf(paym.getDueamt()));
            }else{JOptionPane.showMessageDialog(this, "ಈ ID ಯು ಉತ್ಪದನಾ ಪಾವತಿಗೆ ಅನ್ವಯಿಸುವುದಿಲ್ಲ");}
        }
    }//GEN-LAST:event_pidcmbActionPerformed

    private void codcmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codcmb1ActionPerformed
        // TODO add your handling code here:
        String s=(String) codcmb1.getSelectedItem();
        if(!s.equals("-Select-"))
        {
            try
            {
                cid=cidlbl.getText();
                String icod=(String) codcmb1.getSelectedItem();
                String sts="Closed";
                PrdWiseSrvs pwsrv=new PrdWiseSrvs();
                PrdInvModel pim=null;
                pim=(PrdInvModel)pwsrv.getPrdInvBic(cid, icod, sts);
                st1.setText(pim.getSlno());
                st2.setSelectedItem(pim.getIcode());
                st3.setText(pim.getIname());
                at3.setText(pim.getIname());
                st4.setText(pim.getPack());
                java.util.Date d=new java.util.Date();
                d=pim.getPidate();
                sdat.setDate(d);
                supdate.setEnabled(false);
            }catch(Exception e){}
        }
    }//GEN-LAST:event_codcmb1ActionPerformed
    public void clr()
    {
         pt2.setSelectedIndex(0);
        pt3.setSelectedIndex(0);
        pt4.setText("");
        pt5.setText("");
        pt6.setText("");
        pt7.setSelectedIndex(0);
        pt8.setText("");
        pt9.setText("");
        pt10.setText("");
    }
    public void updateTrn()
    {
        boolean flag=false;
        String tid=pt5.getText();
        String sts="Closed";
        TranSrvs tsrv=new TranSrvs();
        flag=tsrv.UpdateSTS(cid,tid,sts);
        if(flag)
        {updatetrnPay("Closed");}else{JOptionPane.showMessageDialog(this, "Transaction Update Failed");}
    }
    public void updatetrnPay(String sts)
    {
        boolean flag=false;
        String tid=pt5.getText();
        TranSrvs tsrv=new TranSrvs();
        Double pa=Double.valueOf(pt8.getText());
        Double ba=Double.valueOf(pt8.getText());
        flag=tsrv.UpdateTPSTS(cid,tid,sts,ba,pa);
        if(flag)
        {
            updateprdsell();
        }else{JOptionPane.showMessageDialog(this, "Transaction Payemnt Update Failed");}
    }
    public void updateprdsell()
    {
        boolean flag=false;
        String tid=pt5.getText();
        TranSrvs tsrv=new TranSrvs();
        java.sql.Date md=(java.sql.Date.valueOf(pt2.getSelectedItem().toString()));
        String prd=(String) pt3.getSelectedItem();
        flag=tsrv.UpdateCPS(cid,prd,md);
        if(flag)
        {
            getTRNTable(cid);
            JOptionPane.showMessageDialog(this, "ಉತ್ಪನ್ನದಿಂದ ಬಂದ ಹಣವನ್ನು ಪಾವತಿಸಲಾಗಿದೆ");
        }else{JOptionPane.showMessageDialog(this, "product Sell Update Failed");}
    }
    private boolean validpaym()
    {
        if(pdat.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ದಿನಾಂಕವನ್ನು ಹೊಂದಿಸಿ");return false;}
        if(pt2.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಮಾರಾಟದ ದಿನಾಂಕವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
        if(pt3.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
        if(pt7.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ವಿತರಿಸಿದ ಮೊತ್ತಕ್ಕೆ ಬಡ್ಡಿಯನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
        return true;
    }
    private boolean validsell()
    {
        if(mdat.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಮಾರಾಟ ದಿನಾಂಕವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
        mm1=Double.valueOf(mt1.getText());
        mm2=Double.valueOf(mt2.getText());
        mm3=Double.valueOf(mt3.getText());
        return true;
    }
    public void chksts()
    {
        if(asts.equals("Closed"))
        {
            Double wgt=Double.valueOf(at6.getText());
            mt1.setText(String.valueOf(wgt));
            Double qrt=Double.valueOf(at7.getText());
            mt2.setText(String.valueOf(qrt));
            Double sw=wgt/100;
            Double camt=sw*qrt;
            mt3.setText(String.valueOf(camt));
            mdat.setDate(new java.util.Date());
            mpbtn.setEnabled(false);
        }
    }
    private boolean validAction()
    {
        if(a4.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಹರಾಜು ಹಣವನ್ನು ನಮೊದಿಸಿ");at4.requestFocus();return false;}
        try{aa4=Double.valueOf(a4);}catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಹರಾಜು ಹಣವನ್ನು ಸಂಖ್ಯೆಗಳಲ್ಲಿ ನಮೊದಿಸಿ");return false;}
        if(at5.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಹರಾಜು ಸ್ಥಿತಿಯನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");at5.requestFocus();return false;}
        if(asdat.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಹರಾಜು ದಿನಾಂಕವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
        if((aedat.getDate()!=null)||(a6.length()!=0)||(a7.length()!=0))
        {
            try{aed=new java.sql.Date(asdat.getDate().getTime());}catch(Exception e){}
            if(aedat.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಹರಾಜು ಮುಕ್ತಾಯ ದಿನಾಂಕವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");return false;}
            if(a6.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ ಒಟ್ಟು ತೂಕವನ್ನು ನಮೊದಿಸಿ");at6.requestFocus();return false;}
            try{aa6=Double.valueOf(a6);}catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ ತೂಕವನ್ನು ಸಂಖ್ಯೆಯಲ್ಲಿ ನಮೊದಿಸಿ");return false;}
            if(a7.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ 1 ಕ್ವಿಂಟಲ್‍ನ ಹಣವನ್ನು ನಮೊದಿಸಿ");at7.requestFocus();return false;}
            try{aa7=Double.valueOf(a7);}catch(Exception e){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ 1 ಕ್ವಿಂಟಲ್‍ನ ಹಣವನ್ನು ಸಂಖ್ಯೆಯಲ್ಲಿ ನಮೊದಿಸಿ");return false;}
            asts="Closed";
            enablesell();
        }
        if((aedat.getDate()==null)&&(a6.length()==0)&&(a7.length()==0))
        {
            java.sql.Date d=new java.sql.Date(asdat.getDate().getTime());
            aed=d;
            aa6=0.0;
            aa7=0.0;
            asts="Opened";
        }
        return true;
    }
    private boolean validprdstock()
    {
        if(st2.getSelectedIndex()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ CODE ಆಯ್ದುಕೊಳ್ಳಿ");st2.requestFocus();return false;}
        if(p4.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಚಿಲಗಳ ಸಂಖ್ಯೆಯನ್ನು ನಮೊದಿಸಿ");st4.requestFocus();return false;}
        if(sdat.getDate()==null){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ದಿನಾಂಕವನ್ನು ನಮೊದಿಸಿ");return false;}
        return true;
    }
    public void clrprd()
    {
        st2.setSelectedIndex(0);
        st3.setText("");
        st4.setText("");
        sdat.setDate(new java.util.Date());
        st5.setSelectedItem(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aadd;
    private javax.swing.JButton aclr;
    private com.toedter.calendar.JDateChooser aedat;
    private javax.swing.JButton asave;
    private com.toedter.calendar.JDateChooser asdat;
    private javax.swing.JLabel at1;
    private javax.swing.JLabel at2;
    private javax.swing.JLabel at3;
    private javax.swing.JTextField at4;
    private javax.swing.JComboBox at5;
    private javax.swing.JTextField at6;
    private javax.swing.JTextField at7;
    private javax.swing.JLabel cidlbl;
    private javax.swing.JTextField cntxt;
    private javax.swing.JComboBox codcmb;
    private javax.swing.JComboBox codcmb1;
    private javax.swing.JTable csttab;
    private javax.swing.JDesktopPane dpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l13;
    private javax.swing.JLabel l14;
    private javax.swing.JLabel l15;
    private javax.swing.JLabel l16;
    private javax.swing.JLabel l17;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl18;
    private javax.swing.JLabel lbl19;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl20;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JLabel lbl23;
    private javax.swing.JLabel lbl24;
    private javax.swing.JLabel lbl25;
    private javax.swing.JLabel lbl26;
    private javax.swing.JLabel lbl27;
    private javax.swing.JLabel lbl28;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private com.toedter.calendar.JDateChooser mdat;
    private javax.swing.JButton mpbtn;
    private javax.swing.JButton msave;
    private javax.swing.JLabel mt1;
    private javax.swing.JLabel mt2;
    private javax.swing.JLabel mt3;
    private javax.swing.JButton pclr;
    private com.toedter.calendar.JDateChooser pdat;
    private javax.swing.JComboBox pidcmb;
    private javax.swing.JButton psave;
    private javax.swing.JLabel pt1;
    private javax.swing.JLabel pt10;
    private javax.swing.JComboBox pt2;
    private javax.swing.JComboBox pt3;
    private javax.swing.JLabel pt4;
    private javax.swing.JLabel pt5;
    private javax.swing.JLabel pt6;
    private javax.swing.JComboBox pt7;
    private javax.swing.JLabel pt8;
    private javax.swing.JLabel pt9;
    private javax.swing.JButton pupdt;
    private javax.swing.JButton sadd;
    private javax.swing.JButton sclr;
    private com.toedter.calendar.JDateChooser sdat;
    private javax.swing.JButton ssave;
    private javax.swing.JLabel st1;
    private javax.swing.JComboBox st2;
    private javax.swing.JLabel st3;
    private javax.swing.JTextField st4;
    private javax.swing.JComboBox st5;
    private javax.swing.JButton supdate;
    private javax.swing.JTabbedPane tabpan;
    private javax.swing.JTable trntab;
    // End of variables declaration//GEN-END:variables
    Object tabdata[][];
    public void getTableDATA()
    {
        tabdata=null;
        int i=0,j=0;
        CustomerSrvs csr=new CustomerSrvs();
        CstModel cstm=null;
        List lst=new LinkedList();
        lst=(List)csr.getcstTab();
        tabdata=new Object[lst.size()][13];
        String col[]={"ಖಾತೆ ನಂ","ಹೆಸರು"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            cstm=(CstModel)itm.next();
            tabdata[i][0]=(String)cstm.getCid();
            tabdata[i][1]=(String)cstm.getCnam();
            i++;
        }
       DefaultTableModel dm =new DefaultTableModel(tabdata,col);
       csttab.setModel(dm);
       csttab.setAutoResizeMode(csttab.AUTO_RESIZE_OFF);
       csttab.getColumnModel().getColumn(0).setPreferredWidth(70);
       csttab.getColumnModel().getColumn(1).setPreferredWidth(130);
    }
    public void getTRNTable(String cid)
    {
        int i=0,j=0;
        TranSrvs tsrv =new TranSrvs();
        TrnPayModel tpm=null;
        List lst=new LinkedList();
        lst=(List)tsrv.getTTPrd(cid);
        Object[][] tadata=new Object[lst.size()][5];
        String col[]={"Trn ID","ದಿನಾಂಕ","ಹಣ ಮೊತ್ತ"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            tpm=(TrnPayModel)itm.next();
            tadata[i][0]=(String)tpm.getTid();
            tadata[i][1]=(Date)tpm.getTdate();
            tadata[i][2]=(Double)tpm.getTotamt();
            i++;
        }
       DefaultTableModel dm =new DefaultTableModel(tadata,col);
       trntab.setModel(dm);
       trntab.setAutoResizeMode(trntab.AUTO_RESIZE_OFF);
       trntab.getColumnModel().getColumn(0).setPreferredWidth(100);
       trntab.getColumnModel().getColumn(1).setPreferredWidth(180);
       trntab.getColumnModel().getColumn(1).setPreferredWidth(180);
    }
}
