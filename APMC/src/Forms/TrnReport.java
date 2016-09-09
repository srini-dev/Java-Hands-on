/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CstReport.java
 *
 * Created on Mar 30, 2015, 1:13:54 PM
 */

package Forms;

import APMCMain.GETOC;
import Forms.Models.CstModel;
import Forms.Reports.TRNBdate;
import Forms.Reports.TRNBnam;
import Forms.Reports.TRNBplace;
import Forms.Reports.TrnAll;
import Forms.Services.CustomerSrvs;
import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TrnReport extends javax.swing.JInternalFrame {
    String cid;
    /** Creates new form CstReport */
    public TrnReport() {
       super("ಖಾತೆದಾರರ ಪಾವತಿ ವಿವರಗಳು",false,true,false,true);
        initComponents();
        MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Arial Unicode MS",Font.BOLD,16));
        cmbNames();
        cmbPlaces();
    }
    public void cmbNames()
    {
        try
        {
        int i=0;
        List lst=null;
        CustomerSrvs csrv=new CustomerSrvs();
        lst=(List)csrv.getCnamcmb();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        cnam.setModel(new javax.swing.DefaultComboBoxModel(cods));
        cnam.setMaximumRowCount(6);
        cnam.setFocusable(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Initialization Failed Please Try Again");
        }
    }
    public void cmbPlaces()
    {
        try
        {
        int i=0;
        List lst=null;
        CustomerSrvs csrv=new CustomerSrvs();
        lst=(List)csrv.getPlacecmb();
        String cods[]=new String[lst.size()];
        Iterator itm1=lst.iterator();
        while(itm1.hasNext())
        {
             cods[i]=(String)itm1.next();
             i++;
        }
        pcmb.setModel(new javax.swing.DefaultComboBoxModel(cods));
        pcmb.setMaximumRowCount(6);
        pcmb.setFocusable(true);
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

        group1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fd = new com.toedter.calendar.JDateChooser();
        td = new com.toedter.calendar.JDateChooser();
        r3 = new javax.swing.JRadioButton();
        cnam = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        r4 = new javax.swing.JRadioButton();
        pcmb = new javax.swing.JComboBox();
        reppan = new javax.swing.JDesktopPane();

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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(59, 0, 59));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(47, 3, 47));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        group1.add(r1);
        r1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        r1.setForeground(new java.awt.Color(0, 255, 0));
        r1.setText("All");
        r1.setOpaque(false);

        group1.add(r2);
        r2.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        r2.setForeground(new java.awt.Color(0, 255, 0));
        r2.setText("ಖಾತಾದಾರನ ಹೆಸರು");
        r2.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(59, 0, 59));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("ದಿನಾಂಕದಿಂದ :");

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        jLabel2.setForeground(new java.awt.Color(51, 255, 51));
        jLabel2.setText("ದಿನಾಂಕದ ವರೆಗೆ :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(fd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(fd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        group1.add(r3);
        r3.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        r3.setForeground(new java.awt.Color(0, 255, 0));
        r3.setText("ದಿನಾಂಕ");
        r3.setOpaque(false);

        cnam.setFont(new java.awt.Font("Arial Unicode MS", 1, 18)); // NOI18N
        cnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnamActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 1, 24)); // NOI18N
        jButton1.setText("ವಿಕ್ಷಿಸು");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        group1.add(r4);
        r4.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));
        r4.setForeground(new java.awt.Color(0, 255, 0));
        r4.setText("ಸ್ಥಳ");
        r4.setOpaque(false);
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        pcmb.setFont(new java.awt.Font("Arial Unicode MS", 1, 18));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(r1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cnam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(r2))
                .addGap(18, 18, 18)
                .addComponent(r3)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r4)
                        .addGap(76, 76, 76))
                    .addComponent(pcmb, 0, 140, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r2)
                            .addComponent(r3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2, Short.MAX_VALUE))
        );

        reppan.setBackground(new java.awt.Color(47, 3, 47));
        reppan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reppan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reppan, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if((r1.isSelected()==false)&&(r2.isSelected()==false)&&(r3.isSelected()==false)&&(r4.isSelected()==false)){{JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು Report ಬೆಕಾದ ವಿಧಾನವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");}}
        if((r2.isSelected()==true)&&(cnam.getSelectedIndex()==0)){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಖಾತೆಸಂಖ್ಯೆಯನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");}
        if((r3.isSelected()==true)&&((fd.getDate()==null)||(td.getDate()==null))){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ದಿನಾಂಕ್ವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");}
        if((r4.isSelected()==true)&&(pcmb.getSelectedIndex()==0)){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಸ್ಥಳವನ್ನು ಆಯ್ದುಕೊಳ್ಳಿ");}
        if(r1.isSelected()==true){genByAll();}
        if((r2.isSelected()==true)&&(cnam.getSelectedIndex()!=0)){genByName();}
        if((r3.isSelected()==true)&&((fd.getDate()!=null)||(td.getDate()!=null))){genByDate();}
        if((r4.isSelected()==true)&&(pcmb.getSelectedIndex()!=0)){genByPlace();}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r4ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        GETOC.t3=0;
    }//GEN-LAST:event_formKeyPressed

    private void cnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnamActionPerformed
        // TODO add your handling code here:
        try
        {
            CustomerSrvs csr=new CustomerSrvs();
            CstModel cstm=null;
            String cname=(String) cnam.getSelectedItem();
            cstm=(CstModel)csr.getcstBNAme(cname);
            cid=cstm.getCid();
        }catch(Exception e){JOptionPane.showMessageDialog(this,"ಹುಡುಕಲು ಸಾದ್ಯವಾಗುತಿಲ್ಲ ಪುನಃ ಪ್ರಯತ್ನಿಸಿ");}
    }//GEN-LAST:event_cnamActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        GETOC.t3=0;
    }//GEN-LAST:event_formInternalFrameClosed
    public void genByAll()
    {

    try{
            File fl=new File("src\\Forms\\Reports\\TRNall.jrxml");
            String rep=fl.getAbsolutePath();
            TrnAll repo=new TrnAll(rep);
            repo.setBounds(0, 0, reppan.getWidth(), reppan.getHeight());
            repo.setVisible(true);
            this.reppan.add(repo);
        }catch(Exception e){}
    }
    public void genByName()
    {
        HashMap param=new HashMap();
        String nam=(String) cnam.getSelectedItem();
        param.put("custid",cid);
        param.put("cname",nam);
        try
        {
            File fl=new File("src\\Forms\\Reports\\TRNByName.jrxml");
            String rep=fl.getAbsolutePath();
            TRNBnam repo=new TRNBnam(rep, param);
            repo.setBounds(0, 0, reppan.getWidth(), reppan.getHeight());
            repo.setVisible(true);
            this.reppan.add(repo);
        }catch(Exception e){}
    }
    public void genByDate()
    {
        try{
        HashMap param=new HashMap();
        java.sql.Date fdte= new java.sql.Date(fd.getDate().getTime());
        java.sql.Date tdte= new java.sql.Date(td.getDate().getTime());
        param.put("fdt",fdte);
        param.put("tdt",tdte);
        try
        {
            File fl=new File("src\\Transaction\\Reports\\Datewise.jrxml");
            String rep=fl.getAbsolutePath();
            TRNBdate repo=new TRNBdate(rep,param);
            repo.setBounds(0, 0, reppan.getWidth(), reppan.getHeight());
            repo.setVisible(true);
            this.reppan.add(repo);
        }catch(Exception e){}}catch(Exception e){}
    }
    public void genByPlace()
    {
        HashMap param=new HashMap();
        String pnam=(String) pcmb.getSelectedItem();
        param.put("place",pnam);
        try
        {
            File fl=new File("src\\Forms\\Reports\\TRNBPlace.jrxml");
            String rep=fl.getAbsolutePath();
            TRNBplace repo=new TRNBplace(rep, param);
            repo.setBounds(0, 0, reppan.getWidth(), reppan.getHeight());
            repo.setVisible(true);
            this.reppan.add(repo);
        }catch(Exception e){}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cnam;
    private com.toedter.calendar.JDateChooser fd;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox pcmb;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JDesktopPane reppan;
    private com.toedter.calendar.JDateChooser td;
    // End of variables declaration//GEN-END:variables

}
