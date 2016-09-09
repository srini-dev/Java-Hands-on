/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Products.java
 *
 * Created on Mar 20, 2015, 11:17:16 AM
 */

package Forms;

import APMCMain.GETOC;
import Forms.Models.PrdModel;
import Forms.Services.MasterSrvs;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Products extends javax.swing.JInternalFrame {
    String t1,t2,t3;
    /** Creates new form Products */
    public Products(){
        super("Master",false,true,false,true);
        initComponents();
        getTableDATA();
        save.setEnabled(false);
        update.setEnabled(false);
        MyFont.setUIFont (new javax.swing.plaf.FontUIResource ("Tunga",Font.BOLD,16));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));this.updateUI();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        p3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        p2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prdtab = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(59, 0, 59));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/1.png"))); // NOI18N
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

        jPanel1.setBackground(new java.awt.Color(85, 6, 85));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("ಉತ್ಪನ್ನ ಹೆಸರು :");

        p3.setFont(new java.awt.Font("Tunga", 1, 16));
        p3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        p3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p3KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("CODE :");

        p2.setFont(new java.awt.Font("Tunga", 1, 16));
        p2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        p2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p2KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tunga", 1, 16));
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("         ಕ್ರಂ ಸಂಖ್ಯೆ :");

        p1.setBackground(new java.awt.Color(0, 255, 0));
        p1.setFont(new java.awt.Font("Lucida Bright", 1, 14));
        p1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(260, 40, 260, 140);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setOpaque(false);

        add.setFont(new java.awt.Font("Times New Roman", 1, 12));
        add.setText("ADD");
        add.setOpaque(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Times New Roman", 1, 12));
        save.setText("SAVE");
        save.setOpaque(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveKeyPressed(evt);
            }
        });

        update.setFont(new java.awt.Font("Times New Roman", 1, 12));
        update.setText("UPDATE");
        update.setOpaque(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updateKeyPressed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Times New Roman", 1, 12));
        clear.setText("CLEAR");
        clear.setOpaque(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(save)
                    .addComponent(update)
                    .addComponent(clear))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(208, 190, 310, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/vegit.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 240, 234);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

        prdtab.setBackground(new java.awt.Color(0, 0, 0));
        prdtab.setFont(new java.awt.Font("Tunga", 1, 16));
        prdtab.setForeground(new java.awt.Color(0, 255, 0));
        prdtab.setModel(new javax.swing.table.DefaultTableModel(
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
        prdtab.setGridColor(new java.awt.Color(51, 255, 0));
        prdtab.setSelectionBackground(new java.awt.Color(51, 255, 0));
        prdtab.setSelectionForeground(new java.awt.Color(0, 0, 0));
        prdtab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prdtabKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(prdtab);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 250, 510, 180);

        jLabel5.setFont(new java.awt.Font("Tunga", 1, 18));
        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setText("ಉತ್ಪನ್ನಗಳು");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 10, 79, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        GETOC.mp=0;
    }//GEN-LAST:event_formInternalFrameClosed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        getNextPslno();
        clr();
        save.setEnabled(true);
        p2.requestFocus();
    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clr();
    }//GEN-LAST:event_clearActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        t1=p1.getText();
        t2=p2.getText();
        t3=p3.getText();
        boolean vf=validprd();
        if(vf)
        {
            boolean flag=false;
            MasterSrvs msrv=new MasterSrvs();
            flag=msrv.saveProcuts(t1, t2, t3);
            if(flag)
            {
                getTableDATA();
                JOptionPane.showMessageDialog(this, "ಉತ್ಪನ್ನವನ್ನು ಪಟ್ಟಿಗೆ ಸೆರಿಸಲಾಗಿದೆ");
                save.setEnabled(false);
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಉತ್ಪನ್ನವನ್ನು ಪಟ್ಟಿಗೆ ಸೆರಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }
    }//GEN-LAST:event_saveActionPerformed

    private void prdtabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prdtabKeyPressed
        // TODO add your handling code here:
        int k=evt.getKeyCode();
        if(k==10)
        {
            try{
            int ro=prdtab.getSelectedRow();
            t1=prdtab.getModel().getValueAt(ro,0).toString();
            MasterSrvs msrv=new MasterSrvs();
            PrdModel pm=null;
            pm=(PrdModel)msrv.getPBsno(t1);
            p1.setText(pm.getSlno());
            p2.setText(pm.getCode());
            p3.setText(pm.getProduct());
            update.setEnabled(true);
            save.setEnabled(false);
            }catch(Exception e){}
        }
        if(k==java.awt.event.KeyEvent.VK_UP)//-1
        {
            try{
            int ro=prdtab.getSelectedRow();
            t1=prdtab.getModel().getValueAt(ro-1,0).toString();
            MasterSrvs msrv=new MasterSrvs();
            PrdModel pm=null;
            pm=(PrdModel)msrv.getPBsno(t1);
            p1.setText(pm.getSlno());
            p2.setText(pm.getCode());
            p3.setText(pm.getProduct());
            update.setEnabled(true);
            save.setEnabled(false);
            }catch(Exception e){}

        }
        if(k==java.awt.event.KeyEvent.VK_DOWN)//+1
        {
            try{
            int ro=prdtab.getSelectedRow();
            t1=prdtab.getModel().getValueAt(ro+1,0).toString();
            MasterSrvs msrv=new MasterSrvs();
            PrdModel pm=null;
            pm=(PrdModel)msrv.getPBsno(t1);
            p1.setText(pm.getSlno());
            p2.setText(pm.getCode());
            p3.setText(pm.getProduct());
            update.setEnabled(true);
            save.setEnabled(false);
            }catch(Exception e){}

        }
    }//GEN-LAST:event_prdtabKeyPressed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        t1=p1.getText();
        t2=p2.getText();
        t3=p3.getText();
        boolean vf=validprd();
        if(vf)
        {
            boolean flag=false;
            MasterSrvs msrv=new MasterSrvs();
            flag=msrv.Updatproduct(t1, t2, t3);
            if(flag)
            {
                getTableDATA();
                JOptionPane.showMessageDialog(this, "ಉತ್ಪನ್ನವನ್ನು ಬದಲಿಸಲಾಗಿದೆ");
                update.setEnabled(false);
            }else{JOptionPane.showMessageDialog(this, "ಕ್ಷಮಿಸಿ ಉತ್ಪನ್ನವನ್ನು ಬದಲಿಸಲು ಸಾದ್ಯವಾಗುತ್ತಿಲ್ಲ");}
        }
    }//GEN-LAST:event_updateActionPerformed

    private void p2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            p3.requestFocus();
        }
    }//GEN-LAST:event_p2KeyPressed

    private void p3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            save.requestFocus();
        }
    }//GEN-LAST:event_p3KeyPressed

    private void saveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            save.doClick();
        }
    }//GEN-LAST:event_saveKeyPressed

    private void updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            update.doClick();
        }
    }//GEN-LAST:event_updateKeyPressed
    private boolean validprd()
    {
        if(t2.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ code ನಮೊದಿಸಿ");return false;}
        if(t3.length()==0){JOptionPane.showMessageDialog(this, "ದಯವಿಟ್ಟು ಉತ್ಪನ್ನದ ಹೆಸರನ್ನು ನಮೊದಿಸಿ");return false;}
        return true;
    }
    public void clr()
    {
        p2.setText("");
        p3.setText("");
    }
    public void getNextPslno()
    {
        MasterSrvs msr=new MasterSrvs();
        List ls=null;
        ls= msr.getNextPSLNO();
        int cod=ls.size();
        int nex=cod+1;
        p1.setText(String.valueOf(nex));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel p1;
    private javax.swing.JTextField p2;
    private javax.swing.JTextField p3;
    private javax.swing.JTable prdtab;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
    public void getTableDATA()
    {
        int i=0,j=0;
        MasterSrvs msrv=new MasterSrvs();
        PrdModel pm=null;
        List lst=new LinkedList();
        lst=(List)msrv.getProductTab();
        Object dat[][]=new Object[lst.size()][5];
        String col[]={"ಕ್ರಂ ಸಂಖ್ಯೆ","CODE", "ಉತ್ಪನ್ನಗಳು"};
        Iterator itm=lst.iterator();
        while(itm.hasNext())
        {
            pm=(PrdModel)itm.next();
            dat[i][0]=(String)pm.getSlno();
            dat[i][1]=(String)pm.getCode();
            dat[i][2]=(String)pm.getProduct();
            i++;
        }
       DefaultTableModel dm=new DefaultTableModel(dat,col);
       prdtab.setModel(dm);
       prdtab.setAutoResizeMode(prdtab.AUTO_RESIZE_OFF);
       prdtab.getColumnModel().getColumn(0).setPreferredWidth(80);
       prdtab.getColumnModel().getColumn(1).setPreferredWidth(90);
       prdtab.getColumnModel().getColumn(2).setPreferredWidth(120);
    }
}
